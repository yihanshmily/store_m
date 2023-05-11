package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    private String id;
    private String userId;
    private Double wallet;
    private Date createTime;
    private Date updateTime;

    public Wallet(String id, String userId, Double wallet) {
        this.id = id;
        this.userId = userId;
        this.wallet = wallet;
    }
}
