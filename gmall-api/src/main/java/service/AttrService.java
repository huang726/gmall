package service;

import pojo.PmsBaseAttrInfo;
import pojo.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    public List<PmsBaseAttrValue> getAttrValueList(String attrId);

  //  public int
}
