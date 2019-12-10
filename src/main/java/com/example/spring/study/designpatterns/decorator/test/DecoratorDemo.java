package com.example.spring.study.designpatterns.decorator.test;

import com.example.spring.study.designpatterns.decorator.Shape;
import com.example.spring.study.designpatterns.decorator.ShapeDecorator;
import com.example.spring.study.designpatterns.decorator.impl.Circle;
import com.example.spring.study.designpatterns.decorator.impl.RedShapeDecorator;

/**
 * Created by jianglei on 2019/12/9.
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(circle);
        redCircle.draw();
    }
}
