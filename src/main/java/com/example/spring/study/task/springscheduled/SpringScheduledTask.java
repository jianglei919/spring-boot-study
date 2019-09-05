package com.example.spring.study.task.springscheduled;

import com.example.spring.study.common.DateConstant;
import com.example.spring.study.task.BaseTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jianglei on 2019/9/4.
 */
@Component
@EnableScheduling
@Slf4j
public class SpringScheduledTask extends BaseTask {

//    @Scheduled(fixedRate = 5000) //上一次开始执行时间点之后5秒再执行
//    @Scheduled(fixedDelay = 5000) //上一次执行完毕时间点之后5秒再执行
//    @Scheduled(initialDelay = 1000, fixedRate = 5000) // 第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
//    @Scheduled(cron = "0/5 * * * * ?") //通过cron表达式定义规则
    public void work() {
        String currDateTime = FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME_SSS).format(new Date());
        log.info("{} SpringScheduledTask is running!", currDateTime);
        randomSleep();
    }
}
