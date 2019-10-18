package pojo;

import java.io.Serializable;

public class PmsSkuSaleAttrValue implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 库存单元id
    */
    private Long skuId;

    /**
    * 销售属性id（冗余)
    */
    private Long saleAttrId;

    /**
    * 销售属性值id
    */
    private Long saleAttrValueId;

    /**
    * 销售属性名称(冗余)
    */
    private String saleAttrName;

    /**
    * 销售属性值名称(冗余)
    */
    private String saleAttrValueName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(Long saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public Long getSaleAttrValueId() {
        return saleAttrValueId;
    }

    public void setSaleAttrValueId(Long saleAttrValueId) {
        this.saleAttrValueId = saleAttrValueId;
    }

    public String getSaleAttrName() {
        return saleAttrName;
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName;
    }

    public String getSaleAttrValueName() {
        return saleAttrValueName;
    }

    public void setSaleAttrValueName(String saleAttrValueName) {
        this.saleAttrValueName = saleAttrValueName;
    }
}