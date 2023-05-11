package com.lry.store.dto;

import com.lry.store.domain.Coupon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto extends Coupon {
    private String goodsName;
    private String goodsImg;
    private Integer userSums;
    private String userId;
}
