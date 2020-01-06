package com.example.spring.study.web.controller;

import com.example.my.auto.configure.bean.MyDemoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jianglei on 2019-12-29.
 */
@RestController
@RequestMapping("/autoConfigure")
public class AutoConfigureDemoController {

    @Autowired
    private MyDemoTemplate myDemoTemplate;

    @RequestMapping("/test")
    public String test() {
        return myDemoTemplate.print();
    }
}
