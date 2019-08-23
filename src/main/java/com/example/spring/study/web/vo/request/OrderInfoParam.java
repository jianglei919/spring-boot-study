package com.example.spring.study.web.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by jianglei on 2019/8/23.
 */
@NoArgsConstructor
@Getter
@Setter
public class OrderInfoParam implements Serializable {

    /**
     * 订单号
     */
    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    /**
     * 活动订单类型：0、全部；1、团票通普通产品；2、Eterm黑屏产品
     */
    private Integer orderType;

    /**
     * 订单状态
     */
    private List<Integer> orderStatus;

    /**
     * 生单日期
     */
    private String orderDate;

    /**
     * 出票日期
     */
    private String ticketDate;

    private Date orderDateBegin;

    private Date orderDateEnd;
}
