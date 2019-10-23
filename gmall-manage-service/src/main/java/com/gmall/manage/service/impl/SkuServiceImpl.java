package com.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.gmall.manage.mapper.PmsSkuImageMapper;
import com.gmall.manage.mapper.PmsSkuInfoMapper;
import com.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.gmall.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import pojo.PmsSkuAttrValue;
import pojo.PmsSkuImage;
import pojo.PmsSkuInfo;
import pojo.PmsSkuSaleAttrValue;
import redis.clients.jedis.Jedis;
import service.PmsBaseCatalogService;
import service.SkuService;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Resource
    PmsSkuImageMapper pmsSkuImageMapper;

    @Resource
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Resource
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        Long index = pmsSkuInfo.getId();
        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(index);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(index);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(index);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }
    }

    @Override
    public PmsSkuInfo getSkuById(String skuId) {
        /*PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(Long.valueOf(id));
        PmsSkuInfo skuInfo = pmsSkuInfoMapper.selectOne(pmsSkuInfo);
        PmsSkuImage pmsSku?Image = new PmsSkuImage();
        pmsSkuImage.setSkuId(Long.valueOf(id));
        List<PmsSkuImage> list = pmsSkuImageMapper.select(pmsSkuImage);
        skuInfo.setSkuImageList(list);
        return skuInfo;*/
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        // 链接缓存
        Jedis jedis = redisUtil.getJedis();
        // 查询缓存
        String skuKey = "sku:" + skuId + ":info";
        String skuJson = jedis.get(skuKey);
        String token = UUID.randomUUID().toString();
        if (StringUtils.isNotBlank(skuJson)) {//if(skuJson!=null&&!skuJson.equals(""))
            pmsSkuInfo = JSON.parseObject(skuJson, PmsSkuInfo.class);
        } else {
            // 如果缓存中没有，查询mysql
            // 设置分布式锁
            String OK = jedis.set("sku:" + skuId + ":lock", token, "nx", "px", 10);
            if (StringUtils.isNotBlank(OK) && OK.equals("OK")) {
                // 设置成功，有权在10秒的过期时间内访问数据库
                PmsSkuInfo pmsSkuInfoId = new PmsSkuInfo();
                pmsSkuInfoId.setId(Long.valueOf(skuId));
                pmsSkuInfo = pmsSkuInfoMapper.selectOne(pmsSkuInfoId);
                PmsSkuImage pmsSkuImage = new PmsSkuImage();
                pmsSkuImage.setSkuId(Long.valueOf(skuId));
                List<PmsSkuImage> list = pmsSkuImageMapper.select(pmsSkuImage);
                pmsSkuInfo.setSkuImageList(list);
                if (pmsSkuInfo != null) {
                    // mysql查询结果存入redis
                    jedis.set("sku:" + skuId + ":info", JSON.toJSONString(pmsSkuInfo));
                } else {
                    // 数据库中不存在该sku
                    // 为了防止缓存穿透将，null或者空字符串值设置给redis
                    jedis.setex("sku:" + skuId + ":info", 60 * 3, JSON.toJSONString(""));
                }
                String lockToken = jedis.get("sku:" + skuId + ":lock"); //获取

                if (StringUtils.isNotBlank(lockToken) && lockToken.equals(token)){
                    jedis.del("sku:" + skuId + ":lock");
                }
            } else {
                // 设置失败，自旋（该线程在睡眠几秒后，重新尝试访问本方法）
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return getSkuById(skuId);
            }
        }
        jedis.close();
        return pmsSkuInfo;

    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(Long productId) {
        return pmsSkuInfoMapper.getSkuSaleAttrValueListBySpu(productId);
    }

}
