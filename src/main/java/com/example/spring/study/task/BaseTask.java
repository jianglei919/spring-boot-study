package com.example.spring.study.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by jianglei on 2019/9/4.
 */
@Slf4j
public class BaseTask {

    public static void randomSleep() {
        try {
            int random = RandomUtils.nextInt(3, 8);
            random = 8;
            log.info("睡眠{}s", random);
            Thread.sleep(TimeUnit.SECONDS.toMillis(random));
        } catch (InterruptedException e) {
            log.error("InterruptedException", e);
        }
    }
}
