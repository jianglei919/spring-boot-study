package com.example.spring.study.web.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by jianglei on 2019/9/3.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  //null不参与json序列号
@Setter
@Getter
public class BaseSearchResult implements Serializable {

    private String orderNo;

    private String productNo;

    private String stockMd5;
}
