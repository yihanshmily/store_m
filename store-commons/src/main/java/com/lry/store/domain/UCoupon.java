package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UCoupon {
    private String id;
    private String userId;
    private String couponId;
    private Boolean isUser;
}
