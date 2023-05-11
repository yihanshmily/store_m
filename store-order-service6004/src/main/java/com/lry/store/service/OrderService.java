package com.lry.store.service;

import com.lry.store.domain.Order;
import com.lry.store.dto.OrderDto;
import com.lry.store.dto.PageDto;

public interface OrderService {
    PageDto getOrdersOfShopId(String identity,String shopId, Integer currentPage, String searchTime);

    String getOrderById(String orderId);

    String putOrderOfShop(String id);

    String getGainOfShopId(String shopId, Integer currentPage, Integer pageSize, String searchTime);

    String createOrder(Order order);

    String getOrderOfSeralByUserId(String seral, String userId);

    String getDetailOrder(String id);

    String updateOrderStatus(String id, String status);

    String putOrderOfUser(String id);

    String delGoodsOfOrder(String ids);
}
