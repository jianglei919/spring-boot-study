package com.example.spring.study.config;

import com.example.spring.study.interceptor.FlowLimitControlInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by jianglei on 2019/4/16.
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(flowLimitControlInterceptor())
                .addPathPatterns("/deferred")
                .excludePathPatterns("/swagger-ui.html",
                "/swagger-resources/**",
                "/webjars/**",
                "/v2/**",
                "/error",
                "/async/**",
                "/flight/**",
                "/get/**",
                "/post/*",
                "/chain/**",
                "/users/**",
                "/view/**",
                "/hello"
        );
    }

    @Bean
    public FlowLimitControlInterceptor flowLimitControlInterceptor() {
        return new FlowLimitControlInterceptor();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}
