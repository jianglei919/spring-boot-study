package com.example.spring.study.utils;

import com.example.spring.study.util.JacksonUtil;
import com.example.spring.study.web.vo.request.BaseParam;
import com.example.spring.study.web.vo.request.OrderInfoParam;
import com.example.spring.study.web.vo.request.PassengerInfoParam;
import com.example.spring.study.web.vo.request.ProductInfoParam;
import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * Created by jianglei on 2019/8/23.
 */
public class CommonTest {

    @Test
    public void test1() {
        OrderInfoParam orderInfoParam = new OrderInfoParam();
        orderInfoParam.setOrderNo("11111");
        orderInfoParam.setOrderStatus(Lists.newArrayList(1, 2, 3));

        PassengerInfoParam passengerInfoParam = new PassengerInfoParam();
        passengerInfoParam.setPassengerStatus(0);

        ProductInfoParam productInfoParam = new ProductInfoParam();
        productInfoParam.setProductNo("2222");

        BaseParam param = new BaseParam();
        param.setId(1L);
        param.setDepCode("PEK");
        param.setOrderInfoParam(orderInfoParam);
        param.setPassengerInfoParam(passengerInfoParam);
        param.setProductInfoParam(productInfoParam);
        System.out.println(JacksonUtil.parseJson(param));
        System.out.println(param);

        System.out.println(JacksonUtil.parseJson(productInfoParam));
    }
}
