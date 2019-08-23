package com.example.spring.study.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.*;

@Component
public class AsyncProcessExecutor {

    private static final Logger logger = LoggerFactory.getLogger(AsyncProcessExecutor.class);

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("async-search-%d").build();

    public static int capacity = 5000;

    public static int corePoolSize = Runtime.getRuntime().availableProcessors();;

    private static ExecutorService pool = new ThreadPoolExecutor(corePoolSize, corePoolSize, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(capacity), namedThreadFactory, new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            logger.error("api_async_search_executor_reject");
        }
    });


    @PreDestroy
    private void destroy(){
        pool.shutdown();
        if(!pool.isShutdown()){
            try {
                pool.awaitTermination(2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                logger.error("并发线程池关闭异常",e);
            }
            pool.shutdownNow();
        }
    }

    public void executeWorkTask(Runnable runnable) {
        pool.execute(runnable);
    }

}
