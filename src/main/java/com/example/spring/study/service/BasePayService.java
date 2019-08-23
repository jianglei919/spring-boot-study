package com.example.springboot.demo.service;

public interface BasePayService {

    void prePay();

    void paying();

    void afterPay();

    boolean canPay();
}
