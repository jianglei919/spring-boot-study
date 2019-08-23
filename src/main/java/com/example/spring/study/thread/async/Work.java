package com.example.spring.study.thread.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;

/**
 * Created by jianglei on 2019/5/9.
 */
@Component("work")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Work<T> implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Work.class);

    private T t;

    public Work() {
    }

    public Work(T t) {
        this.t = t;
        if (t != null && t instanceof DeferredResult) {
            DeferredResult deferredResult = ((DeferredResult) t);
        }
    }

    @Override
    public void run() {
        logger.info("业务开始执行，线程名：{}", Thread.currentThread().getName());
        try {
            Thread.sleep(randomInt());
            long time = System.currentTimeMillis();
            if (t instanceof DeferredResult) {
                ((DeferredResult) t).setResult("业务处理完成" + time);
            }
            logger.info("业务执行完成" + time);
        } catch (InterruptedException e) {
            logger.error("InterruptedException:", e);
        }
    }

    private static int randomInt() {
        int max = 1500;
        int min = 500;
        Random random = new Random();

        int r = random.nextInt(max) % (max - min + 1) + min;
        return r;
    }
}
