package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String id;
    private String userId;
    private String name;
    private String tel;
    private String addressInfo;
    private Boolean isDefault;
    private Date createTime;
    private Date updateTime;
}
