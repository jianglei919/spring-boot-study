package com.example.spring.study.task.timer;

import com.example.spring.study.common.DateConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by jianglei on 2019/9/4.
 */
@Slf4j
public class TimerTaskDemo extends TimerTask {

    @Override
    public void run() {
        String currDateTime = FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME).format(new Date());
        log.info("{} Task is running!", currDateTime);

        try {
            int random = RandomUtils.nextInt(15, 25);
            log.info("TimerTaskDemo随机睡眠{}s", random);
            Thread.sleep(TimeUnit.SECONDS.toMillis(random));
        } catch (InterruptedException e) {
            log.error("TimerTaskDemo InterruptedException", e);
        }
    }
}
