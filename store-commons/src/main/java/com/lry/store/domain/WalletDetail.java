package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDetail extends Wallet{
    private String goodsId;
    private Double money;
    private Boolean isAdd;
    private Boolean isDec;
}
