package pojo;

import java.io.Serializable;

public class PmsSkuImage implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 商品id
    */
    private Long skuId;

    /**
    * 图片名称（冗余）
    */
    private String imgName;

    /**
    * 图片路径(冗余)
    */
    private String imgUrl;

    /**
    * 商品图片id
    */
    private Long spuImgId;

    /**
    * 是否默认
    */
    private String isDefault;

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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Long getSpuImgId() {
        return spuImgId;
    }

    public void setSpuImgId(Long spuImgId) {
        this.spuImgId = spuImgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}