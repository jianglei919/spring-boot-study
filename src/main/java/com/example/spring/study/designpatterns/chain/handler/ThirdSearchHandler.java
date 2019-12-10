package com.example.spring.study.designpatterns.chain.handler;

import com.example.spring.study.designpatterns.chain.base.Handler;
import com.example.spring.study.designpatterns.chain.base.HandlerChain;
import com.example.spring.study.designpatterns.chain.enums.HandlerLevelOrder;
import com.example.spring.study.designpatterns.chain.enums.HandlerType;
import com.example.spring.study.designpatterns.chain.search.SearchInvocationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by jianglei on 2019/10/15.
 */
@Slf4j
@Component
public class ThirdSearchHandler extends AbstractHandler implements Handler<SearchInvocationContext> {

    @Override
    public Object handler(HandlerChain chain, SearchInvocationContext context) {
        log.info("第三步操作");
        return context;
    }

    @Override
    public HandlerLevelOrder getHandlerOrder() {
        return HandlerLevelOrder.THIRD;
    }

    @Override
    public HandlerType getType() {
        return HandlerType.SEARCH;
    }

    @Override
    public boolean valid() {
        return true;
    }
}
