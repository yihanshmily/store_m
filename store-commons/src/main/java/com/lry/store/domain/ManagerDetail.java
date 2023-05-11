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
public class ManagerDetail implements Serializable {
    private String id;
    private String managerId;
    private String tel;
    private String img;
    private Boolean isSpecil;
    private Date createTime;
    private Date updateTime;
}
