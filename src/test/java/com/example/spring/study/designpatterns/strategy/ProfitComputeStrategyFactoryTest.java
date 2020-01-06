package com.example.spring.study.designpatterns.strategy;

import com.example.spring.study.designpatterns.strategy.bean.ProfitCondition;
import com.example.spring.study.designpatterns.strategy.bean.ProfitInfo;
import com.example.spring.study.designpatterns.strategy.bean.ProfitParam;
import com.example.spring.study.designpatterns.strategy.enums.OrderType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* ProfitComputeStrategyFactory Tester. 
* 
* @author tjf 
* @date 01/06/2020
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfitComputeStrategyFactoryTest { 
    
    @Autowired
    ProfitComputeStrategyFactory profitComputeStrategyFactory;

    /**
    *
    * Method: computeProfit(ProfitCondition condition)
    *
    */
    @Test
    public void testComputeProfit() throws Exception {
        ProfitCondition condition = new ProfitCondition();
        condition.setOrderType(OrderType.CANCEL.code);
        ProfitComputeStrategy profitComputeStrategy = profitComputeStrategyFactory.getProfitComputeStrategy(condition);
        System.out.println(profitComputeStrategy);
    }

    /**
    *
    * Method: getProfitComputeStrategy(ProfitCondition condition)
    *
    */
    @Test
    public void testGetProfitComputeStrategy() throws Exception {
        ProfitCondition condition = new ProfitCondition();
        condition.setOrderType(OrderType.TICKET_OK.code);
        ProfitComputeStrategy profitComputeStrategy = profitComputeStrategyFactory.getProfitComputeStrategy(condition);
        ProfitParam profitParam = new ProfitParam();
        ProfitInfo profitInfo = profitComputeStrategy.computeProfit(profitParam);
        System.out.println(profitInfo);
    }

}
