package com.example.spring.study.designpatterns.chaintemplate.enums;

public enum HandlerLevelOrder {

    FIRST(1, "first"),
    SECOND(2, "second"),
    THIRD(3, "third"),
    ;

    public int order;
    public String desc;

    HandlerLevelOrder(int order, String desc) {
        this.order = order;
        this.desc = desc;
    }
}
