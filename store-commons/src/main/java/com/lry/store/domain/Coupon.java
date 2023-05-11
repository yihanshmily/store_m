package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    private String id;
    private String goodsId;
    private String shopId;
    private Integer meetMoney;
    private Integer cutMoney;
    private Date createTime;
}
