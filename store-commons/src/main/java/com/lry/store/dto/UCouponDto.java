package com.lry.store.dto;

import com.lry.store.domain.UCoupon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UCouponDto extends UCoupon {
    private String goodsId;
    private Integer userSums;
}
