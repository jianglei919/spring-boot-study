package com.example.spring.study.service;

public interface BasePayService {

    void prePay();

    void paying();

    void afterPay();

    boolean canPay();
}
