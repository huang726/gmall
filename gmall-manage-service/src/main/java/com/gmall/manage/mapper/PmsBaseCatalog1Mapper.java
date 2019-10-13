package com.gmall.manage.mapper;

import pojo.PmsBaseCatalog1;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseCatalog1Mapper extends Mapper<PmsBaseCatalog1> {
    public List<PmsBaseCatalog1> getCatalog1();

}