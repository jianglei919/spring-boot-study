package com.example.springboot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jianglei on 2019/5/29.
 */
@Controller
@RequestMapping(value = "/**")
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping(value = "/**")
    public void httpcopy() {
        logger.info("http引流");
    }
}
