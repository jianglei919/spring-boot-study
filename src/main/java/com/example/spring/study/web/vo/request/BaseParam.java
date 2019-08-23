package com.example.spring.study.web.vo.request;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by jianglei on 2019/8/23.
 */
//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class BaseParam implements Serializable {

    public static final int DEFAULT_PAGE_SIZE = 20;

    private Long id;

    /**
     * 供应商code
     */
    private String clientCode;

    /**
     * 采购商
     */
    private String purchaseAgent;

    /**
     * 航班号
     */
    private String flightNo;

    /**
     * 出发机场三字码
     */
    @NotBlank(message = "航班号不能为空")
    private String depCode;

    /**
     * 到达机场三字码
     */
    private String arrCode;

    /**
     * 截止日期
     */
    private String timeLimit;

    /**
     * 出发日期(yyyy-MM-dd)
     */
    private String depDate;

    @NotNull(message = "订单信息不能为空")
    @Valid
    private OrderInfoParam orderInfoParam;

    @Valid
    @NotNull(message = "乘机人不能为空")
    private PassengerInfoParam passengerInfoParam;

    @Valid
    @NotNull(message = "产品信息不能为空")
    private ProductInfoParam productInfoParam;

    private Integer pageOffSet = 0;

    private Integer pageSize = DEFAULT_PAGE_SIZE;

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }
}
