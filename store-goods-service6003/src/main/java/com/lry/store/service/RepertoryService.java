package com.lry.store.service;

import com.lry.store.dto.PageDto;
import com.lry.store.dto.RepertoryDto;

import java.util.List;

public interface RepertoryService {
    PageDto getRepertory(String shopId,String searchName, Integer currentPage, Integer pageSize);

    RepertoryDto getRepertoryId(String id);

    String addRepertorySum(String shopId, String id, Integer addSum);

    String getGoodsRep(String goodId);

    String desRepertory(String goodsId, Integer number);
}
