package com.example.spring.study.designpatterns.observer.impl;

import com.example.spring.study.designpatterns.observer.Observer;
import com.example.spring.study.designpatterns.observer.Subject;

/**
 * Created by jianglei on 2019/12/9.
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String : " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
