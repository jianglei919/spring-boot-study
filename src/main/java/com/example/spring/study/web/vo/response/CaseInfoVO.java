package com.example.spring.study.web.vo.response;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jianglei on 2019/12/6.
 */
public class CaseInfoVO implements Serializable {

    private Integer id;

    private Integer questionId;

    private Integer orderId;

    private String memo;

    private String horseManName;

    private String horseManPhone;

    private String shopName;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getHorseManName() {
        return horseManName;
    }

    public void setHorseManName(String horseManName) {
        this.horseManName = horseManName;
    }

    public String getHorseManPhone() {
        return horseManPhone;
    }

    public void setHorseManPhone(String horseManPhone) {
        this.horseManPhone = horseManPhone;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
