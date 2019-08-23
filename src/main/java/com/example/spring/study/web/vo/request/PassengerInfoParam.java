package com.example.spring.study.web.vo.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by jianglei on 2019/8/23.
 */
@Setter
@Getter
public class PassengerInfoParam implements Serializable {

    /**
     * 乘机人姓名
     */
    private String passengerName;

    /**
     * 乘机人状态查询条件
     */
    private Integer passengerStatus;

}
