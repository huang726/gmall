package com.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import pojo.PmsBaseCatalog1;
import pojo.PmsBaseCatalog2;
import pojo.PmsBaseCatalog3;
import service.PmsBaseCatalogService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmsBaseCatalogServiceImpl implements PmsBaseCatalogService {

    @Resource
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Resource
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Resource
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.select(null);
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(Integer.valueOf(catalog1Id));
        List<PmsBaseCatalog2> p2 = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
        return p2;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(Long.valueOf(catalog2Id));
        List<PmsBaseCatalog3> p3 = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        return p3;
    }
}
