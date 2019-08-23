package com.example.springboot.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jianglei on 2019/5/17.
 */
public class FlowLimitControlFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(FlowLimitControlFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        boolean limit = true;
        try {

            limit = preHandle(req, resp);
        } catch (Exception e) {
            logger.error("拦截异常：", e);
        } finally {
            if (!limit){
                return;
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //必须实现init方法和destroy方法，否则会报错java.lang.AbstractMethodError，
        // 因为我使用的maven构建的web项目，javax.servlet-api-4.0.1.jar包也是maven提供的，
        // 因此会和tomcat中的包版本不同。而maven包中就是定义了init和destroy两个default方法，但是tomcat中的包中定义的却是抽象方法，因此必须实现。
    }

    @Override
    public void destroy() {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("preHandle isAsyncStarted={}", request.isAsyncStarted());
        int r = Integer.valueOf(request.getParameter("id"));
        boolean limit = r % 2 == 1;
        if(!limit){
            //偶数限流
            String errorMsg = "你被限流啦";
            request.setAttribute("SYSTEM_MSG_CODE", errorMsg);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, errorMsg);
            logger.info(errorMsg);
            return limit;
        }
        return true;
    }
}
