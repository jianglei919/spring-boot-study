package com.example.springboot.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by jianglei on 2019/3/15.
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        if (applicationContext == null)
            applicationContext = context;
    }

    /**
     * 获取applicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return applicationContext != null ? applicationContext.getBean(beanName) : null;

    }

    /**
     * 通过class获取Bean.
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext != null ? applicationContext.getBean(clazz) : null;
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return applicationContext != null ? applicationContext.getBean(clazz, beanName) : null;
    }
}
