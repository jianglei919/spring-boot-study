package com.example.spring.study.designpatterns.strategy.bean;

import java.io.Serializable;

/**
 * Created by jianglei on 2020-01-06.
 */
public class ProfitCondition implements Serializable {

    private int orderType;

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
}
