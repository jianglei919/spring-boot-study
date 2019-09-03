package com.example.spring.study.advise;


import com.example.spring.study.util.JacksonUtil;
import com.example.spring.study.util.ApiResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.AbstractErrors;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.Format;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LogAdvise {

    private static final List<Class<?>> ignoreClasses = Arrays.asList(
            HttpSession.class, AbstractErrors.class, OncePerRequestFilter.class, ServletRequest.class,
            ServletResponse.class, Format.class);

    private static final List<String> ignoreMethod = Arrays.asList("HelloController.index(..)");

    @Resource
    private HttpServletRequest request;

    @Pointcut("execution(* com.example.spring.study.web.controller..*(..)) && @annotation(io.swagger.annotations.ApiOperation)")
    public void controller() {
    }

    @Pointcut("execution(* com.example.spring.*.*.*.service.*.*(..)))")
    public void service() {
    }

    @Around("controller()")
    public Object printLog(ProceedingJoinPoint pJoinPoint) throws Throwable {
        Logger targetLogger = LoggerFactory.getLogger(pJoinPoint.getTarget().getClass());
        Object returnObject;
        try {
            Map<String, String> argsReturn = new HashMap<>();
            String ip = getIpAddress(request);
            String argParams = toJsonString(pJoinPoint.getArgs());
            String shortMethod = pJoinPoint.getSignature().toShortString();
            String reqMethod = pJoinPoint.getSignature().getName();
            String reqType = request.getMethod();
            String reqURI = request.getRequestURI();// 请求path
            MethodSignature signature = (MethodSignature) pJoinPoint.getSignature();
            Method method = signature.getMethod();

            if (ignoreMethod.contains(shortMethod)) {
                String argsMarker = "method " + pJoinPoint.getSignature().toShortString();
                argsReturn.put("警告", "日志涉及个人隐私，日志不输出");
                targetLogger.info(argsMarker, "{}", argsReturn);
                return pJoinPoint.proceed();
            }
            String function = null;
            if (method.isAnnotationPresent(ApiOperation.class)) {
                ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
                function = apiOperation.value();
            }
            long start = System.currentTimeMillis();
            returnObject = pJoinPoint.proceed();
            long costTime = System.currentTimeMillis() - start;
            String retResult = toJsonString(new Object[]{returnObject});
            LogParamBean paramBean = new LogParamBean(targetLogger, pJoinPoint, ip, reqType, reqMethod, reqURI, argParams,
                    retResult, function, costTime);
            this.printRequestLog(paramBean);
        } catch (Exception e) {
            log.error("print log error", e);
            return ApiResult.failed();
        }
        return returnObject;
    }

    protected String toJsonString(Object[] objects) {
        String res = "";
        try {
            StringBuilder builder = new StringBuilder();
            boolean isFirst = true;
            for (Object object : objects) {
                if (!isAgrClass(object)) {
                    if (isFirst) {
                        isFirst = false;
                    } else {
                        builder.append(",");
                    }
                    res = JacksonUtil.parseJson(object);
                    builder.append(res);
                }
            }
            res = builder.toString();
        } catch (Throwable e) {
            log.error("log interceptor error", e);
        }
        return res;
    }

    private boolean isAgrClass(Object o) {
        if (null == o) {
            return false;
        }
        for (final Class cls : ignoreClasses) {
            if (cls.isAssignableFrom(o.getClass())) {
                return true;
            }
        }
        return false;
    }

    private void printRequestLog(LogParamBean paramBean) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>begin>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        sb.append("ip          : ").append(paramBean.getIp()).append("\n");
        sb.append("url         : ").append(paramBean.getReqURI()).append("\n");
        sb.append("requestType : ").append(paramBean.getReqType()).append("\n");
        if (paramBean.getFunction() != null || !"".equals(paramBean.getFunction())) {
            sb.append("function    : ").append(paramBean.getFunction()).append("\n");
        }
        sb.append("Controller  : ").append(paramBean.getJoinPoint().getTarget().getClass().getName()).append(".(")
                .append(paramBean.getJoinPoint().getTarget().getClass().getSimpleName()).append(".java:1)\n");
        sb.append("reqMethod   : ").append(paramBean.getReqMethod()).append("\n");
        sb.append("args_params : ").append(paramBean.getArgsParams() + "\n");
        sb.append("return      : ").append(paramBean.getRetResult()).append("\n");
        sb.append("time        : ").append(paramBean.getCostTime()).append("ms\n");
        sb.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<end<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        paramBean.getTargetLogger().info(sb.toString());
    }

    /**
     * 通过HttpServletRequest返回IP地址
     *
     * @param request HttpServletRequest
     * @return ip String
     * @throws Exception
     */
    public String getIpAddress(HttpServletRequest request) {
        String ip = "";
        try {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }

        } catch (Exception e) {
            log.error("get ip address error", e);
        }
        return ip;
    }

    class LogParamBean {
        private Logger targetLogger;
        private JoinPoint joinPoint;
        private String ip;
        private String reqType;
        private String reqMethod;
        private String reqURI;
        private String argsParams;
        private String retResult;
        private String function;
        private long costTime;

        public LogParamBean() {
        }

        public LogParamBean(Logger targetLogger, JoinPoint joinPoint, String ip, String reqType, String reqMethod,
                            String reqURI, String argsParams, String retResult, String function, long costTime) {
            this.targetLogger = targetLogger;
            this.joinPoint = joinPoint;
            this.ip = ip;
            this.reqType = reqType;
            this.reqMethod = reqMethod;
            this.reqURI = reqURI;
            this.argsParams = argsParams;
            this.retResult = retResult;
            this.function = function;
            this.costTime = costTime;
        }

        public Logger getTargetLogger() {
            return targetLogger;
        }

        public void setTargetLogger(Logger targetLogger) {
            this.targetLogger = targetLogger;
        }

        public JoinPoint getJoinPoint() {
            return joinPoint;
        }

        public void setJoinPoint(JoinPoint joinPoint) {
            this.joinPoint = joinPoint;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getReqType() {
            return reqType;
        }

        public void setReqType(String reqType) {
            this.reqType = reqType;
        }

        public String getReqMethod() {
            return reqMethod;
        }

        public void setReqMethod(String reqMethod) {
            this.reqMethod = reqMethod;
        }

        public String getReqURI() {
            return reqURI;
        }

        public void setReqURI(String reqURI) {
            this.reqURI = reqURI;
        }

        public String getArgsParams() {
            return argsParams;
        }

        public void setArgsParams(String argsParams) {
            this.argsParams = argsParams;
        }

        public String getRetResult() {
            return retResult;
        }

        public void setRetResult(String retResult) {
            this.retResult = retResult;
        }

        public long getCostTime() {
            return costTime;
        }

        public void setCostTime(long costTime) {
            this.costTime = costTime;
        }

        public String getFunction() {
            return function;
        }

        public void setFunction(String function) {
            this.function = function;
        }
    }
}
