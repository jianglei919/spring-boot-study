package com.example.spring.study.web.controller;

import com.example.spring.study.mapper.CaseInfoExtendMapper;
import com.example.spring.study.mapper.CaseInfoFieldMapper;
import com.example.spring.study.mapper.CaseInfoMapper;
import com.example.spring.study.model.*;
import com.example.spring.study.util.ApiResult;
import com.example.spring.study.web.vo.response.CaseInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by jianglei on 2019/12/6.
 */
@Controller
@RequestMapping("/case")
public class CaseInfoController {

    @Resource
    private CaseInfoMapper caseInfoMapper;

    @Resource
    private CaseInfoExtendMapper caseInfoExtendMapper;

    @Resource
    private CaseInfoFieldMapper caseInfoFieldMapper;

    @RequestMapping("/queryCaseInfo")
    @ResponseBody
    public ApiResult<CaseInfoVO> queryCaseInfo(@RequestParam("id") Integer id) {
        CaseInfoVO vo = new CaseInfoVO();
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(id);
        CaseInfoExtendExample extendExample = new CaseInfoExtendExample();
        extendExample.or().andCaseIdEqualTo(id);
        List<CaseInfoExtend> caseInfoExtendList = caseInfoExtendMapper.selectByExample(extendExample);
        caseInfoExtendList.forEach(ext -> {
            CaseInfoFieldExample fieldExample = new CaseInfoFieldExample();
            CaseInfoField caseInfoField = caseInfoFieldMapper.selectByPrimaryKey(ext.getFieldId());
            caseInfoField.getFieldName();
        });
        BeanUtils.copyProperties(caseInfo, vo);
        return ApiResult.success(vo);
    }
}
