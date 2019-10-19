package com.gmall.manage.mapper;

import pojo.PmsSkuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo> {
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(Long productId);
}