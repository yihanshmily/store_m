package com.lry.store.service;

import com.lry.store.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "store-goods-service")
public interface CallGoodsService {

    @GetMapping("/goods/getShopGoodsCount/{shopId}")
    public int getShopGoodsCountByShopId(@PathVariable("shopId") String shopId);

    //    查询某个商品的所有商品
    @GetMapping("/goods/{shopId}/{categoryId}/{currentPage}/{pageSize}")
    public List<Goods> getShopGoodsById(@PathVariable("shopId") String shopId,
                                        @PathVariable("categoryId") String categoryId,
                                        @PathVariable("currentPage") Integer currentPage,
                                        @PathVariable("pageSize") Integer pageSize);
}
