package com.lry.store.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(value = "store-order-service")
public interface CallOrderService {

    //    根据商品删除购物车
    @DeleteMapping("/shoping/goodsOfShoping/{ids}")
    public String deleteGoodsOfShoping(@PathVariable("ids") String ids);

    //    根据商品删除订单
    @DeleteMapping("/order/goodsOfOrder/{ids}")
    public String delGoodsOfOrder(@PathVariable("ids") String ids);

    //    修改订单状态
    @PutMapping("/order/{id}/{status}")
    public String updateOrderStatus(@PathVariable("id") String id, @PathVariable("status") String status);
}
