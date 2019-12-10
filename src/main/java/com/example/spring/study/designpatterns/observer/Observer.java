package com.example.spring.study.designpatterns.observer;

/**
 * Created by jianglei on 2019/12/9.
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
