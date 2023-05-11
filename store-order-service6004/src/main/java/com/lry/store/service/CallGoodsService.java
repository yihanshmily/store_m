package com.lry.store.service;

import com.lry.store.domain.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(value = "store-goods-service")
public interface CallGoodsService {

    //    减少库存
    @PutMapping("/repertory/{goodsId}/{number}")
    public String desRepertory(@PathVariable("goodsId") String goodsId,
                               @PathVariable("number") Integer number);

    //    获取指定订单id的评论
    @GetMapping("/goods/comment/getOrder/{orderId}")
    public Comment getCommentByOrderId(@PathVariable("orderId") String orderId);

    //    修改商品的销售额
    @PutMapping("/goods/{goodsId}/{saleRoom}")
    public String updateGoodsSaleRoom(@PathVariable("goodsId") String goodsId,
                                      @PathVariable("saleRoom") Integer saleRoom);

    //    修改已领取的优惠卷
    @PutMapping("/coupon/putGet/{userId}/{couponId}")
    public String updateGetCoupon(@PathVariable("userId") String userId,
                                  @PathVariable("couponId") String couponId);
}
