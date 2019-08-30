package com.example.spring.study.service;

import com.example.spring.study.entity.TbFlightInfoEntity;
import com.example.spring.study.model.FlightInfoModel;

/**
 * Created by jianglei on 2019/8/30.
 */
public interface FlightService {

    TbFlightInfoEntity findAllByIdFromJpa(Long id);

    FlightInfoModel selectById(Long id);
}
