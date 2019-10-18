package com.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.PmsProductSaleAttr;
import pojo.PmsSkuInfo;
import service.SkuService;
import service.SpuService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    @Reference
    SkuService skuService;

    @Reference
    SpuService spuService;

    @RequestMapping("/{skuId}")
    public String getSkuById(@PathVariable String skuId, ModelMap modelMap) {
        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);
        modelMap.put("skuInfo", pmsSkuInfo);
        List<PmsProductSaleAttr> list = spuService.selectSpuSaleAttrListCheckBySku(String.valueOf(pmsSkuInfo.getProductId()), pmsSkuInfo.getSpuId());
        modelMap.put("spuSaleAttrListCheckBySku", list);
        return "item";
    }
}