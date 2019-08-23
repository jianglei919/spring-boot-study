package com.houbank.paydayloan.api.enums;

/**
 * Created by jianglei on 2017/5/4.
 */
public enum HeaderEnum {

    TOKEN("token"),
    CONTENT_TYPE("Content-Type"),
    VERSION("version"),
    FILTER_KEY("filter-key"),
    DEVICE_TYPE("deviceType")
    ;

    private String code;

    HeaderEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
