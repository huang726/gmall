package service;

import pojo.PmsProductInfo;

import java.util.List;

public interface SpuService {
    public List<PmsProductInfo> spuList(String catalog3Id);
}
