package com.example.spring.study.designpatterns.chaintemplate.base;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianglei on 2019/9/20.
 */
@Slf4j
public abstract class HandlerFactory {

    public <V extends Handler> HandlerChain createInvokerHandlerChain(List<V> filters) {
        HandlerChain lastChain = null;
        List<V> newFilters = new ArrayList();
        newFilters.addAll(filters);

        for(int i = newFilters.size() - 1; i >= 0; --i) {
            final Handler filter = newFilters.get(i);
            final HandlerChain nextChain = lastChain;
            lastChain = new HandlerChain() {
                @Override
                public Object doChain(InvocationContext context) {
                    return filter.handler(nextChain, context);
                }
            };
        }
        return lastChain;
    }

    public abstract HandlerChain selectInvokerHandlerChain();
}
