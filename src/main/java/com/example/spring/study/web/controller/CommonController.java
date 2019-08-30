package com.example.spring.study.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用映射类
 * Created by jianglei on 2019/5/29.
 */
//@Controller
//@RequestMapping(value = "/**")
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

//    @RequestMapping(value = "/**")
    public void commonMapping() {
        logger.info("common mapping");
    }
}
