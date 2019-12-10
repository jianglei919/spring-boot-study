package com.example.spring.study.designpatterns.decorator;

/**
 * 形状装饰器抽象类
 * Created by jianglei on 2019/12/9.
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }
}
