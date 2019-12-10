package com.example.spring.study.mapper;

import com.example.spring.study.model.CaseInfo;
import com.example.spring.study.model.CaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseInfoMapper {
    int countByExample(CaseInfoExample example);

    int deleteByExample(CaseInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CaseInfo record);

    int insertSelective(CaseInfo record);

    List<CaseInfo> selectByExample(CaseInfoExample example);

    CaseInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CaseInfo record, @Param("example") CaseInfoExample example);

    int updateByExample(@Param("record") CaseInfo record, @Param("example") CaseInfoExample example);

    int updateByPrimaryKeySelective(CaseInfo record);

    int updateByPrimaryKey(CaseInfo record);
}