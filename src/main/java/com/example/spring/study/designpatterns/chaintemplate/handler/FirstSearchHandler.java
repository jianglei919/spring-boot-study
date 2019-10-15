package com.example.spring.study.designpatterns.chaintemplate.handler;

import com.example.spring.study.designpatterns.chaintemplate.base.Handler;
import com.example.spring.study.designpatterns.chaintemplate.base.HandlerChain;
import com.example.spring.study.designpatterns.chaintemplate.enums.HandlerLevelOrder;
import com.example.spring.study.designpatterns.chaintemplate.enums.HandlerType;
import com.example.spring.study.designpatterns.chaintemplate.search.SearchInvocationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by jianglei on 2019/10/15.
 */
@Component
@Slf4j
public class FirstSearchHandler extends AbstractHandler implements Handler<SearchInvocationContext> {

    @Override
    public Object handler(HandlerChain chain, SearchInvocationContext context) {
        log.info("第一步操作");
        return chain.doChain(context);
    }

    @Override
    public HandlerLevelOrder getHandlerOrder() {
        return HandlerLevelOrder.FIRST;
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
