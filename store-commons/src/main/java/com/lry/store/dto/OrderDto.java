package com.lry.store.dto;

import com.lry.store.domain.Address;
import com.lry.store.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto extends Order {
    private String userName;
    private String userSole;
    private String userImg;
    private String goodsName;
    private String goodsImg;
    private String goodsPrice;
    private String goodsCategory;
    private String goodsSaleRoom;
    private String goodsDescription;
    private String categoryName;
    private String shopId;
    private String shopName;
    private String addressName;
    private String addressTel;
    private String addressInfo;
    private Integer couponMeetMoney;
    private Integer couponCutMoney;
    private Integer commentScore;
}
