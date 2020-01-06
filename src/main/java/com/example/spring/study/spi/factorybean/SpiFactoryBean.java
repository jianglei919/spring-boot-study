package com.example.spring.study.spi.factorybean;

import com.example.spring.study.spi.ISpi;
import com.example.spring.study.spi.factorybean.exception.NoSpiChooseException;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Created by jianglei on 2019-12-25.
 */
public class SpiFactoryBean<T> implements FactoryBean<T> {

    private Class<? extends ISpi> spiClazz;

    private List<ISpi> list;

    public SpiFactoryBean(ApplicationContext applicationContext, Class<? extends ISpi> spiClazz) {
        this.spiClazz = spiClazz;

//        applicationContext.getBeansOfType(spiClazz);
        Map<String, ? extends ISpi> map = new HashMap<>();
        list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(ISpi::order));
    }

    @Override
    public T getObject() throws Exception {
        // jdk动态代理类生成
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                for (ISpi spi : list) {
                    if (spi.verify(args[0])) {
                        // 第一个参数作为条件选择
                        return method.invoke(spi, args);
                    }
                }

                throw new NoSpiChooseException("no spi server can execute! spiList: " + list);
            }
        };

        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{},
                invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return spiClazz;
    }
}
