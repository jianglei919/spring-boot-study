package com.example.spring.study.util;

import com.google.common.base.Strings;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

public class DateHelper {

    public static final String PATTERN_FULL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String PATTERN_FULL_DATE_TIME_SLASH = "yyyy/MM/dd HH:mm:ss";

    public static final String PATTERN_SIMPLE_DATE_TIME = "yyyy-MM-dd";

    public static final String PATTERN_CLEAN_DATE_HOUR_MIN = "yyyyMMddHHmm";

    public static final String PATTERN_CLEAN_DATE = "yyyyMMdd";

    public static String formatDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        DateTime dt = new DateTime(date);
        return dt.toString(PATTERN_FULL_DATE_TIME);
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null || Strings.isNullOrEmpty(pattern)) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        DateTime dt = new DateTime(date);
        return dt.toString(pattern);
    }

    public static String formatSimpleDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        DateTime dt = new DateTime(date);
        return dt.toString(PATTERN_SIMPLE_DATE_TIME);
    }

    public static Date parseDate(String str) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        return DateTimeFormat.forPattern(PATTERN_FULL_DATE_TIME).parseDateTime(str).toDate();
    }

    public static Date parseSimpleDate(String str) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        return DateTimeFormat.forPattern(PATTERN_SIMPLE_DATE_TIME).parseDateTime(str).toDate();
    }

    public static Date parseCleanDate(String str) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        return DateTimeFormat.forPattern(PATTERN_CLEAN_DATE).parseDateTime(str).toDate();
    }

    public static Date parseCleanDateHourMin(String str) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        return DateTimeFormat.forPattern(PATTERN_CLEAN_DATE_HOUR_MIN).parseDateTime(str).toDate();
    }

    public static Date parseDate(String str, String pattern) {
        if (Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(pattern)) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        return DateTimeFormat.forPattern(pattern).parseDateTime(str).toDate();
    }

    public static Date parseCleanLocalDate(String str) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("输入参数错误！");
        }
        return DateTimeFormat.forPattern(PATTERN_CLEAN_DATE).parseLocalDateTime(str).toDate();
    }
}
