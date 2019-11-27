package com.example.spring.study.utils;

import com.example.spring.study.util.CalendarUtils;
import com.example.spring.study.util.DateTimeScope;
import com.example.spring.study.util.JacksonUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jianglei on 2019/8/23.
 */
public class DateTest {

    @Test
    public void test1() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start(); //开始
        Thread.sleep(100);
        stopWatch.stop();//停止
        System.out.println(stopWatch.getTime());
        System.out.println(stopWatch.getStartTime());
        System.out.println(stopWatch);

        stopWatch.reset();
        Thread.sleep(200);
//        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    @Test
    public void test2() {
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.sss").format(new Date()));
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm").format(new Date()));
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH").format(new Date()));
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd").format(new Date()));
        System.out.println(FastDateFormat.getInstance("yyyy-MM").format(new Date()));
        System.out.println(FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss").format(new Date()));
        System.out.println(FastDateFormat.getInstance("yyyyMMdd HH:mm:ss").format(new Date()));

        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.sss").format(1566536972112L));
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(1566536972112L));

        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(Calendar.DAY_OF_YEAR));
    }

    @Test
    public void test3() {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtils.format(new Date(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern()));
    }

    @Test
    public void test4() throws ParseException {
        Date tomorrow = DateUtils.addDays(new Date(), 1);
        Date today = new Date();
        Date yesterday = DateUtils.addDays(new Date(), -1);
        System.out.println(tomorrow);
        System.out.println(today);
        System.out.println(yesterday);
        System.out.println(DateUtils.isSameDay(tomorrow, today));

        System.out.println(DateUtils.parseDate("2017-06-03 23:51:44", new String[]{"yyyy-MM-dd HH:mm:ss"})); // 2017-06-03 23:51:44
        System.out.println(DateUtils.parseDate("2017年06月03日 23时51分44秒", new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy年MM月dd日 HH时mm分ss秒"}));
    }

    @Test
    public void test5() {
        DateUtils.round(new Date(), Calendar.YEAR); // 2017-01-01 00:00:00
        DateUtils.round(new Date(), Calendar.MONTH); // 2017-06-01 00:00:00
        Date date = DateUtils.round(new Date(), Calendar.HOUR_OF_DAY); // 2017-06-04 01:00:00
        DateUtils.round(new Date(), Calendar.DAY_OF_MONTH); // 2017-06-04 00:00:00
        DateUtils.round(new Date(), Calendar.HOUR); // 2017-06-04 01:00:00
        DateUtils.round(new Date(), Calendar.MINUTE); // 2017-06-04 00:45:00
        DateUtils.round(new Date(), Calendar.SECOND); // 2017-06-04 00:44:43

        System.out.println(date);

        // 当前时间为'2017-06-04 00:56:05'，则执行以下代码
        DateUtils.truncate(new Date(), Calendar.YEAR); // 2017-01-01 00:00:00
        DateUtils.truncate(new Date(), Calendar.MONTH); // 2017-06-01 00:00:00
        DateUtils.truncate(new Date(), Calendar.HOUR_OF_DAY); // 2017-06-04 00:00:00
        date = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH); // 2017-06-04 00:00:00
        DateUtils.truncate(new Date(), Calendar.HOUR); // 2017-06-04 00:00:00
        DateUtils.truncate(new Date(), Calendar.MINUTE); // 2017-06-04 00:56:00
        DateUtils.truncate(new Date(), Calendar.SECOND); // 2017-06-04 00:56:05

        System.out.println(date);
    }

    @Test
    public void test6() {
        DateTimeScope dateTimeScope = CalendarUtils.getDayTime();

        System.out.println(JacksonUtil.parseJson(dateTimeScope));

        String d1 =  FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(dateTimeScope.getStartTime());

        System.out.println(d1);

        String d2 =  FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(dateTimeScope.getEndTime());

        System.out.println(d2);
    }

    @Test
    public void test7() throws ParseException {
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").parse("2019-11-27 12:11:26"));
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm").parse("2019-11-27 12:11:26"));
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd").parse("2019-11-27 12:11:26"));
    }

    /**
     * LocalDate转Date
     */
    @Test
    public void test8() {
        LocalDate localDate = LocalDate.now().minusDays(1);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(localDate);
        System.out.println(date);
    }

    /**
     * Date转LocalDate
     */
    @Test
    public void test9() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(date);
        System.out.println(localDate);
    }
}
