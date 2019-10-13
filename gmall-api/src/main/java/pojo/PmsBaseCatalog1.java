package pojo;

import java.io.Serializable;

public class PmsBaseCatalog1 implements Serializable {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 分类名称
    */
    private String name;

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
}