package com.example.spring.study.task.springscheduled;

import com.example.spring.study.task.MyWork;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jianglei on 2019/9/4.
 */
@Slf4j
//@Configuration
//@EnableScheduling
public class SchedulingConfigurerTask implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());

        //5s的基础上+执行时间=下次执行时间
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                myWork().work();
            }
        }, new PeriodicTrigger(5, TimeUnit.SECONDS));

        //如果执行时间大于5s,则跳到下下个5秒执行
//        taskRegistrar.addCronTask(new Runnable() {
//            @Override
//            public void run() {
//                myWork().work();
//            }
//        }, "0/5 * * * * ?");

        //5s的基础上+执行时间=下次执行时间
//        taskRegistrar.addFixedDelayTask(new Runnable() {
//            @Override
//            public void run() {
//                myWork().work();
//            }
//        }, TimeUnit.SECONDS.toMillis(5)); //5+4s睡眠
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(3);
    }

    public MyWork myWork() {
        return new MyWork();
    }
}
