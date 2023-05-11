package com.lry.store.mapper;

import com.lry.store.domain.Manager;
import com.lry.store.domain.Shop;
import com.lry.store.domain.ShopDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopMapper {

    int getCounts(@Param("searchName") String searchName);

    List<Shop> getAllByLikes(@Param("searchName") String searchName,@Param("currentPage")Integer currentPage,
                       @Param("number")Integer number);

    Shop getOnlyInfoById(@Param("id") String id);

    void updateStatus(@Param("id") String id);

    String getImg(@Param("news") String news);

    Integer createShop(Shop shop);

    Integer createShopDetail(Shop shop);

    Shop getShopInfoByName(@Param("name") String name,@Param("id") String id);

    Integer updateShop(Shop shop);

    Integer updatePwd(@Param("id") String id, @Param("oldPwd") String oldPwd, @Param("newPwd") String newPwd);
}
