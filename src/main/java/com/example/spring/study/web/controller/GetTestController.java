package com.example.spring.study.web.controller;

import com.example.spring.study.common.DateConstant;
import com.example.spring.study.util.DateUtil;
import com.example.spring.study.web.vo.request.BaseParam;
import com.example.spring.study.web.vo.request.ProductInfoParam;
import com.example.spring.study.web.vo.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by jianglei on 2019/8/23.
 */
@RestController
@RequestMapping("/get")
@Slf4j
public class GetTestController {

    @RequestMapping("/test1")
    @ResponseBody
    public ApiResult test1(@RequestParam(value = "id") Long id,
                           @RequestParam(value = "status", required = false) Integer status) {
        System.out.println(id + " " + status);
        return ApiResult.success();
    }

    @RequestMapping("/test2")
    @ResponseBody
    public ApiResult test2(@Valid ProductInfoParam param) {
        //build创建方式
        ProductInfoParam buildParam = ProductInfoParam.builder().productNo("111222").build();
        log.info(param.toString());
        log.info("param:{}", buildParam);
        return ApiResult.success(param);
    }

    @RequestMapping("/test3/{id}")
    @ResponseBody
    public ApiResult test3(@PathVariable(value = "id") String id) {
        log.info("id:{}", id);
        return ApiResult.success(DateUtil.getDateFormat(new Date(), DateConstant.PATTERN_FULL_DATE_TIME));
    }
}
