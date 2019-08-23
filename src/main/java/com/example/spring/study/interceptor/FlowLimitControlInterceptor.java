package com.example.spring.study.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 限流拦截器
 */
public class FlowLimitControlInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(FlowLimitControlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle isAsyncStarted={}", request.isAsyncStarted());
        int r = Integer.valueOf(request.getParameter("id"));
        boolean limit = r % 2 == 1;
        if(!limit){
            //偶数限流
            String errorMsg = "你被限流啦";
            log.debug(errorMsg);
            request.setAttribute("SYSTEM_MSG_CODE", errorMsg);
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            log.info(errorMsg);
            return limit;
        }
        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle isAsyncStarted={}", request.isAsyncStarted());
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion isAsyncStarted={}", request.isAsyncStarted());
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("afterConcurrentHandlingStarted isAsyncStarted={}", request.isAsyncStarted());
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
