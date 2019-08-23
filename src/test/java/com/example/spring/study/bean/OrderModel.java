package com.example.springboot.bean;

import java.math.BigDecimal;

/**
 * Created by jianglei on 2019/8/13.
 */
public class OrderModel {

    private int id;

    private String name;

    private String enName;

    private BigDecimal money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"enName\":\"")
                .append(enName).append('\"');
        sb.append(",\"money\":")
                .append(money);
        sb.append('}');
        return sb.toString();
    }
}
