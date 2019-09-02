package com.example.spring.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jianglei on 2019/9/2.
 */
@Configuration
@Slf4j
public class WebConfiguration {

    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> {
            log.info("当前WebServer实现类为：{}", context.getWebServer().getClass().getName());
        };
    }
}
