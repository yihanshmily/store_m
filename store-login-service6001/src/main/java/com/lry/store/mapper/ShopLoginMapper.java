package com.lry.store.mapper;

import com.lry.store.domain.Shop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopLoginMapper {
    Shop shopLogin(Shop shop);
}
