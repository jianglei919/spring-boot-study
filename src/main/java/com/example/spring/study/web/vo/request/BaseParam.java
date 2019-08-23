package com.example.spring.study.web.vo.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by jianglei on 2019/8/23.
 */
//@Data
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseRequestParam implements Serializable {

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

    /**
     * 出票日期
     */
    private String ticketDate;

    private Integer pageOffSet = 0;

    private Integer pageSize = DEFAULT_PAGE_SIZE;
}
