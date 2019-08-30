package com.example.spring.study.service.impl;

import com.example.spring.study.entity.TbFlightInfoEntity;
import com.example.spring.study.mapper.FlightInfoModelMapper;
import com.example.spring.study.model.FlightInfoModel;
import com.example.spring.study.repository.FlightInfoRepository;
import com.example.spring.study.service.FlightService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jianglei on 2019/8/30.
 */
@Service
public class FlightServiceImpl implements FlightService {

    @Resource
    private FlightInfoModelMapper flightInfoModelMapper;

    @Resource
    private FlightInfoRepository flightInfoRepository;

    public TbFlightInfoEntity findAllByIdFromJpa(Long id) {
        Preconditions.checkNotNull(id, "id is not null");
        Preconditions.checkArgument(id.intValue() != -1);
        Preconditions.checkArgument(id > 0);
        List<TbFlightInfoEntity> list = flightInfoRepository.findAllById(Lists.newArrayList(id));
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

    public FlightInfoModel selectById(Long id) {
        FlightInfoModel flightInfoModel = flightInfoModelMapper.selectByPrimaryKey(id);
        return flightInfoModel;
    }
}
