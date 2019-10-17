package service;

import pojo.PmsProductImage;
import pojo.PmsProductInfo;
import pojo.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    public List<PmsProductInfo> spuList(String catalog3Id);

    public void saveSpuInfo(PmsProductInfo pmsProductInfo);

    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    public List<PmsProductImage> spuImageList(String spuId);
}
