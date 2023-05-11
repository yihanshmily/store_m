package com.lry.store.service;

import com.lry.store.domain.Shop;
import com.lry.store.dto.PageDto;

public interface ShopService {

    PageDto getAllByLikes(String searchName,Integer currentPage, Integer number);

    Shop getOnlyInfoById(String id);

    void updateStatus(String id);

    PageDto getGoodsOfShopId(String id, String categoryId,Integer currentPage, Integer pageSize);

    String getImg(String news);

    Integer createShop(Shop shop);

    Shop getShopInfoByName(String name,String id);

    Integer updateShop(Shop shop);

    Integer updatePwd(String id, String oldPwd, String newPwd);
}
