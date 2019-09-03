package com.example.spring.study.web.controller;

import com.example.spring.study.service.FlightService;
import com.example.spring.study.util.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by jianglei on 2019/8/26.
 */
@Controller
@RequestMapping("/flight")
public class FlightInfoController {

    @Resource
    private FlightService flightService;

    @RequestMapping("/jpa/{id}")
    @ResponseBody
    public ApiResult getByJpa(@PathVariable("id") Long id) {
        return ApiResult.success(flightService.findAllByIdFromJpa(id));
    }

    @RequestMapping("/mybatis/{id}")
    @ResponseBody
    public ApiResult getByMybatis(@PathVariable("id") Long id) {
        return ApiResult.success(flightService.selectById(id));
    }
}
