package com.example.spring.study.web.vo.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by jianglei on 2019/8/23.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoParam implements Serializable {

    /**
     * 产品编号
     */
    @NotBlank(message = "产品号不能为空")
    private String productNo;

    /**
     * 产品类型，0：国内，1：国际
     */
    private Integer interType;

    /**
     * 行程类型，0：单程，1，往返，2：多场
     */
    private Integer flightType;

    /**
     * 行程子类型，1:单程直飞,2:单程经停,3:单程中转,4:往返直飞,5:往返两段都是中转,6:其他往返,7:多程
     */
    private Integer subFlightType;

}
