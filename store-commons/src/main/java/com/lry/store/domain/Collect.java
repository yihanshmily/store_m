package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
    private String id;
    private String userId;
    private String goodsId;
    private String shopId;
    private Date createTime;
    private Date updateTime;

    public Collect(String id, String userId, String goodsId, String shopId) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.shopId = shopId;
    }
}
