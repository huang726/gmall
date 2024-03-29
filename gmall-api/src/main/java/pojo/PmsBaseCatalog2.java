package pojo;

import java.io.Serializable;

public class PmsBaseCatalog2 implements Serializable {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 二级分类名称
    */
    private String name;

    /**
    * 一级分类编号
    */
    private Integer catalog1Id;

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

    public Integer getCatalog1Id() {
        return catalog1Id;
    }

    public void setCatalog1Id(Integer catalog1Id) {
        this.catalog1Id = catalog1Id;
    }
}