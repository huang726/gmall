package service;

import pojo.PmsBaseAttrInfo;

import java.util.List;

public interface AttrService {
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
}
