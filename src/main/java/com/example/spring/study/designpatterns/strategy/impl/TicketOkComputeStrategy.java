package com.example.spring.study.designpatterns.strategy.impl;

import com.example.spring.study.designpatterns.strategy.ProfitComputeStrategy;
import com.example.spring.study.designpatterns.strategy.bean.ProfitCondition;
import com.example.spring.study.designpatterns.strategy.bean.ProfitInfo;
import com.example.spring.study.designpatterns.strategy.bean.ProfitParam;
import com.example.spring.study.designpatterns.strategy.enums.OrderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 出票完成利润计算策略
 * Created by jianglei on 2020-01-06.
 */
@Slf4j
@Service
public class TicketOkComputeStrategy implements ProfitComputeStrategy {
    @Override
    public ProfitInfo computeProfit(ProfitParam profitParam) {
        ProfitInfo profitInfo = new ProfitInfo();
        log.info("出票完成利润计算策略");
        return profitInfo;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public boolean isSupport(ProfitCondition condition) {
        return condition.getOrderType() == OrderType.TICKET_OK.code;
    }
}
