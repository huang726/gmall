package com.gmall.manage.mapper;

import pojo.PmsBaseCatalog2;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseCatalog2Mapper extends Mapper<PmsBaseCatalog2> {
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id);
}
