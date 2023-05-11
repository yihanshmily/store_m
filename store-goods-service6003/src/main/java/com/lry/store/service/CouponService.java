package com.lry.store.service;

import com.lry.store.domain.Coupon;
import com.lry.store.domain.UCoupon;

public interface CouponService {
    String getCouponsByShopId(String shopId, String goodsId);

    String getCouponByShopId(String shopId);

    String createCoupon(Coupon coupon);

    String getOne(String id);

    String updateCoupon(Coupon coupon);

    String isZero(String couponId);

    String deleteCoupon(String id);

    String userAddCoupon(UCoupon uCoupon);

    String getUserCoupon(String userId);

    String getGoodsCoupon(String userId,String goodsId);

    String getSelGoodsCoupon(String userId, String goodsId);

    String updateGetCoupon(String userId, String couponId);
}
