package com.example.spring.study.util;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by jianglei on 2019/10/15.
 */
public class ReflectUtils {

    /**
     * 通过字段名从对象或对象的父类中得到字段的值
     * @param object 对象实例
     * @param fieldName 字段名
     * @return 字段对应的值
     * @throws Exception
     */
    public static Object getValue(Object object, String fieldName) throws Exception {
        if (object == null) {
            return null;
        }
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }
        Field field;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(object);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }

        return null;
    }

    /**
     * 通过字段名从对象或对象的父类中得到字段的值（调用字典的get方法）
     * @param object 对象实例
     * @param fieldName 字段名
     * @return 字段对应的值
     */
    public static Object getValueOfGet(Object object, String fieldName) {
        if (object == null) {
            return null;
        }
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }
        Field field;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                //获得get方法
                Method getMethod = getReadMethod(field.getName(), clazz);
                //执行get方法返回一个Object
                return getMethod.invoke(object);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }

        return null;
    }

    /**
     * 通过字段名从对象或对象的父类中得到字段的值（调用字典的get方法，可以取出复杂的对象的值）
     * @param object 对象实例
     * @param fieldName 字段名
     * @return 字段对应的值
     */
    public static Object getValueOfGetIncludeObjectFiled(Object object, String fieldName) {

        if (object == null) {
            return null;
        }
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }
        Field field;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                if (fieldName.contains(".")) {
                    // 如：operatorUser.name、operatorUser.org.name，递归调用
                    String[] splitFiledName = fieldName.split("\\.");
                    return getValueOfGetIncludeObjectFiled(
                            getValueOfGetIncludeObjectFiled(object, splitFiledName[0]),
                            splitFiledName[1]);
                }
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                //获得get方法
                Method getMethod = getReadMethod(field.getName(), clazz);
                //执行get方法返回一个Object
                return getMethod.invoke(object);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }

        return null;
    }

    public static Method getReadMethod(String filedName, Class<?> clazz) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(filedName, clazz);
            //获得get方法
            Method readMethod = pd.getReadMethod();
            return readMethod;
        } catch (Exception e) {
            return null;
        }
    }

    public static Method getWriteMethod(String filedName, Class<?> clazz) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(filedName, clazz);
            //获得set方法
            Method writeMethod = pd.getWriteMethod();
            return writeMethod;
        } catch (Exception e) {
            return null;
        }
    }
}
