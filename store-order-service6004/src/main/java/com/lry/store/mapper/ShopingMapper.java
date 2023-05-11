package com.lry.store.mapper;

import com.lry.store.domain.Shoping;
import com.lry.store.dto.ShopingDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopingMapper {
    Integer createShoping(Shoping shoping);

    List<ShopingDto> getShopingByUserId(@Param("userId") String userId);

    Integer deleteShoping(@Param("id") String id);

    Integer deleteGoodsOfShoping(@Param("ids") String ids);
}
