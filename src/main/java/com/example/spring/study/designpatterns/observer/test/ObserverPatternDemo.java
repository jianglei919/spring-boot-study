package com.example.spring.study.designpatterns.observer.test;

import com.example.spring.study.designpatterns.observer.Subject;
import com.example.spring.study.designpatterns.observer.impl.BinaryObserver;
import com.example.spring.study.designpatterns.observer.impl.HexObserver;
import com.example.spring.study.designpatterns.observer.impl.OctalObserver;

/**
 * Created by jianglei on 2019/12/9.
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        //订阅通知
        new BinaryObserver(subject);
        new HexObserver(subject);
        new OctalObserver(subject);

        subject.setState(15);
        System.out.println("================");
        subject.setState(10);
    }
}
