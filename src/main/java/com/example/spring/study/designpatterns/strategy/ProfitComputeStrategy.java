package com.example.spring.study.designpatterns.strategy;

import com.example.spring.study.designpatterns.strategy.bean.ProfitCondition;
import com.example.spring.study.designpatterns.strategy.bean.ProfitInfo;
import com.example.spring.study.designpatterns.strategy.bean.ProfitParam;

/**
 * 利润计算策略
 */
public interface ProfitComputeStrategy {

    ProfitInfo computeProfit(ProfitParam profitParam);

    int getOrder();

    boolean isSupport(ProfitCondition condition);
}
