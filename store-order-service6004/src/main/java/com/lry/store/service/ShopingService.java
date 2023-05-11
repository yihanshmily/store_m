package com.lry.store.service;

import com.lry.store.domain.Shoping;

public interface ShopingService {
    String createShoping(Shoping shoping);

    String getShopingByUserId(String userId);

    String deleteShoping(String id);

    String deleteGoodsOfShoping(String ids);
}
