package com.example.spring.study.mapper;

import com.example.spring.study.model.CaseInfoField;
import com.example.spring.study.model.CaseInfoFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseInfoFieldMapper {
    int countByExample(CaseInfoFieldExample example);

    int deleteByExample(CaseInfoFieldExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CaseInfoField record);

    int insertSelective(CaseInfoField record);

    List<CaseInfoField> selectByExample(CaseInfoFieldExample example);

    CaseInfoField selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CaseInfoField record, @Param("example") CaseInfoFieldExample example);

    int updateByExample(@Param("record") CaseInfoField record, @Param("example") CaseInfoFieldExample example);

    int updateByPrimaryKeySelective(CaseInfoField record);

    int updateByPrimaryKey(CaseInfoField record);
}