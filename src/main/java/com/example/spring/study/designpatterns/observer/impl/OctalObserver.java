package com.example.spring.study.designpatterns.observer.impl;

import com.example.spring.study.designpatterns.observer.Observer;
import com.example.spring.study.designpatterns.observer.Subject;

/**
 * Created by jianglei on 2019/12/9.
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String : " + Integer.toOctalString(subject.getState()));
    }
}
