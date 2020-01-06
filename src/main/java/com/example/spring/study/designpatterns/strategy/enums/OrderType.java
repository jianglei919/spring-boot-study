package com.example.spring.study.designpatterns.strategy.enums;

public enum OrderType {

    DEFAULT(0, ""),
    TICKET_OK(1, "出票完成"),
    REFUND_OK(2, "退款完成"),
    CHANGE_OK(3, "改签完成"),
    CANCEL(4, "订单取消"),
    REPEAT_TICKET(5, "重复出票"),
    DASH_COUNT(6, "冲量"),
    OFFLINE(7, "线下订单"),
    RELEASE_STOCK(8, "释放库存");

    public int code;
    public String desc;

    OrderType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
