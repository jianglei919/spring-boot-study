package com.example.spring.study.mapper;

import com.example.spring.study.model.FlightInfoModel;
import com.example.spring.study.model.FlightInfoModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlightInfoModelMapper {
    int countByExample(FlightInfoModelExample example);

    int deleteByExample(FlightInfoModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlightInfoModel record);

    int insertSelective(FlightInfoModel record);

    List<FlightInfoModel> selectByExample(FlightInfoModelExample example);

    FlightInfoModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlightInfoModel record, @Param("example") FlightInfoModelExample example);

    int updateByExample(@Param("record") FlightInfoModel record, @Param("example") FlightInfoModelExample example);

    int updateByPrimaryKeySelective(FlightInfoModel record);

    int updateByPrimaryKey(FlightInfoModel record);
}