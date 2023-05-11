package com.lry.store.controller;

import com.lry.store.mapper.CollectMapper;
import com.lry.store.service.CollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/collect")
public class CollectController {

    @Resource
    private CollectService collectService;

//    删除所有收藏的商品
    @DeleteMapping("/{userId}")
    public String delAllCollect(@PathVariable("userId") String userId){
        return collectService.delAllCollect(userId);
    }

    //    修改是否收藏指定商品
    @PutMapping("/{userId}/{goodsId}/{shopId}/{isCollect}")
    public String updateCollectOfUserGoods(@PathVariable("userId") String userId,
                                           @PathVariable("goodsId") String goodsId,
                                           @PathVariable("shopId") String shopId,
                                           @PathVariable("isCollect") Boolean isCollect){
        return collectService.updateCollectOfUserGoods(userId, goodsId,shopId,isCollect);
    }

//    获取指定用户收藏商品的个数
    @GetMapping("/getCount/{userId}")
    public String getCount(@PathVariable("userId") String userId){
        return collectService.getCount(userId);
    }

//    获取指定用户所收藏的所有商品
    @GetMapping("/getGoodsAll/{userId}")
    public String getGoodsAllOfUserId(@PathVariable("userId") String userId){
        return collectService.getGoodsAllOfUserId(userId);
    }

//    查询某用户是否收藏某商品
    @GetMapping("/isCollect/{userId}/{goodsId}")
    public String isCollect(@PathVariable("userId") String userId,
                            @PathVariable("goodsId") String goodsId){
        return collectService.isCollect(userId, goodsId);
    }

//    根据shopId获取指定商铺所关注的用户
    @GetMapping("/getUser/{shopId}/{currentPage}/{pageSize}")
    public String getUserByShopId(@PathVariable("shopId") String shopId,
                                  @PathVariable("currentPage") Integer currentPage,
                                  @PathVariable("pageSize") Integer pageSize) {
        return collectService.getUserByShopId(shopId,currentPage,pageSize);
    }

    /*
    * 供其他服务调用
    * */

//    删除指定商品的收藏
    @DeleteMapping("/ofGoods/{ids}")
    public String delGoodsByIds(@PathVariable("ids") String ids){
        return collectService.delGoodsByIds(ids);
    }
}
