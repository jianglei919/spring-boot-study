package com.example.spring.study.web.controller;

import com.example.spring.study.thread.async.CompleteWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by jianglei on 2019/5/8.
 */
@RestController
@RequestMapping("/async")
public class AsyncTestController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTestController.class);

    private SseEmitter sseEmitter = new SseEmitter();


    /**
     * 这种方法可以实现异步请求，但是没有设置超时时间和相关超时回调。只是客户端发起请求，服务端保证执行完成即可，
     * 然后将直接成功的结果返回给客户端，客户端根绝返回值判断是否需要发起另一个请求。
     *
     * @return
     */
    @RequestMapping("/callable")
    @ResponseBody
    public Callable<String> callableTest() {
        logger.info("当前线程名：{}", Thread.currentThread().getName());
        Callable<String> c = () -> {
            logger.info("当前线程名：{}", Thread.currentThread().getName());
            Thread.sleep(10000);
            return "success";
        };

        return c;
    }


    /**
     * 这种方法通过使用spring的WebAsyncTask实现了异步请求，并且可以设置超时时间，
     * 以及超时和完成之后的回调函数。需要注意的是，超时之后也会回调onCompletion中设置方法。
     *
     * @return
     */
    @RequestMapping("/webAsyncTask")
    @ResponseBody
    public WebAsyncTask<String> webAsyncTask() {

        logger.info("当前线程名：{}", Thread.currentThread().getName());
        Callable<String> asyncTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("当前线程名：{}", Thread.currentThread().getName());
                Thread.sleep(10000);
                return "Callable Result";//超时之后不会执行返回操作，但是return之前的能够执行完成
            }
        };
        logger.info("已交给服务线程处理");
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<String>(5000, asyncTask);
        webAsyncTask.onCompletion(new CompleteWork(webAsyncTask));
        webAsyncTask.onTimeout(timeOutCallBack());
        logger.info("主线程执行完毕");
        return webAsyncTask;
    }


    /**
     * 返回SseEmitter对象
     * @return
     */
    @RequestMapping("/sseEmitter")
    public SseEmitter sseEmitter() {
        return sseEmitter;
    }

    /**
     * 向SseEmitter对象发送数据
     * @return
     */
    @RequestMapping("/setSseEmitter")
    public String setSseEmitter() {
        try {
            sseEmitter.send(System.currentTimeMillis());
        } catch (IOException e) {
            logger.error("IOException", e);
            return "error";
        }
        return "set success";
    }

    /**
     * 将SseEmitter对象设置成完成
     * @return
     */
    @RequestMapping("/completeSseEmitter")
    public String completeSseEmitter() {
        sseEmitter.complete();

        return "succeed!";
    }

    public Callable<String> timeOutCallBack() {

        Callable<String> callback = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("当前线程名：{}", Thread.currentThread().getName());
                logger.info("我超时了");
                return "我超时了";
            }
        };
        return callback;
    }

}
