package com.example.spring.study.web.controller;

import com.example.spring.study.util.JacksonUtil;
import com.example.spring.study.web.vo.request.BaseParam;
import com.example.spring.study.web.vo.request.ProductInfoParam;
import com.example.spring.study.web.vo.response.ApiResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jianglei on 2019/8/23.
 */
@RestController
@RequestMapping("/post")
@Slf4j
public class PostTestController {

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    @ApiOperation(value="post测试1", notes="@RequestBody注解映射参数，@Valid校验参数")
    public ApiResult post1(@RequestBody @Valid BaseParam baseParam) {

        log.info(JacksonUtil.parseJson(baseParam));
        return ApiResult.success(baseParam);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    @ApiOperation(value="post测试2", notes="@RequestBody注解映射参数，@Valid校验参数")
    @ApiImplicitParam(name = "productInfoParam", value = "产品实体ProductInfo", required = true, dataType = "ProductInfoParam")
    public ApiResult post2(@RequestBody @Valid ProductInfoParam productInfoParam) {
        log.info(JacksonUtil.parseJson(productInfoParam));
        return ApiResult.success("你好");
    }

    @RequestMapping(value = "/test3", method = RequestMethod.POST)
    @ApiOperation(value="post测试2", notes="@ModelAttribute注解绑定参数")
    public ApiResult post3(@ModelAttribute ProductInfoParam productInfoParam) {
        log.info(JacksonUtil.parseJson(productInfoParam));
        return ApiResult.success(productInfoParam);
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "产品详细实体ProductInfo", required = true, dataType = "ProductInfoParam")
    })
    public ApiResult post4(@PathVariable Long id, @RequestBody ProductInfoParam productInfoParam) {
        log.info("id:{}, ProductInfoParam:{}", id, JacksonUtil.parseJson(productInfoParam));
        return ApiResult.success(productInfoParam);
    }
}
