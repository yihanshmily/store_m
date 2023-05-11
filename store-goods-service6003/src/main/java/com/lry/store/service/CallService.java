package com.lry.store.service;

import com.lry.store.domain.Shop;
import com.lry.store.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(value = "store-identity-service")
public interface CallService {

    //    根据商品删除消费记录
    @DeleteMapping("/wallet/goodsOfWallet/{ids}")
    public String deleteWalletDetails(@PathVariable("ids") String ids);

    //    删除指定商品的收藏
    @DeleteMapping("/collect/ofGoods/{ids}")
    public String delGoodsByIds(@PathVariable("ids") String ids);

    //    得到用户信息
    @GetMapping("/identity/get/user/{id}")
    public User getUserToOtherService(@PathVariable("id") String id);

    //    得到商铺信息
    @GetMapping("/identity/get/shop/{id}")
    public Shop getShopToOtherService(@PathVariable("id") String id);
}
