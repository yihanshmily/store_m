package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foot {
    private String id;
    private String userId;
    private String goodsId;
    private Date createTime;
    private Date updateTime;
}
