package com.example.spring.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jianglei on 2019/5/17.
 * 注意这里使用了@Controller注解而不是之前的@RestController，若使用后者，index()方法返回的”temp”会直接以JSON格式返回，页面显示“temp”。
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    /**
     * @param message
     * @param model
     * @return
     */
    @RequestMapping("/test")
    public String index(@RequestParam(value = "message", required = false, defaultValue = "index") String message,
                        ModelMap model) {
        model.addAttribute("message", message);
        return "temp";
    }
}
