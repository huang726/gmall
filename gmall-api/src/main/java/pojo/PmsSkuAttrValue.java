package pojo;

import java.io.Serializable;

public class PmsSkuAttrValue implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 属性id（冗余)
    */
    private Long attrId;

    /**
    * 属性值id
    */
    private Long valueId;

    /**
    * skuid
    */
    private Long skuId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}