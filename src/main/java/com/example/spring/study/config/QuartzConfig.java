package com.example.spring.study.config;

import com.example.spring.study.task.quartz.QuartzJobTask1;
import com.example.spring.study.task.quartz.QuartzJobTask2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jianglei on 2019/9/5.
 */
//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail quartzJob1() {
        return JobBuilder.newJob(QuartzJobTask1.class).withIdentity("quartzJobTask1").storeDurably().build();
    }

    @Bean
    public Trigger quartzJobTrigger1() {
        //5s执行一次，不受任务执行耗时影响，固定5s执行一次，存在上一个任务没执行玩，下一个任务开始执行
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();
        return TriggerBuilder.newTrigger().forJob(quartzJob1())
                .withIdentity("quartzJobTask1")
                .withSchedule(simpleScheduleBuilder).build();
    }

    @Bean
    public JobDetail quartzJob2() {
        return JobBuilder.newJob(QuartzJobTask2.class).withIdentity("quartzJobTask2").storeDurably().build();
    }

    @Bean
    public Trigger quartzJobTrigger2() {
        //corn方式，5s一次, 不受任务执行耗时影响，固定5s执行一次，存在上一个任务没执行玩，下一个任务开始执行
        return TriggerBuilder.newTrigger().forJob(quartzJob2())
                .withIdentity("quartzJobTask2")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();
    }
}
