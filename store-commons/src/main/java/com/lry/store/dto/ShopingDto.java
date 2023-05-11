package com.lry.store.dto;

import com.lry.store.domain.Shoping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopingDto extends Shoping {
    private String goodsImg;
    private String goodsName;
    private Double goodsPrice;
    private String goodsDescription;
}
