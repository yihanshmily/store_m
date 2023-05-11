package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String id;
    private String shopId;
    private String categoryId;
    private String name;
    private String img;
    private Double price;
    private Integer saleRoom;
    private String description;
    private Boolean isStatus;
    private Date createTime;
    private Date updateTime;
}
