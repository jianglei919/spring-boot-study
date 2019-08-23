package com.example.springboot.demo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by jianglei on 2019/5/9.
 */
@Component("timeOutWork")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TimeOutWork<T> implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(TimeOutWork.class);

    private T t;

    public TimeOutWork() {
    }

    public TimeOutWork(T t) {
        this.t = t;
    }

    @Override
    public void run() {
        logger.info("任务超时，线程名：{}", Thread.currentThread().getName());
        if (t != null && t instanceof DeferredResult) {
//            ((DeferredResult) t).setErrorResult("我超时了");
            logger.info("我超时了");
        } else {
            logger.info("result_timeOut_is_null_or_no_deferredResult, DeferredResult={}", t);
        }
    }
}
