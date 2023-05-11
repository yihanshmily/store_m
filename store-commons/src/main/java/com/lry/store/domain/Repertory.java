package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repertory {
    private String id;
    private String goodsId;
    private String shopId;
    private Integer number;
    private Integer sumTotal;
    private String address;
    private Date lateAddTime;
    private Date createTime;
    private Date updateTime;
}
