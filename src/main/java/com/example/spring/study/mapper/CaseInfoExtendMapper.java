package com.example.spring.study.mapper;

import com.example.spring.study.model.CaseInfoExtend;
import com.example.spring.study.model.CaseInfoExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseInfoExtendMapper {
    int countByExample(CaseInfoExtendExample example);

    int deleteByExample(CaseInfoExtendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CaseInfoExtend record);

    int insertSelective(CaseInfoExtend record);

    List<CaseInfoExtend> selectByExample(CaseInfoExtendExample example);

    CaseInfoExtend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CaseInfoExtend record, @Param("example") CaseInfoExtendExample example);

    int updateByExample(@Param("record") CaseInfoExtend record, @Param("example") CaseInfoExtendExample example);

    int updateByPrimaryKeySelective(CaseInfoExtend record);

    int updateByPrimaryKey(CaseInfoExtend record);
}