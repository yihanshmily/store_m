package com.lry.store.mapper;

import com.lry.store.domain.Coupon;
import com.lry.store.domain.UCoupon;
import com.lry.store.dto.CouponDto;
import com.lry.store.dto.UCouponDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CouponMapper {
    List<CouponDto> getCouponsByShopId(@Param("shopId") String shopId, @Param("goodsId") String goodsId);

    List<CouponDto> getCouponByShopId(@Param("shopId") String shopId);

    Integer createCoupon(Coupon coupon);

    Coupon getOne(@Param("id") String id);

    Integer updateCoupon(Coupon coupon);

    Integer isZero(@Param("couponId") String couponId);

    Integer deleteCoupon(@Param("id") String id);

    Integer addCoupon(UCoupon uCoupon);

    List<UCouponDto> getCouponCount(@Param("shopId") String shopId);

    List<CouponDto> getUserCoupon(@Param("userId") String userId);

    List<CouponDto> getGoodsCoupon(@Param("userId") String userId,@Param("goodsId") String goodsId);

    List<CouponDto> getSelGoodsCoupon(@Param("userId") String userId,@Param("goodsId") String goodsId);

    Integer updateGetCoupon(@Param("userId") String userId, @Param("couponId") String couponId);
}
