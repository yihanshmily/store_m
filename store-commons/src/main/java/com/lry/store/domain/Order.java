package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String sole;
    private String goodsId;
    private String shopId;
    private String userId;
    private String addressId;
    private String couponId;
    private String commentId;
    private Integer number;
    private Double totalPrice;
    private Boolean isUser;
    private Boolean isShop;
    private String status;
    private String payWay;
    private String text;
    private Date createTime;
    private Date updateTime;
}
