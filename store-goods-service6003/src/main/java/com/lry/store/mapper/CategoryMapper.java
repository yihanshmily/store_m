package com.lry.store.mapper;

import com.lry.store.domain.Category;
import com.lry.store.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> getCategory();

    List<Goods> getCategoryByCategoryId(@Param("categoryId") String categoryId,
                                        @Param("goodsId") String goodsId);
}
