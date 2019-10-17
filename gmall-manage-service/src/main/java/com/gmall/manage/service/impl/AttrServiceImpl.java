package com.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gmall.manage.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.PmsBaseAttrInfo;
import pojo.PmsBaseAttrValue;
import pojo.PmsBaseSaleAttr;
import pojo.PmsProductSaleAttr;
import service.AttrService;
import org.apache.commons.lang3.StringUtils.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {
    @Resource
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Resource
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Resource
    PmsBaseSaleAttrMapper PmsBaseSaleAttrMapper;



    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {

        if (StringUtils.isBlank(String.valueOf(pmsBaseAttrInfo.getId()))) {
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            List<PmsBaseAttrValue> list = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : list) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        } else {
            Long id = pmsBaseAttrInfo.getId();
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id", id);
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo, example);

            PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
            pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);

            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        }
        return "success";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(Long.valueOf(attrId));
        List<PmsBaseAttrValue> list = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return list;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return PmsBaseSaleAttrMapper.selectAll();
    }

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo attrInfo = new PmsBaseAttrInfo();
        attrInfo.setCatalog3Id(Long.valueOf(catalog3Id));
        List<PmsBaseAttrInfo> list = pmsBaseAttrInfoMapper.select(attrInfo);
        return list;
    }


}
