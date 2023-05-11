package com.lry.store.controller;

import com.lry.store.service.RepertoryService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/repertory")
public class RepertoryController {

    @Resource
    private RepertoryService repertoryService;

//    添加库存
    @PutMapping("/{id}/{shopId}/{addSum}")
    public String addRepertorySum(@PathVariable("id") String id,
                                  @PathVariable("shopId") String shopId,
                                  @PathVariable("addSum") Integer addSum){
        return repertoryService.addRepertorySum(shopId, id,addSum);
    }

//    获取指定商品的库存数量
    @GetMapping("/goodsRep/{goodsId}")
    public String getGoodsRep(@PathVariable("goodsId") String goodId){
        return repertoryService.getGoodsRep(goodId);
    }

//    根据id获取所有信息
    @GetMapping("/{id}")
    public String getRepertoryId(@PathVariable("id") String id){
        return R.success(repertoryService.getRepertoryId(id));
    }

//    分页获取所有库存信息
    @GetMapping("/{shopId}/{searchName}/{currentPage}/{pageSize}")
    public String getRepertory(@PathVariable("shopId") String shopId,
                               @PathVariable("searchName") String searchName,
                               @PathVariable("currentPage") Integer currentPage,
                               @PathVariable("pageSize") Integer pageSize) {
        return R.success(repertoryService.getRepertory(shopId,searchName, currentPage, pageSize));
    }

    /*
    * 供其他服务调用
    * */

//    减少库存
    @PutMapping("/{goodsId}/{number}")
    public String desRepertory(@PathVariable("goodsId") String goodsId, @PathVariable("number") Integer number){
        return repertoryService.desRepertory(goodsId, number);
    }
}
