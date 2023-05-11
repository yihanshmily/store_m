package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements Serializable {
    private String id;
    private String userId;
    private String tel;
    private String img;
    private Boolean isStatus;
    private Date createTime;
    private Date updateTime;
}
