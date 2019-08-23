package com.houbank.paydayloan.core.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

/**
 * Created by jianglei on 17/3/10.
 */
public class JacksonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);

    private static volatile ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        //在遇到类中没有的属性时，是否反序列化失败反序列化是根据类中属性的setter和getter来反序列化，
        // 没有属性则也没有setter和getter.如果不指明为false，那么就会反序列化失败
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 将Object对象为Json字符串
     *
     * @param object
     * @return
     */
    public static String parseJson(Object object) {
        String jsonStr;
        try {
            jsonStr = OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            jsonStr = "";
            LOGGER.error("[Jackson-String转换失败] param:{}", object);
            LOGGER.error("[Jackson-String转换失败] error:", e);
        }
        return jsonStr;
    }

    /**
     * 将字符串序列化值对象
     *
     * @param json
     * @param targetClass
     * @return
     */
    public static <T> T parseObject(String json, Class<T> targetClass) {
        try {
            return OBJECT_MAPPER.readValue(json, targetClass);
        } catch (Exception e) {
            LOGGER.error("[Jackson-Object转换失败] param:json={},class={}", new Object[] { json, targetClass });
            LOGGER.error("[Jackson-Object转换失败] error:", e);
            return null;
        }
    }

    public static <T> Set<T> transformFromString2Set(String json, Class<T> targetClass) {
        try {
            JavaType javaType = getCollectionType(HashSet.class, targetClass);
            return (Set<T>) OBJECT_MAPPER.readValue(json, javaType);
        } catch (Exception e) {
            LOGGER.error("[Jackson-Set转换失败] param:json={},class={}", new Object[] { json, targetClass });
            LOGGER.error("[Jackson-Set转换失败] error:", e);
            return null;
        }
    }

    public static <T> List<T> transformFromString2List(String json, Class<T> targetClass) {
        try {
            JavaType javaType = getCollectionType(ArrayList.class, targetClass);
            return (List<T>) OBJECT_MAPPER.readValue(json, javaType);
        } catch (Exception e) {
            LOGGER.error("[Jackson-List转换失败] param:json={},class={}", new Object[] { json, targetClass });
            LOGGER.error("[Jackson-List转换失败] error:", e);
            return null;
        }
    }

    public static <K, V> Map<K, V> json2Map(String json, Class<K> keyClass, Class<V> valueClass) {
        try {
            JavaType javaType = getCollectionType(HashMap.class, keyClass, valueClass);
            return OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            LOGGER.error("[Jackson-Map转换失败] param:json={},keyClass={},valueClass={}",
                    new Object[] { json, keyClass, valueClass });
            LOGGER.error("[Jackson-Map转换失败] error:", e);
            return null;
        }
    }

    /**
     * 获Collection Type
     *
     * @param parametrized
     * @param parameterClasses
     * @return
     */
    public static JavaType getCollectionType(Class<?> parametrized, Class<?>... parameterClasses) {
        return OBJECT_MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }
}
