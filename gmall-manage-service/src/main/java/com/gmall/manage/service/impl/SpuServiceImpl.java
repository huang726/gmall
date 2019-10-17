package com.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gmall.manage.mapper.PmsProductImageMapper;
import com.gmall.manage.mapper.PmsProductInfoMapper;
import com.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.stylesheets.LinkStyle;
import pojo.PmsProductImage;
import pojo.PmsProductInfo;
import pojo.PmsProductSaleAttr;
import pojo.PmsProductSaleAttrValue;
import service.SpuService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Resource
    PmsProductInfoMapper pmsProductInfoMapper;

    @Resource
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Resource
    PmsProductImageMapper pmsProductImageMapper;

    @Resource
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;


    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(Long.valueOf(catalog3Id));
        List<PmsProductInfo> list = pmsProductInfoMapper.select(pmsProductInfo);
        return list;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        // 保存商品信息
        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        // 生成商品主键
        Long productId = pmsProductInfo.getId();

        // 保存商品图片信息
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        // 保存销售属性信息
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

            // 保存销售属性值
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }
    }
}
