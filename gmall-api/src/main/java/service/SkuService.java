package service;

import pojo.PmsSkuInfo;

import java.util.List;

public interface SkuService {
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    public PmsSkuInfo getSkuById(String id);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(Long productId);
}
