package com.lry.store.dto;

import com.lry.store.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {
    private Integer totalPages;
    private Integer numbers;
    private Double gainMoney;
    private List dataList;
}
