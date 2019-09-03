package com.example.spring.study.web.controller;

import com.example.spring.study.common.DateConstant;
import com.example.spring.study.util.DateUtil;
import com.example.spring.study.web.vo.request.ProductInfoParam;
import com.example.spring.study.util.ApiResult;
import com.example.spring.study.web.vo.response.BaseSearchResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ApiOperation(value="get测试1", notes="@RequestParam注解方式绑定参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "状态")
    })
    public ApiResult test1(@RequestParam(value = "id") Long id,
                           @RequestParam(value = "status", required = false) Integer status) {
        System.out.println(id + " " + status);
        BaseSearchResult result = new BaseSearchResult();
        result.setOrderNo("123456");
        return ApiResult.success(result);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ApiOperation(value="get测试2", notes="通过对象自动绑定，@Valid注解校验参数")
    public ApiResult test2(@Valid ProductInfoParam param) {
        //build创建方式
        ProductInfoParam buildParam = ProductInfoParam.builder().productNo("111222").build();
        return ApiResult.success(param);
    }

    @RequestMapping(value = "/test3/{id}", method = RequestMethod.GET)
    @ApiOperation(value="get测试3", notes="reset风格接口，@PathVariable绑定参数")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    public ApiResult test3(@PathVariable(value = "id") Long id) {
        log.info("id:{}", id);
        return ApiResult.success(DateUtil.getDateFormat(new Date(), DateConstant.PATTERN_FULL_DATE_TIME));
    }
}
