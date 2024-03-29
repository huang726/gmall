package pojo;

import java.io.Serializable;

public class PmsBaseSaleAttr implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 销售属性名称
    */
    private String name;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}