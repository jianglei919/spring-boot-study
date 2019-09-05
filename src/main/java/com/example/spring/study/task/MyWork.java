package com.example.spring.study.task;

import com.example.spring.study.common.DateConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * Created by jianglei on 2019/9/4.
 */
@Slf4j
public class MyWork extends BaseTask{

    public void work() {
        String currDateTime = FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME_SSS).format(new Date());
        log.info("{} SchedulingConfigurerTask is running!", currDateTime);
        randomSleep();
    }
}
