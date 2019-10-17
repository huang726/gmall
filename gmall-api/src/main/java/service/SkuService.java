package service;

import pojo.PmsSkuInfo;

public interface SkuService {
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    public PmsSkuInfo getSkuById(String id);
}
