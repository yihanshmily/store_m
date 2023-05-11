package com.lry.store.mapper;

import com.lry.store.domain.Repertory;
import com.lry.store.dto.RepertoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RepertoryMapper {
    Integer addRepertory(Repertory repertory);

    List<RepertoryDto> getRepertory(@Param("shopId") String shopId, @Param("ids") String ids,
                                    @Param("currentPage") Integer currentPage,
                                    @Param("pageSize") Integer pageSize);

    void deleteById(@Param("ids") String ids);

    RepertoryDto getRepertoryId(@Param("id") String id);

    Integer addRepertorySum(@Param("shopId") String shopId,@Param("id") String id,
                         @Param("addSum") Integer addSum);

    Integer getGoodsRep(@Param("goodsId") String goodId);

    Integer desRepertory(@Param("goodsId") String goodsId, @Param("number") Integer number);
}
