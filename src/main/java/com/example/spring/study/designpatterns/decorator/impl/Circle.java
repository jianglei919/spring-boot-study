package com.example.spring.study.designpatterns.decorator.impl;

import com.example.spring.study.designpatterns.decorator.Shape;

/**
 * Created by jianglei on 2019/12/9.
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape : draw circle");
    }
}
