package com.lry.store.controller;

import com.lry.store.domain.Coupon;
import com.lry.store.domain.UCoupon;
import com.lry.store.service.CouponService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/coupon")
public class CouponController {

    @Resource
    private CouponService couponService;

//    新增优惠卷
    @PostMapping
    public String createCoupon(@RequestBody Coupon coupon){
        return couponService.createCoupon(coupon);
    }

    //    领取优惠卷
    @PostMapping("/get")
    public String userAddCoupon(@RequestBody UCoupon uCoupon){
        return couponService.userAddCoupon(uCoupon);
    }

//    删除优惠卷
    @DeleteMapping("/{id}")
    public String deleteCoupon(@PathVariable("id") String id){
        return couponService.deleteCoupon(id);
    }

//    修改优惠卷
    @PutMapping
    public String updateCoupon(@RequestBody Coupon coupon){
        return couponService.updateCoupon(coupon);
    }

//    查询指定用户所拥有的优惠卷
    @GetMapping("/getUser/{userId}")
    public String getUserCoupon(@PathVariable("userId") String userId){
        return couponService.getUserCoupon(userId);
    }

//    查询指定优惠卷是否有用户拥有
    @GetMapping("/isZero/{couponId}")
    public String isZero(@PathVariable("couponId") String couponId){
        return couponService.isZero(couponId);
    }

//    查询指定优惠卷
    @GetMapping("/getOne/{id}")
    public String getOne(@PathVariable("id") String id){
        return couponService.getOne(id);
    }

//    查询指定商铺的所有优惠卷
    @GetMapping("/{shopId}")
    public String getCouponByShopId(@PathVariable("shopId") String shopId){
        return couponService.getCouponByShopId(shopId);
    }

    //    查询指定商品的优惠卷
    @GetMapping("/selGoodsCoupon/{userId}/{goodsId}")
    public String getSelGoodsCoupon(@PathVariable("userId") String userId,
                                 @PathVariable("goodsId") String goodsId){
        return couponService.getSelGoodsCoupon(userId,goodsId);
    }

//    查询指定商品的优惠卷
    @GetMapping("/goodsCoupon/{userId}/{goodsId}")
    public String getGoodsCoupon(@PathVariable("userId") String userId,
                                 @PathVariable("goodsId") String goodsId){
        return couponService.getGoodsCoupon(userId,goodsId);
    }

//    查询指定商铺中某个商品的优惠卷
    @GetMapping("/{shopId}/{goodsId}")
    public String getCouponOfGoodsCouponByShopId(@PathVariable("shopId") String shopId,
                                                 @PathVariable("goodsId") String goodsId) {
        return couponService.getCouponsByShopId(shopId,goodsId);
    }

    /*
    * 供其他服务调用
    * */

//    修改已领取的优惠卷
    @PutMapping("/putGet/{userId}/{couponId}")
    public String updateGetCoupon(@PathVariable("userId") String userId,
                               @PathVariable("couponId") String couponId){
        return couponService.updateGetCoupon(userId, couponId);
    }
}
