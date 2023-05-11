package com.lry.store.controller;

import com.lry.store.domain.Shoping;
import com.lry.store.service.ShopingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/shoping")
public class ShopingController {

    @Resource
    private ShopingService shopingService;

//    新增购物车
    @PostMapping
    public String createShoping(@RequestBody Shoping shoping){
        return shopingService.createShoping(shoping);
    }

//    从购物车中移除
    @DeleteMapping("/{id}")
    public String deleteShoping(@PathVariable("id") String id){
        return shopingService.deleteShoping(id);
    }

//    获取指定用户的购物车数据
    @GetMapping("/{userId}")
    public String getShopingByUserId(@PathVariable("userId") String userId){
        return shopingService.getShopingByUserId(userId);
    }

    /*
    * 供其他服务调用
    * */

//    根据商品删除购物车
    @DeleteMapping("/goodsOfShoping/{ids}")
    public String deleteGoodsOfShoping(@PathVariable("ids") String ids){
        return shopingService.deleteGoodsOfShoping(ids);
    }
}
