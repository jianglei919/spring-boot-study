package com.example.springboot.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by jianglei on 2019/3/14.
 */
public class LocalJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public LocalJackson2HttpMessageConverter() {
        ObjectMapper objectMapper = getObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public LocalJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }
}
