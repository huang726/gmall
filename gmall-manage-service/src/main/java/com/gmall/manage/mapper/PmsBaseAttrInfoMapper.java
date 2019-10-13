package com.gmall.manage.mapper;

import pojo.PmsBaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseAttrInfoMapper extends Mapper<PmsBaseAttrInfo> {
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

}