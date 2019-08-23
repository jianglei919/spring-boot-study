package com.example.springboot.demo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * Created by jianglei on 2019/5/9.
 */
@Component("completeWork")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompleteWork<T> implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(CompleteWork.class);

    private T t;

    public CompleteWork() {
    }

    public CompleteWork(T t) {
        this.t = t;
    }

    @Override
    public void run() {
        logger.info("任务完成回调，线程名：{}", Thread.currentThread().getName());
        if (t instanceof WebAsyncTask) {
            if (((WebAsyncTask) t).getTimeout() > 0) {//没啥用，超时之后返回值也是大于0
                logger.info("WebAsyncTask:我执行完啦!");
            }
        } else if (t instanceof DeferredResult) {
            logger.info("DeferredResult结果:{}", ((DeferredResult) t).isSetOrExpired());
            if (!((DeferredResult) t).isSetOrExpired()) {
                logger.info("DeferredResult:我执行完啦!");
            }
        }
    }
}
