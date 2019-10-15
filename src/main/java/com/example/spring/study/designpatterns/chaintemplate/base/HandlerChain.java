package com.example.spring.study.designpatterns.chaintemplate.base;

public interface HandlerChain {

    Object doChain(InvocationContext context);
}
