package com.example.spring.study.task;

import com.example.spring.study.common.DateConstant;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Date;

/**
 * Created by jianglei on 2019/9/4.
 */
public class CornTest {

    @Test
    public void Test1() {
        CronSequenceGenerator generator = new CronSequenceGenerator("0 15 * * * MON-FRI");
        Date next = generator.next(new Date());
        System.out.println(FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME).format(next));
        System.out.println(FastDateFormat.getInstance(DateConstant.PATTERN_FULL_DATE_TIME).format(generator.next(next)));
    }
}
