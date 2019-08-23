package com.example.spring.study.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日历
 *
 * @author think
 *
 */
public class CalendarUtils {

    /**
     * 星期
     */
    private static int[] weeks = new int[] { 7, 1, 2, 3, 4, 5, 6 };

    /**
     * 获取当前时间是星期几
     *
     * @return
     */
    public static int getWeek() {

        GregorianCalendar calendar = new GregorianCalendar();
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        return weeks[week - 1];
    }

    /**
     * 获取当前时间是这个月的第几天
     *
     * @return
     */
    public static int getMonthDay() {

        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前时间的小时值
     *
     * @return
     */
    public static int getHour() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 根据当前时间，增加或减少年份
     *
     * @param curentTime
     *            当前时间
     * @param yearCount
     *            年份
     * @return
     */
    public static Date insertYear(Date curentTime, int yearCount) {

        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(curentTime);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + yearCount);

        return calendar.getTime();
    }

    /**
     * 获取周的时间范围（周一至当前时间）
     *
     * @return
     */
    public static DateTimeScope getWeekTime() {

        GregorianCalendar calendar = new GregorianCalendar();
        int timevalue = 0;

        int hour = 23 - calendar.get(Calendar.HOUR_OF_DAY);
        int minute = 59 - calendar.get(Calendar.MINUTE);
        int second = 60 - calendar.get(Calendar.SECOND);
        int weekValue = CalendarUtils.getWeek();

        timevalue = (hour * 3600000) + (minute * 60 * 1000) + (second * 1000);
        calendar.set(Calendar.MILLISECOND, -((weekValue * (24) * 3600000) - timevalue));

        return new DateTimeScope(calendar.getTime(), new Date(System.currentTimeMillis()));
    }

    /**
     * 获取周的时间范围（周一至当前时间）
     *
     * @return
     */
    public static DateTimeScope getWeekTime(int day) {

        GregorianCalendar calendar = new GregorianCalendar();
        int timevalue = 0;

        int hour = 23 - calendar.get(Calendar.HOUR_OF_DAY);
        int minute = 59 - calendar.get(Calendar.MINUTE);
        int second = 60 - calendar.get(Calendar.SECOND);
        int weekValue = CalendarUtils.getWeek() + day;

        timevalue = (hour * 3600000) + (minute * 60 * 1000) + (second * 1000);
        calendar.set(Calendar.MILLISECOND, -((weekValue * (24) * 3600000) - timevalue));

        return new DateTimeScope(calendar.getTime(), new Date(System.currentTimeMillis()));
    }

    /**
     * 获取天的时间范围（如：2016-04-04 00:00:00 至 2016-04-04 11:02:30 ）
     *
     * @return
     */
    public static DateTimeScope getDayTime() {
        GregorianCalendar calendar = new GregorianCalendar();
        int timevalue = 0;

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        timevalue = (hour * 3600) + (minute * 60);
        calendar.set(Calendar.SECOND, -(timevalue));

        return new DateTimeScope(calendar.getTime(), new Date(System.currentTimeMillis()));
    }

    /**
     * 以当前时间为基准“向后”获取某天的时间范围, 获取天的时间范围（如：2016-04-04 00:00:00 至 2016-04-05
     * 00:00:00 ）
     *
     * @return
     */
    public static DateTimeScope getDayTime(int day) {

        if (day <= 0) {
            day = 0;
        }

        GregorianCalendar calendarStart = new GregorianCalendar();
        int timevalue = 0;

        int hour = calendarStart.get(Calendar.HOUR_OF_DAY) + (day * 24);
        int minute = calendarStart.get(Calendar.MINUTE);

        timevalue = (hour * 3600) + (minute * 60);
        calendarStart.set(Calendar.SECOND, -(timevalue));

        GregorianCalendar calendarEnd = new GregorianCalendar();
        hour = calendarEnd.get(Calendar.HOUR_OF_DAY) + (day * 12);
        minute = calendarEnd.get(Calendar.MINUTE);

        timevalue = (hour * 3600) + (minute * 60);
        calendarEnd.set(Calendar.SECOND, -(timevalue));

        return new DateTimeScope(calendarStart.getTime(), calendarEnd.getTime());
    }

    /**
     * 获取月的时间范围（月1号至当前时间）
     *
     * @return
     */
    public static DateTimeScope getMonthTime() {

        GregorianCalendar calendar = new GregorianCalendar();

        int timevalue = 0;
        int hour = 23 - calendar.get(Calendar.HOUR_OF_DAY);
        int minute = 59 - calendar.get(Calendar.MINUTE);
        int week = calendar.get(Calendar.DAY_OF_MONTH);

        timevalue = (hour * 3600) + (minute * 60) + 60;

        calendar.set(Calendar.SECOND, -((week * 24 * 3600) - timevalue));

        return new DateTimeScope(calendar.getTime(), new Date(System.currentTimeMillis()));
    }

    /**
     * 已当前月为基准，向后减一个月
     *
     * @param monthValue
     *            减值
     * @return
     */
    public static DateTimeScope getMonthTime(int monthValue) {

        if (monthValue <= 0) {
            monthValue = 1;
        }

        DateTimeScope integralTime = getMonthTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(integralTime.getStartTime());
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month - monthValue);

        integralTime.setStartTime(calendar.getTime());

        return integralTime;
    }

    /**
     * 当前时间几天的数据
     * 
     * @param dayValue
     * @return
     */
    public static DateTimeScope getLastDay(int dayValue) {
        Calendar calendar = Calendar.getInstance();
        Date nowDate = calendar.getTime();
        if (dayValue < 0) {
            calendar.add(Calendar.DAY_OF_MONTH, dayValue);
            return new DateTimeScope(calendar.getTime(), nowDate);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, dayValue);
            return new DateTimeScope(nowDate, calendar.getTime());
        }
    }

    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            return 0;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth)
                    age--;
            } else {
                age--;
            }
        }
        return age;
    }
}
