package com.lry.store.dto;

import com.lry.store.domain.Foot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootDto extends Foot {
    private String goodsName;
    private Double goodsPrice;
    private String goodsImg;
}
