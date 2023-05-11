package com.lry.store.service;

public interface CollectService {
    String getUserByShopId(String shopId,Integer currentPage,Integer pageSize);

    String updateCollectOfUserGoods(String userId, String goodsId,String shopId, Boolean isCollect);

    String isCollect(String userId, String goodsId);

    String getGoodsAllOfUserId(String userId);

    String getCount(String userId);

    String delAllCollect(String userId);

    String delGoodsByIds(String ids);
}
