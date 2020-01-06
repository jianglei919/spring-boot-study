package com.example.spring.study.spi;

public interface ISpi<T> {

    boolean verify(T condition);

    default int order() {
        return 10;
    }
}
