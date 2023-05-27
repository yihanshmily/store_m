package com.lry.store.service.impl;

import com.lry.store.domain.Coupon;
import com.lry.store.domain.UCoupon;
import com.lry.store.dto.CouponDto;
import com.lry.store.dto.UCouponDto;
import com.lry.store.mapper.CouponMapper;
import com.lry.store.service.CouponService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public String getCouponsByShopId(String shopId, String goodsId) {
        return R.success(couponMapper.getCouponsByShopId(shopId, goodsId));
    }

    @Override
    public String getCouponByShopId(String shopId) {
        List<CouponDto> couponDtoList = couponMapper.getCouponByShopId(shopId);
        List<UCouponDto> uCouponDtoList = couponMapper.getCouponCount(shopId);
        for (CouponDto couponDto : couponDtoList) {
            String[] split = couponDto.getGoodsImg().split(",");
            couponDto.setGoodsImg(split[0]);
            int sum = 0;
            couponDto.setUserSums(sum);
            for (UCouponDto uCouponDto : uCouponDtoList) {
                if (couponDto.getId().equals(uCouponDto.getCouponId())){
                    if (uCouponDto.getUserId() != null){
                        couponDto.setUserSums(++sum);
                    }
                }
            }
        }
        return R.success(couponDtoList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createCoupon(Coupon coupon) {
        coupon.setId(SnowflakeIdWorker.getNextId());
        Integer integer = couponMapper.createCoupon(coupon);
        return returnString(integer);
    }

    @Override
    public String getOne(String id) {
        return R.success(couponMapper.getOne(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized String updateCoupon(Coupon coupon) {
        Integer integer = couponMapper.updateCoupon(coupon);
        return returnString(integer);
    }

    @Override
    public String isZero(String couponId) {
        Integer integer = couponMapper.isZero(couponId);
        if (integer==0){
            return R.success("空");
        }else {
            return R.error("非空");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteCoupon(String id) {
        Integer integer = couponMapper.deleteCoupon(id);
        return returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String userAddCoupon(UCoupon ucoupon) {
        ucoupon.setId(SnowflakeIdWorker.getNextId());
        Integer integer = couponMapper.addCoupon(ucoupon);
        return returnString(integer);
    }

    @Override
    public synchronized String getUserCoupon(String userId) {
        List<CouponDto> couponDtoList = couponMapper.getUserCoupon(userId);
        for (CouponDto couponDto : couponDtoList) {
            String[] split = couponDto.getGoodsImg().split(",");
            couponDto.setGoodsImg(split[0]);
        }
        return R.success(couponDtoList);
    }

    @Override
    public String getGoodsCoupon(String userId,String goodsId) {
        return R.success(couponMapper.getGoodsCoupon(userId,goodsId));
    }

    @Override
    public String getSelGoodsCoupon(String userId, String goodsId) {
        return R.success(couponMapper.getSelGoodsCoupon(userId,goodsId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateGetCoupon(String userId, String couponId) {
        Integer integer = couponMapper.updateGetCoupon(userId, couponId);
        return R.returnString(integer);
    }

    //    返回语句
    private String returnString(Integer integer) {
        if (integer>=1){
            return R.success("成功");
        }else {
            return R.error("失败");
        }
    }
}
