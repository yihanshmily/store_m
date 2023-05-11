package com.lry.store.controller;

import com.lry.store.domain.Goods;
import com.lry.store.dto.PageDto;
import com.lry.store.service.CallService;
import com.lry.store.service.GoodsService;
import com.lry.store.utils.R;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private CallService callService;

    /*
     * 新增
     * */

    //    新增商品
    @PostMapping
    public String addGoods(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
        return R.success("添加成功");
    }

    /*
     * 删除
     * */
//    删除商品（单、多）
    @DeleteMapping("/{ids}")
    public String deleteById(@PathVariable("ids") String ids) {
        return R.success(goodsService.deleteById(ids));
    }

    /*
     * 修改
     * */
//    修改商品信息
    @PutMapping()
    public String updateGoodsById(@RequestBody Goods goods) {
        return R.success(goodsService.updateGoodsById(goods));
    }

    /*
     * 查询
     * */

//    查询指定商铺的商品信息
    @GetMapping("/{shopId}")
    public String getGoodsByShopId(@PathVariable("shopId") String shopId) {
        return goodsService.getGoodsByShopId(shopId);
    }

//    根据商品名进行查询
    @GetMapping("/likeName/{searchName}")
    public String getGoodsLikeName(@PathVariable("searchName") String searchName){
        return goodsService.getGoodsLikeName(searchName);
    }

//    根据商品类别进行查询
    @GetMapping("/byCategory/{CategoryId}")
    public String getGoodsByCategory(@PathVariable("CategoryId") String CategoryId){
        return goodsService.getGoodsByCategory(CategoryId);
    }

    //    根据不同的排序，进行商品的查询
    @GetMapping("/userGet/{seral}/{currentPage}/{pageSize}")
    public String getGoodsBySeral(@PathVariable("seral") String seral,
                                  @PathVariable("currentPage") Integer currentPage,
                                  @PathVariable("pageSize") Integer pageSize) {
        return goodsService.getGoodsBySeral(seral, currentPage, pageSize);
    }

    //    查询单个商品
    @GetMapping("/getOne/{goodsId}/{userId}")
    public String getGoodsById(@PathVariable("goodsId") String goodsId,@PathVariable("userId") String userId) {
        return R.success(goodsService.getGoodsById(goodsId,userId));
    }

    //    根据类别查询某个商铺的所有商品
    @GetMapping("/mySelf/{shopId}/{categoryId}/{currentPage}/{pageSize}")
    public String getShopGoodsByIdOfMySelf(@PathVariable("shopId") String shopId,
                                           @PathVariable("categoryId") String categoryId,
                                           @PathVariable("currentPage") Integer currentPage,
                                           @PathVariable("pageSize") Integer pageSize) {
        return R.success(goodsService.getShopGoodsByIdOfMySelf(shopId, categoryId, currentPage, pageSize));
    }

    //    分页所有商品
    @GetMapping("/{currentPage}/{pageSize}")
    public String getAllGoods(@PathVariable("currentPage") Integer currentPage,
                              @PathVariable("pageSize") Integer pageSize) {
        return R.success(goodsService.getAllGoods(currentPage, pageSize));
    }

       /*
        其他服务调用
       * */

//    修改商品的销售额
    @PutMapping("/{goodsId}/{saleRoom}")
    public String updateGoodsSaleRoom(@PathVariable("goodsId") String goodsId,
                                      @PathVariable("saleRoom") Integer saleRoom) {
        return goodsService.updateGoodsSaleRoom(goodsId,saleRoom);
    }

    //    查询某个商铺的商品个数
    @GetMapping("/getShopGoodsCount/{shopId}")
    public int getShopGoodsCountByShopId(@PathVariable("shopId") String shopId) {
        return goodsService.getShopGoodsCountByShopId(shopId);
    }

    //    根据类别查询某个商铺的所有商品
    @GetMapping("/{shopId}/{categoryId}/{currentPage}/{pageSize}")
    public List<Goods> getShopGoodsById(@PathVariable("shopId") String shopId,
                                        @PathVariable("categoryId") String categoryId,
                                        @PathVariable("currentPage") Integer currentPage,
                                        @PathVariable("pageSize") Integer pageSize) {
        return goodsService.getShopGoodsById(shopId, categoryId, currentPage, pageSize);
    }
}
