package com.lry.store.service;

import com.lry.store.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategory();

    String getCategoryByCategoryId(String categoryId,String goodsId);
}
