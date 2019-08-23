package com.example.springboot.demo.config;

import com.example.springboot.demo.interceptors.CompleteAsyncHandlerInterceptor;
import com.example.springboot.demo.interceptors.TimeoutAsyncHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

import javax.annotation.Resource;

/**
 * Created by jianglei on 2019/5/13.
 */
//@Configuration
public class AsyncMvcConfig extends AsyncSupportConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(AsyncMvcConfig.class);

    @Resource
    private CompleteAsyncHandlerInterceptor completeAsyncHandlerInterceptor;

    @Resource
    private TimeoutAsyncHandlerInterceptor timeoutAsyncHandlerInterceptor;

//    @Override
//    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.registerDeferredResultInterceptors(completeAsyncHandlerInterceptor, timeoutAsyncHandlerInterceptor);
//        super.configureAsyncSupport(configurer);
//    }


    @Override
    public AsyncSupportConfigurer registerDeferredResultInterceptors(DeferredResultProcessingInterceptor... interceptors) {
        return super.registerDeferredResultInterceptors(completeAsyncHandlerInterceptor, timeoutAsyncHandlerInterceptor);
    }
}
