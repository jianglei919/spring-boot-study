package com.example.spring.study.task.quartz;

import com.example.spring.study.common.DateConstant;
import com.example.spring.study.task.BaseTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by jianglei on 2019/9/5.
 */
@Slf4j
public class QuartzJobTask1 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String currentDate = FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME).format(new Date());
        log.info("{} QuartzJobTask1 is running!", currentDate);
        BaseTask.randomSleep();
    }
}
