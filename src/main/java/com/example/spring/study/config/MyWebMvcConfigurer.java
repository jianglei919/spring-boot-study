package com.example.springboot.demo.config;

import com.example.springboot.demo.filter.FlowLimitControlFilter;
import com.example.springboot.demo.interceptor.FlowLimitControlInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianglei on 2019/4/16.
 */
//@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(flowLimitControlInterceptor());
    }

    @Bean
    public FlowLimitControlInterceptor flowLimitControlInterceptor() {
        return new FlowLimitControlInterceptor();
    }

}
