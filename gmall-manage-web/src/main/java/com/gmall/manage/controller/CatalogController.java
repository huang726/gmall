package com.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.PmsBaseCatalog1;
import pojo.PmsBaseCatalog2;
import pojo.PmsBaseCatalog3;
import service.PmsBaseCatalogService;


import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    PmsBaseCatalogService pmsBaseCatalog1Service;


    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> list = pmsBaseCatalog1Service.getCatalog1();
        return list;
    }

    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        List<PmsBaseCatalog2> list = pmsBaseCatalog1Service.getCatalog2(catalog1Id);
        return list;
    }

    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3( String catalog2Id) {
        List<PmsBaseCatalog3> list = pmsBaseCatalog1Service.getCatalog3(catalog2Id);
        return list;
    }
}
