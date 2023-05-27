package com.lry.store.service.impl;

import com.lry.store.domain.Goods;
import com.lry.store.domain.Shop;
import com.lry.store.dto.PageDto;
import com.lry.store.mapper.ShopMapper;
import com.lry.store.service.CallGoodsService;
import com.lry.store.service.ShopService;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private CallGoodsService callGoodsService;

    @Override
    public PageDto getAllByLikes(String searchName,Integer currentPage, Integer number) {
        PageDto pageDto = new PageDto();
        List<Shop> managerList = shopMapper.getAllByLikes(searchName,(currentPage-1)*number,number);
        int counts = shopMapper.getCounts(searchName);
        pageDto.setDataList(managerList);
        pageDto.setNumbers(counts);
        pageDto.setTotalPages(counts/number);
        return pageDto;
    }

    @Override
    public Shop getOnlyInfoById(String id) {
        return shopMapper.getOnlyInfoById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(String id) {
        shopMapper.updateStatus(id);
    }

    @Override
    public PageDto getGoodsOfShopId(String id, String categoryId,Integer currentPage, Integer pageSize) {
        PageDto pageDto = new PageDto();
        List<Goods> goodsList = callGoodsService.getShopGoodsById(id, categoryId, currentPage, pageSize);
        for (Goods goods : goodsList) {
            String[] img = goods.getImg().split(",");
            goods.setImg(img[0]);
        }
        int count = callGoodsService.getShopGoodsCountByShopId(id);
        pageDto.setNumbers(count);
        pageDto.setTotalPages(count/pageSize);
        pageDto.setDataList(goodsList);
        return pageDto;
    }

    @Override
    public String getImg(String news) {
        return shopMapper.getImg(news);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
//    @GlobalTransactional(name = "shop_add",rollbackFor = Exception.class)
    public Integer createShop(Shop shop) {
        String shopId = SnowflakeIdWorker.getNextId();
        shop.setId(shopId);
        shop.setSole(SnowflakeIdWorker.getNextId().substring(12, 18));
        Integer integer1 = shopMapper.createShop(shop);
//        因两张表的id属性名相同，故此处覆盖上一个setId
        shop.setId(SnowflakeIdWorker.getNextId());
        shop.setShopId(shopId);
        shop.setCreateTime(new Date());
        Integer integer2 = shopMapper.createShopDetail(shop);
        return integer1+integer2;
    }

    @Override
    public Shop getShopInfoByName(String name,String id) {
        return shopMapper.getShopInfoByName(name,id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateShop(Shop shop) {
        shop.setUpdateTime(new Date());
        return shopMapper.updateShop(shop);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updatePwd(String id, String oldPwd, String newPwd) {
       return shopMapper.updatePwd(id,oldPwd,newPwd);
    }
}
