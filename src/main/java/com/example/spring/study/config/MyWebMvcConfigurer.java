package com.example.spring.study.config;

import com.example.spring.study.interceptor.FlowLimitControlInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
