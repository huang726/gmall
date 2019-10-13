package pojo;

import java.io.Serializable;

public class PmsBaseCatalog3 implements Serializable {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 三级分类名称
    */
    private String name;

    /**
    * 二级分类编号
    */
    private Long catalog2Id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(Long catalog2Id) {
        this.catalog2Id = catalog2Id;
    }
}