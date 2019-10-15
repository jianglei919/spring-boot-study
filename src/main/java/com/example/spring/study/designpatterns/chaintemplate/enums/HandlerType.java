package com.example.spring.study.designpatterns.chaintemplate.enums;

public enum HandlerType {

    STOCK(1, "search"),
    SEARCH(2, "search"),
    ;

    public int type;
    public String desc;

    HandlerType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
