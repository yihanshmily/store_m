package com.lry.store.dto;

import com.lry.store.domain.Repertory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepertoryDto extends Repertory {
    private String goodsName;
    private String goodsImg;
    private String goodsSaleRoom;
}
