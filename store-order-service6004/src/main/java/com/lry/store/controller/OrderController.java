package com.lry.store.controller;

import com.lry.store.domain.Order;
import com.lry.store.service.OrderService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /*
    * 新增
    * */

//    下单
    @PostMapping
    public String createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    //    根据id进行商铺订单删除
    @PutMapping("/updateShop/{id}")
    public String putOrderOfShop(@PathVariable("id") String id){
        return orderService.putOrderOfShop(id);
    }

    //    根据id进行用户订单删除
    @PutMapping("/updateUser/{id}")
    public String putOrderOfUser(@PathVariable("id") String id){
        return orderService.putOrderOfUser(id);
    }

//    根据shopId获取指定时间内的收益
    @GetMapping("/getGain/{shopId}/{currentPage}/{pageSize}/{searchTime}")
    public String getGainOfShopId(@PathVariable("shopId") String shopId,
                                  @PathVariable("currentPage") Integer currentPage,
                                  @PathVariable("searchTime") String searchTime,
                                  @PathVariable("pageSize") Integer pageSize){
        return orderService.getGainOfShopId(shopId, currentPage,pageSize,searchTime);
    }

//    根据id获取指定订单所有信息
    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable("orderId") String orderId){
        return orderService.getOrderById(orderId);
    }

//    根据不同身份查询，根据时间获取所有指定商铺的所有商品部分信息
    @GetMapping("/{identity}/{shopId}/{currentPage}/{searchTime}")
    public String getOrdersOfShopId(@PathVariable("identity") String identity,
                                    @PathVariable("shopId") String shopId,
                                    @PathVariable("currentPage") Integer currentPage,
                                    @PathVariable("searchTime") String searchTime){
        return R.success(orderService.getOrdersOfShopId(identity,shopId, currentPage,searchTime));
    }

//    获取指定用户不同状态的订单信息
    @GetMapping("/{seral}/{userId}")
    public String getOrderOfSeralByUserId(@PathVariable("seral") String seral,
                                          @PathVariable("userId") String userId){
        return orderService.getOrderOfSeralByUserId(seral,userId);
    }

//    获取指定用户所订单的详情
    @GetMapping("/detail/{id}")
    public String getDetailOrder(@PathVariable("id") String id){
        return orderService.getDetailOrder(id);
    }

    /*
    * 供其他服务调用
    * */

//    根据商品删除订单
    @DeleteMapping("/goodsOfOrder/{ids}")
    public String DelGoodsOfOrder(@PathVariable("ids") String ids){
        return orderService.delGoodsOfOrder(ids);
    }

//    修改订单状态
    @PutMapping("/{id}/{status}")
    public String updateOrderStatus(@PathVariable("id") String id, @PathVariable("status") String status){
        return orderService.updateOrderStatus(id,status);
    }
}
