package com.example.spring.study.utils;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by jianglei on 2019/8/23.
 */
public class UtilsTest {

    @Test
    public void test1() {
        System.out.println(ObjectUtils.allNotNull(null, new Object()));
//        System.out.println(ObjectUtils.compare());
        System.out.println(ObjectUtils.anyNotNull(null, new Object()));
        System.out.println(ObjectUtils.defaultIfNull(null, "1"));
        System.out.println(ObjectUtils.defaultIfNull("2", null));
        System.out.println(ObjectUtils.notEqual(new Object(), new Object()));
        System.out.println(ObjectUtils.equals("1", "1"));
    }

    @Test
    public void test2() {
        String str1 = "1";
        String str2 = StringUtils.EMPTY;
        System.out.println(NumberUtils.toInt(str1));
        System.out.println(NumberUtils.toInt(StringUtils.EMPTY, 2));
        System.out.println(NumberUtils.toInt(null, 3));
    }

    @Test
    public void test3() {
        System.out.println(RandomUtils.nextInt());
        System.out.println(RandomUtils.nextInt(1, 10));
    }

    @Test
    public void test4() {
        System.out.println(StringUtils.removeAll("any", String.valueOf(Pattern.compile(".+"))));
    }

    @Test
    public void test5() {
        Validate.isTrue(false);
    }

    @Test
    public void test6() {
        System.out.println(ArrayUtils.toObject(new int[]{1,2,3}));
    }
}
