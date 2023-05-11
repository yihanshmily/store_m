package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shoping {
    private String id;
    private String userId;
    private String goodsId;
    private Integer number;
    private String text;
    private Date createTime;
    private Date updateTime;
}
