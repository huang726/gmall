package com.gmall.manage.mapper;

import pojo.PmsBaseCatalog3;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseCatalog3Mapper extends Mapper<PmsBaseCatalog3> {
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
