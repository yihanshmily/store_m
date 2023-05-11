package com.lry.store.service;

import com.lry.store.domain.Goods;
import com.lry.store.dto.PageDto;

import java.util.List;

public interface GoodsService {
    void addGoods(Goods goods);

    PageDto getAllGoods(Integer currentPage, Integer pageSize);

    Goods getGoodsById(String goodsId,String userId);

    List<Goods> getShopGoodsById(String shopId,String categoryId,Integer currentPage, Integer pageSize);

    int getShopGoodsCountByShopId(String shopId);

   PageDto getShopGoodsByIdOfMySelf(String shopId, String categoryId, Integer currentPage, Integer pageSize);

    String deleteById(String ids);

    String updateGoodsById(Goods goods);

    String getGoodsBySeral(String seral, Integer currentPage, Integer pageSize);

    String getGoodsByCategory(String categoryId);

    String getGoodsLikeName(String searchName);

    String getGoodsByShopId(String shopId);

    String updateGoodsSaleRoom(String goodsId, Integer saleRoom);
}
