package com.lry.store.mapper;

import com.lry.store.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface GoodsMapper {
    void addGoods(Goods goods);

    List<Goods> getAllGoods(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);



    Goods getGoodsById(@Param("id") String id);

//    根据名字查询id
    List<String> getGoodsIdByName(@Param("name") String name,@Param("shopId") String shopId);

    List<Goods> getShopGoodsById(@Param("shopId") String shopId, @Param("currentPage") Integer currentPage,
                                 @Param("pageSize") Integer pageSize);

    Integer getShopGoodsCountByShopId(@Param("shopId") String shopId);

    List<Goods> getShopGoodsByIdAndCategoryId(@Param("shopId") String shopId,
                                              @Param("categoryId") String categoryId,
                                              @Param("currentPage") Integer currentPage,
                                              @Param("pageSize") Integer pageSize);

    Integer deleteById(@Param("ids") String ids);

    Integer updateGoods(Goods goods);

    List<Goods> getGoodsBySeral(@Param("seral") String seral,
                                @Param("currentPage") Integer currentPage,
                                @Param("pageSize") Integer pageSize);

    List<Goods> getGoodsCommentBySeral(@Param("seral") String seral,
                               @Param("currentPage") Integer currentPage,
                               @Param("pageSize") Integer pageSize);

    List<Goods> getGoodsCollectBySeral(@Param("seral") String seral,
                                @Param("currentPage") Integer currentPage,
                                @Param("pageSize") Integer pageSize);

    Integer getCountGoods();

    List<Goods> getGoodsByCategory(@Param("categoryId") String categoryId);

    List<Goods> getGoodsLikeName(@Param("searchName") String searchName);

    List<Goods> getGoodsByShopId(@Param("shopId") String shopId);

    Integer updateGoodsSaleRoom(@Param("goodsId") String goodsId, @Param("saleRoom") Integer saleRoom);

    Integer delGoodsOfCoupon(@Param("ids") String ids);

    Integer delCouponOfGoods(@Param("ids") String ids);
}
