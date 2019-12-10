package com.example.spring.study.designpatterns.chain.base;

import com.example.spring.study.designpatterns.chain.enums.HandlerLevelOrder;
import com.example.spring.study.designpatterns.chain.enums.HandlerType;

public interface Handler<I extends InvocationContext> {

    Object handler(HandlerChain chain, I context);

    HandlerLevelOrder getHandlerOrder();

    HandlerType getType();

    boolean valid();
}
