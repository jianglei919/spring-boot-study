package com.example.spring.study.task.executor;

import com.example.spring.study.common.DateConstant;
import com.example.spring.study.task.BaseTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jianglei on 2019/9/5.
 */
@Slf4j
public class ScheduledExecutorTask {

    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    public static void work() {
        //受上一次定时任务耗时影响，下次开始时间=上次任务结束时间 + 任务耗时  （连续执行，当线程资源不足，忽略当次调度）
        executor.scheduleAtFixedRate(() -> {
            String currTime = FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME).format(new Date());
            log.info("{} {} ScheduledExecutorTask1 is running!", currTime, Thread.currentThread().getName());
            BaseTask.randomSleep();
        }, 10, 5, TimeUnit.SECONDS);

        //下次开始时间=delay时间 + 任务耗时
        executor.scheduleWithFixedDelay(() -> {
            String currTime = FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME).format(new Date());
            log.info("{} {} ScheduledExecutorTask2 is running!", currTime, Thread.currentThread().getName());
            BaseTask.randomSleep();
        }, 10, 5, TimeUnit.SECONDS);
    }
}
