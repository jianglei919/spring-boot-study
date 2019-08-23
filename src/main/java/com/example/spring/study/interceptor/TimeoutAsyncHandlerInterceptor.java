package com.example.springboot.demo.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.TimeoutDeferredResultProcessingInterceptor;

/**
 * Created by jianglei on 2019/5/14.
 */
@Component
public class TimeoutAsyncHandlerInterceptor extends TimeoutDeferredResultProcessingInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TimeoutAsyncHandlerInterceptor.class);

    @Override
    public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> result) throws Exception {
        logger.info("timeOut");
        return super.handleTimeout(request, result);
    }
}
