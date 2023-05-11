package com.lry.store.mapper;

import com.lry.store.domain.Collect;
import com.lry.store.domain.Goods;
import com.lry.store.dto.CollectDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectMapper {


    List<CollectDto> getUserByShopId(@Param("shopId") String shopId,
                                     @Param("currentPage") Integer currentPage,
                                     @Param("pageSize") Integer pageSize);

    void createCollect(Collect collect);

    void delCollect(Collect collect);

    Integer isCollect(@Param("userId") String userId, @Param("goodsId") String goodsId);

    List<Goods> getAllGoodsOfUserId(@Param("userId") String userId);

    Integer getCount(@Param("userId") String userId);

    Integer delAllCollect(@Param("userId") String userId);

    Integer delGoodsByIds(@Param("ids") String ids);
}
