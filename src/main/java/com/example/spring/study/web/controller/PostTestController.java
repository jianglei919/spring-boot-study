package com.example.spring.study.web.controller;

import com.example.spring.study.util.JacksonUtil;
import com.example.spring.study.web.vo.request.BaseParam;
import com.example.spring.study.web.vo.request.ProductInfoParam;
import com.example.spring.study.util.ApiResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jianglei on 2019/8/23.
 */
@RestController
@RequestMapping("/post")
@Slf4j
public class PostTestController {

    /**
     * 总结一下 @Validated 和 @Valid 在嵌套验证功能上的区别：
     * @Validated： 用在方法入参上无法单独提供嵌套验证功能。不能用在成员属性（字段）上，也无法提示框架进行嵌套验证。能配合嵌套验证注解@Valid进行嵌套验证。
     * @Valid： 用在方法入参上无法单独提供嵌套验证功能。能够用在成员属性（字段）上，提示验证框架进行嵌套验证。能配合嵌套验证注解@Valid进行嵌套验证。
     */



    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    @ApiOperation(value="post测试1", notes="@RequestBody注解映射参数，@Valid校验参数")
    public ApiResult post1(@RequestBody @Validated BaseParam baseParam) {

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
