package com.example.spring.study.enums;

public enum CodeEnum {

    SUCCESS("0", "操作成功"),
    FAILED("1", "操作失败"),
    PARAM_ERROR("2", "参数不正确"),
    INTERNET_FAIL("3", "网络异常"),
    MAX_COUNT("4", "达到最大次数"),
    REPEAT("5", "请不要重复操作"),
    URL_FAIL("6", "无访问权限"),
    NOT_DATA("7", "没有查到需要的数据"),

    ;

    public String code;
    public String msg;

    CodeEnum(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

}
