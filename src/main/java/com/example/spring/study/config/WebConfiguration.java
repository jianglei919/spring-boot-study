package com.example.spring.study.config;

import com.example.my.auto.configure.bean.MyDemoTemplate;
import com.example.spring.study.task.executor.ScheduledExecutorTask;
import com.example.spring.study.task.timer.TimerTaskDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by jianglei on 2019/9/2.
 */
@Configuration
@Slf4j
public class WebConfiguration {

    @Bean
    public HttpMessageConverters customMessageConverters() {
        LocalJackson2HttpMessageConverter localJackson2HttpMessageConverter = new LocalJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.ALL);
        localJackson2HttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return new HttpMessageConverters(stringHttpMessageConverter, localJackson2HttpMessageConverter);
    }

    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> {
//            log.info("当前WebServer实现类为：{}", context.getWebServer().getClass().getName());

//            startTimerTask();
//            startScheduledExecutorTask();
        };
    }

//    @Bean
    public MyDemoTemplate myDemoTemplate() {
        return new MyDemoTemplate("手动配置覆盖自动装配");
    }

    private void startTimerTask() {
        TimerTaskDemo taskDemo = new TimerTaskDemo();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(taskDemo, TimeUnit.SECONDS.toMillis(1),
                TimeUnit.SECONDS.toMillis(20));
    }

    private void startScheduledExecutorTask() {
        ScheduledExecutorTask.work();
    }
}
