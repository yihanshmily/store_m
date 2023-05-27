package com.lry.store.service.impl;

import com.lry.store.domain.Comment;
import com.lry.store.domain.Coupon;
import com.lry.store.domain.Order;
import com.lry.store.dto.OrderDto;
import com.lry.store.dto.PageDto;
import com.lry.store.mapper.OrderMapper;
import com.lry.store.service.CallGoodsService;
import com.lry.store.service.CallIdentityService;
import com.lry.store.service.OrderService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private CallIdentityService callIdentityService;

    @Resource
    private CallGoodsService callGoodsService;

    @Override
    public PageDto getOrdersOfShopId(String identity,String shopId, Integer currentPage, String searchTime) {
        PageDto pageDto = new PageDto();
        if("shop".equals(identity)){
            List<OrderDto> orderList = orderMapper.getOrdersIsShopOfShopId(shopId, (currentPage-1) * 4, searchTime);
            for (OrderDto orderDto : orderList) {
                String[] split = orderDto.getGoodsImg().split(",");
                orderDto.setGoodsImg(split[0]);
            }
            int number = orderList.size();
            pageDto.setNumbers(number);
            pageDto.setTotalPages(number/4);
            pageDto.setDataList(orderList);
        }
        return pageDto;
    }

    @Override
    public String getOrderById(String orderId) {
        OrderDto orderDto = orderMapper.getOrderById(orderId);
        String[] split = orderDto.getGoodsImg().split(",");
        orderDto.setGoodsImg(split[0]);
        if(orderDto.getCouponId() != null){
            Coupon coupon = orderMapper.getOrderCouponId(orderDto.getId());
            orderDto.setCouponMeetMoney(coupon.getMeetMoney());
            orderDto.setCouponCutMoney(coupon.getCutMoney());
        }
        return R.success(orderDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String putOrderOfShop(String id) {
        Integer integer = orderMapper.putOrderOfShop(id);
        return R.returnString(integer);
    }

    @Override
//    @GlobalTransactional(name = "order_getByShopId",rollbackFor = Exception.class)
    public String getGainOfShopId(String shopId, Integer currentPage, Integer pageSize, String searchTime) {
        PageDto pageDto = new PageDto();
        List<OrderDto> orderDtoList = orderMapper.getGainOfShopId(shopId, (currentPage - 1) * pageSize, pageSize, searchTime);
        Double sum = 0.0;
        for (OrderDto orderDto : orderDtoList) {
            sum += orderDto.getTotalPrice();
            pageDto.setGainMoney(sum);
        }
        Integer number = orderDtoList.size();
        pageDto.setNumbers(number);
        pageDto.setTotalPages(number/pageSize);
        pageDto.setDataList(orderDtoList);
        return R.success(pageDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createOrder(Order order) {
        order.setSole(SnowflakeIdWorker.getNextId().substring(12,18));
        order.setId(SnowflakeIdWorker.getNextId());
//        创建订单
        Integer integer = orderMapper.createOrder(order);
        if(integer>=1){
//            创建订单消费记录
            callIdentityService.desWallet(order.getUserId(),order.getGoodsId(),order.getTotalPrice());
        }
//        修改商品的库存数
        callGoodsService.desRepertory(order.getGoodsId(),order.getNumber());
//        修改商品的销售额
        callGoodsService.updateGoodsSaleRoom(order.getGoodsId(),order.getNumber());
//        删除此订单所消耗的优惠卷
        if(order.getCouponId() != null){
            callGoodsService.updateGetCoupon(order.getUserId(),order.getCouponId());
        }
        return R.returnString(integer);
    }

    @Override
    public String getOrderOfSeralByUserId(String seral, String userId) {
        List<OrderDto> orderDtoList = orderMapper.getOrderOfSeralByUserId(seral, userId);
        for (OrderDto orderDto : orderDtoList) {
            String[] split = orderDto.getGoodsImg().split(",");
            orderDto.setGoodsImg(split[0]);
        }
        return R.success(orderDtoList);
    }

    @Override
    public String getDetailOrder(String id) {
        OrderDto orderDto = orderMapper.getOrderByUserId(id);
        Coupon coupon = null;
        Comment comment = null;
        if(orderDto.getCouponId()!=null) {
            coupon = orderMapper.getOrderCouponId(id);
            orderDto.setCouponMeetMoney(coupon.getMeetMoney());
            orderDto.setCouponCutMoney(coupon.getCutMoney());
        }
        if(orderDto.getCommentId()!=null) {
            comment = callGoodsService.getCommentByOrderId(orderDto.getId());
            orderDto.setCommentScore(comment.getScore());
        }
            String[] split = orderDto.getGoodsImg().split(",");
            orderDto.setGoodsImg(split[0]);
        return R.success(orderDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateOrderStatus(String id, String status) {
        Integer integer = orderMapper.updateOrderStatus(id, status);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String putOrderOfUser(String id) {
        Integer integer = orderMapper.putOrderOfUser(id);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delGoodsOfOrder(String ids) {
        Integer integer = orderMapper.delGoodsOfOrder(ids);
        return R.returnString(integer);
    }
}
