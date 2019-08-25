package com.example.spring.study.web.controller;

import com.example.spring.study.util.JacksonUtil;
import com.example.spring.study.web.vo.request.BaseParam;
import com.example.spring.study.web.vo.request.ProductInfoParam;
import com.example.spring.study.web.vo.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by jianglei on 2019/8/23.
 */
@RestController
@RequestMapping("/post")
@Slf4j
public class PostTestController {

    @ResponseBody
    @RequestMapping("/test1")
    public ApiResult post1(@RequestBody @Valid BaseParam baseParam) {

        log.info(JacksonUtil.parseJson(baseParam));
        return ApiResult.success(baseParam);
    }

    @ResponseBody
    @RequestMapping("/test2")
    public ApiResult post2(@RequestBody @Valid ProductInfoParam productInfoParam) {
        log.info(JacksonUtil.parseJson(productInfoParam));
        return ApiResult.success("你好");
    }
}
