package com.example.spring.study.bean;

/**
 * Created by jianglei on 2019/8/13.
 */
public class InterOrderModel {

    private int interOrderId;

    public int getInterOrderId() {
        return interOrderId;
    }

    public void setInterOrderId(int interOrderId) {
        this.interOrderId = interOrderId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"interOrderId\":")
                .append(interOrderId);
        sb.append('}');
        return sb.toString();
    }
}
