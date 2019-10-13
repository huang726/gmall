package service;

import pojo.PmsBaseCatalog1;
import pojo.PmsBaseCatalog2;
import pojo.PmsBaseCatalog3;

import java.util.List;

public interface PmsBaseCatalogService {

    public List<PmsBaseCatalog1> getCatalog1();

    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
