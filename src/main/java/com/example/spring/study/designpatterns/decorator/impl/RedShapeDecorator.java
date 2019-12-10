package com.example.spring.study.designpatterns.decorator.impl;

import com.example.spring.study.designpatterns.decorator.Shape;
import com.example.spring.study.designpatterns.decorator.ShapeDecorator;

/**
 * 红色形状的具体装饰器实现类
 * Created by jianglei on 2019/12/9.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        decoratorShape.draw();
        setRedBorder(decoratorShape);
    }

    public void setRedBorder(Shape decoratedShape) {
        System.out.println("set red color");
    }
}
