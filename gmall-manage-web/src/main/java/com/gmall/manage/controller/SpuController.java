package com.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.manage.util.PmsUploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.PmsProductImage;
import pojo.PmsProductInfo;
import pojo.PmsProductSaleAttr;
import service.SpuService;

import java.util.List;

@RestController
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("/spuList")
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return spuService.spuList(catalog3Id);
    }

    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile file) {
        // 将图片或者音视频上传到分布式的文件存储系统
        String imgUrl = PmsUploadUtil.uploadImage(file);
        // 将图片的存储路径返回给页面
        System.out.println(imgUrl);
        return imgUrl;
    }

    @RequestMapping("/spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }

    @RequestMapping("/spuImageList")
    public List<PmsProductImage> spuImageList(String spuId){
        List<PmsProductImage> pmsProductImages = spuService.spuImageList(spuId);
        return pmsProductImages;
    }
}
