package com.example.springboot.demo.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianglei on 2019/3/14.
 */
@Configuration
public class HttpConfiguration {

    @Bean
    public HttpMessageConverters customMessageConverters(){
        LocalJackson2HttpMessageConverter localJackson2HttpMessageConverter = new LocalJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.ALL);
        localJackson2HttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return new HttpMessageConverters(localJackson2HttpMessageConverter);
    }
}
