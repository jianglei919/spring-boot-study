package com.example.spring.study.designpatterns.strategy;

import com.example.spring.study.designpatterns.strategy.bean.ProfitCondition;
import com.example.spring.study.designpatterns.strategy.bean.ProfitInfo;
import com.example.spring.study.designpatterns.strategy.bean.ProfitParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by jianglei on 2020-01-06.
 */
@Service
@Slf4j
public class ProfitComputeStrategyFactory implements InitializingBean {

    @Resource
    private List<ProfitComputeStrategy> profitComputeStrategyList;

    /**
     * 通过PostConstruct初始化不同的策略
     */
//    @PostConstruct
    protected void initStrategy() {
        if (CollectionUtils.isEmpty(profitComputeStrategyList)) {
            log.info("PostConstruct init profit compute strategy is empty");
            new RuntimeException("PostConstruct init profit compute strategy is empty");
        }
        profitComputeStrategyList.sort(Comparator.comparingInt(ProfitComputeStrategy::getOrder));
        log.info("PostConstruct init profit compute strategy finished, size:{}", profitComputeStrategyList.size());
    }

    public ProfitInfo computeProfit(ProfitCondition condition) {
        ProfitComputeStrategy profitComputeStrategy = getProfitComputeStrategy(condition);
        ProfitParam profitParam = new ProfitParam();
        return profitComputeStrategy.computeProfit(profitParam);
    }

    public ProfitComputeStrategy getProfitComputeStrategy(ProfitCondition condition) {
        Optional<ProfitComputeStrategy> optional = profitComputeStrategyList.stream().filter(f -> f.isSupport(condition)).findFirst();
        return optional.orElse(null);
    }

    /**
     * 通过InitializingBean#afterPropertiesSet 初始化不同的策略
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(profitComputeStrategyList)) {
            log.info("afterPropertiesSet init profit compute strategy is empty");
            new RuntimeException("afterPropertiesSet init profit compute strategy is empty");
        }
        Collections.sort(profitComputeStrategyList, Comparator.comparingInt(ProfitComputeStrategy::getOrder));
        log.info("afterPropertiesSet init profit compute strategy finished, size:{}", profitComputeStrategyList.size());
    }

}
