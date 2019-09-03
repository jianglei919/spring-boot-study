package com.example.spring.study.config;

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

/**
 * Created by jianglei on 2019/9/2.
 */
@Configuration
@Slf4j
public class WebConfiguration {

    @Bean
    public HttpMessageConverters customMessageConverters(){
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
            log.info("当前WebServer实现类为：{}", context.getWebServer().getClass().getName());
        };
    }
}
