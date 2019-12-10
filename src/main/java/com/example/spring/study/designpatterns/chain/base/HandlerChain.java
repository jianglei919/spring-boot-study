package com.example.spring.study.designpatterns.chain.base;

public interface HandlerChain {

    Object doChain(InvocationContext context);
}
