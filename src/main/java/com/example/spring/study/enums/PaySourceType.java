package com.example.spring.study.enums;

import com.example.spring.study.common.ApplicationContextHelper;
import com.example.spring.study.service.BasePayService;
import com.example.spring.study.service.impl.AliPayService;
import com.example.spring.study.service.impl.WeiXinPayService;

public enum PaySourceType {

    WEI_XIN_PAY(1) {
        @Override
        public BasePayService getService() {
            return ApplicationContextHelper.getBean(AliPayService.class);
        }
    },
    ALI_PAY(2) {
        @Override
        public BasePayService getService() {
            return ApplicationContextHelper.getBean(WeiXinPayService.class);
        }
    },
    UNKNOWN(-1) {
        @Override
        public BasePayService getService() {
            return null;
        }
    };

    public int code;

    PaySourceType(int code) {
        this.code = code;
    }

    public static PaySourceType typeOf(int code) {
        for (PaySourceType imageSourceType : values()) {
            if (imageSourceType.code == code) {
                return imageSourceType;
            }
        }
        return UNKNOWN;
    }

    public abstract BasePayService getService();
}
