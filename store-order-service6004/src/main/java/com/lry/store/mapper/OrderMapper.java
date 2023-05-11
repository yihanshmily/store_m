package com.lry.store.mapper;

import com.lry.store.domain.Comment;
import com.lry.store.domain.Coupon;
import com.lry.store.domain.Order;
import com.lry.store.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> getOrdersIsShopOfShopId(@Param("shopId") String shopId,
                                     @Param("currentPage") Integer currentPage,
                                     @Param("searchTime") String searchTime);

    OrderDto getOrderById(@Param("orderId") String orderId);

    Integer putOrderOfShop(@Param("id") String id);

    List<OrderDto> getGainOfShopId(@Param("shopId") String shopId,
                                   @Param("currentPage") Integer currentPage,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("searchTime") String searchTime);

    Integer createOrder(Order order);

    List<OrderDto> getOrderOfSeralByUserId(@Param("seral") String seral, @Param("userId") String userId);

    OrderDto getOrderByUserId(@Param("id") String id);

    Coupon getOrderCouponId(@Param("id") String id);

    Integer updateOrderStatus(@Param("id") String id, @Param("status") String status);

    Integer putOrderOfUser(@Param("id") String id);

    Integer delGoodsOfOrder(@Param("ids") String ids);
}
