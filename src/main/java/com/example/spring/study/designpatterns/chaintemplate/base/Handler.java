package com.example.spring.study.designpatterns.chaintemplate.base;

import com.example.spring.study.designpatterns.chaintemplate.enums.HandlerLevelOrder;
import com.example.spring.study.designpatterns.chaintemplate.enums.HandlerType;

public interface Handler<I extends InvocationContext> {

    Object handler(HandlerChain chain, I context);

    HandlerLevelOrder getHandlerOrder();

    HandlerType getType();

    boolean valid();
}
