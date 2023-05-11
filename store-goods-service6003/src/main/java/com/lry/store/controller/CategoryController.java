package com.lry.store.controller;

import com.lry.store.domain.Goods;
import com.lry.store.service.CategoryService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/goods/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

//    根据商品类别获取商品
    @GetMapping("/{categoryId}/{goodsId}")
    public String getCategoryOfGoodsById(@PathVariable("categoryId") String categoryId,
                                         @PathVariable("goodsId") String goodsId){
        return categoryService.getCategoryByCategoryId(categoryId,goodsId);
    }

    @GetMapping
    public String getCategory(){
        return R.success(categoryService.getCategory());
    }


}
