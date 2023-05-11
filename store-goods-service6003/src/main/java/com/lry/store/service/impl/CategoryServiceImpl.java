package com.lry.store.service.impl;

import com.lry.store.domain.Category;
import com.lry.store.domain.Goods;
import com.lry.store.mapper.CategoryMapper;
import com.lry.store.service.CategoryService;
import com.lry.store.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategory() {
        return categoryMapper.getCategory();
    }

    @Override
    public String getCategoryByCategoryId(String categoryId,String goodsId) {
        List<Goods> goodsList = categoryMapper.getCategoryByCategoryId(categoryId,goodsId);
        for (Goods goods : goodsList) {
            String[] split = goods.getImg().split(",");
            goods.setImg(split[0]);
        }
        return R.success(goodsList);
    }
}
