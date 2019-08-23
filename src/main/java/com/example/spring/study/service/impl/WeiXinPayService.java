package com.example.spring.study.service.impl;

import com.example.spring.study.service.BasePayService;
import org.springframework.stereotype.Service;

/**
 * Created by jianglei on 2019/6/27.
 */
@Service
public class WeiXinPayService implements BasePayService {
    @Override
    public void prePay() {

    }

    @Override
    public void paying() {

    }

    @Override
    public void afterPay() {

    }

    @Override
    public boolean canPay() {
        return false;
    }
}
