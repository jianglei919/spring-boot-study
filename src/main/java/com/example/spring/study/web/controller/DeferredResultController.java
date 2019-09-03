package com.example.spring.study.web.controller;

import com.example.spring.study.thread.AsyncProcessExecutor;
import com.example.spring.study.thread.async.CompleteWork;
import com.example.spring.study.thread.async.TimeOutWork;
import com.example.spring.study.thread.async.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jianglei on 2019/5/9.
 */
@RestController
public class DeferredResultController {

    private static final Logger logger = LoggerFactory.getLogger(DeferredResultController.class);

    //业务处理线程池
    private final ExecutorService pool = Executors.newFixedThreadPool(5);

    ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

    @Resource
    private AsyncProcessExecutor asyncProcessExecutor;

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/deferred")
    public DeferredResult<String> deferred(HttpServletRequest request) {
        long start = System.currentTimeMillis();
        logger.info("当前请求主线程名：{}", Thread.currentThread().getName());
        DeferredResult<String> deferredResult = new DeferredResult<>(10000L);//5s
        dealInOtherThread(deferredResult);
        logger.info("主线程执行完毕, 耗时：{}", System.currentTimeMillis() - start);
        return deferredResult;
    }

    private void dealInOtherThread(final DeferredResult<String> deferredResult) {
        deferredResult.onTimeout((applicationContext.getBean(TimeOutWork.class, deferredResult)));
        deferredResult.onCompletion((CompleteWork) applicationContext.getBean("completeWork", deferredResult));
        Work<DeferredResult> work = applicationContext.getBean(Work.class, deferredResult);
        asyncProcessExecutor.executeWorkTask(work);
    }

    @RequestMapping("/deferred1")
    @ResponseBody
    public DeferredResult<String> deferred1() {
        long start = System.currentTimeMillis();
        logger.info("当前请求主线程名：{}", Thread.currentThread().getName());
        DeferredResult<String> deferredResult = new DeferredResult<>(150000L);//5s
        dealInOtherThread1(deferredResult);
        logger.info("主线程执行完毕, 耗时：{}", System.currentTimeMillis() - start);
        return deferredResult;
    }

    private void dealInOtherThread1(final DeferredResult<String> deferredResult) {
        deferredResult.onTimeout(new TimeOutWork(deferredResult));
        deferredResult.onCompletion(new CompleteWork(deferredResult));
//        pool.execute(new Work<DeferredResult>(deferredResult));
        service.schedule(new Work<DeferredResult>(deferredResult), 60, TimeUnit.SECONDS);
    }

    /**
     * 这种方法跟上面的WebAsyncTask类似，超时之后也会调用onCompletion函数。所以我们需要在回调函数中增加超时的判断。
     * 上面的方法中DeferredResult可以通过isSetOrExpired()来判断，但是WebAsyncTask还不知道如何判断。还有一点就是DeferredResult是在设置deferredResult.setResult(…)的时候就响应客户端，而WebAsyncTask是直接return。
     * @return
     */
    @RequestMapping("/deferred2")
    @ResponseBody
    public DeferredResult<String> deferred2() {
        long start = System.currentTimeMillis();
        logger.info("当前请求主线程名：{}", Thread.currentThread().getName());
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L);
        dealInOtherThread2(deferredResult);
        logger.info("主线程执行完毕, 耗时：{}", System.currentTimeMillis() - start);
        return deferredResult;
    }

    private void dealInOtherThread2(DeferredResult<String> deferredResult) {
        deferredResult.onTimeout(new TimeOutWork(deferredResult));
        deferredResult.onCompletion(new CompleteWork(deferredResult));
        new Thread(new Work(deferredResult)).start();
    }

    @RequestMapping("/deferred3")
    @ResponseBody
    public DeferredResult<String> deferred3() {
        long start = System.currentTimeMillis();
        logger.info("当前请求主线程名：{}", Thread.currentThread().getName());
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L);
        dealInOtherThread3(deferredResult);
        logger.info("主线程执行完毕, 耗时：{}", System.currentTimeMillis() - start);
        return deferredResult;
    }

    private void dealInOtherThread3(DeferredResult<String> deferredResult) {
        deferredResult.onTimeout(new TimeOutWork(deferredResult));
        deferredResult.onCompletion(new CompleteWork(deferredResult));
        try {
            logger.info("业务操作开始，当前线程名：{}", Thread.currentThread().getName());
            Thread.sleep(2000);
            deferredResult.setResult("业务处理完成" + System.currentTimeMillis());
            logger.info("业务操作完成");
        } catch (InterruptedException e) {
            logger.error("InterruptedException: ", e);
        }
    }
}
