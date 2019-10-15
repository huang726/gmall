package com.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gmall.manage.mapper.PmsProductInfoMapper;
import org.w3c.dom.stylesheets.LinkStyle;
import pojo.PmsProductInfo;
import pojo.PmsProductSaleAttr;
import service.SpuService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Resource
    PmsProductInfoMapper pmsProductInfoMapper;


    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(Long.valueOf(catalog3Id));
        List<PmsProductInfo> list = pmsProductInfoMapper.select(pmsProductInfo);
        return list;
    }


}
