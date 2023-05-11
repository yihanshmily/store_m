package com.lry.store.dto;

import com.lry.store.domain.WalletDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDetailDto extends WalletDetail {
    private Double allCount;
    private Double addCount;
    private Double desCount;
    private String goodsImg;
    private String shopName;
    private List<WalletDetailDto> walletDetailDtoList;
}
