package com.lry.store.controller;

import com.lry.store.domain.Shop;
import com.lry.store.service.ManagerService;
import com.lry.store.service.ShopService;
import com.lry.store.service.UserService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/identity")
public class ShopController {

    @Resource
    private ShopService shopService;

//    修改密码
    @PutMapping("/updatePwd/{id}/{oldPwd}/{newPwd}")
    public String updatePwd(@PathVariable("id") String id,@PathVariable("oldPwd") String oldPwd,
                            @PathVariable("newPwd") String newPwd){
        Integer integer = shopService.updatePwd(id, oldPwd, newPwd);
        if (integer>=1){
            return R.success("成功");
        }else {
            return R.error("失败");
        }
    }

//    修改资料
    @PutMapping("/updateShop")
    public String updateShop(@RequestBody Shop shop) {
        Integer integer = shopService.updateShop(shop);
        if (integer>=1){
            return R.success("修改成功");
        }else {
            return R.error("失败");
        }
    }

    //    根据昵称获取信息
    @GetMapping("/getInfo/{id}/{name}")
    public String getShopInfoByName(@PathVariable("name") String name,@PathVariable("id") String id) {
        Shop shop = shopService.getShopInfoByName(name, id);
        if (shop==null){
            return R.success("ok");
        }else {
            return R.error("失败");
        }
    }

//    注册商铺
    @PostMapping("/register/shop")
    public String createShop(@RequestBody Shop shop) {
        Integer integer = shopService.createShop(shop);
        if (integer>=2){
            return R.success("注册成功");
        }else {
            return R.error("注册失败");
        }
    }

//    获取某商铺的商品信息
    @GetMapping("/getShopAll/{id}/{categoryId}/{currentPage}/{pageSize}")
    public String getGoodsOfShopId(@PathVariable("id") String id,
                                   @PathVariable("categoryId") String categoryId,
                                   @PathVariable("currentPage") Integer currentPage,
                                   @PathVariable("pageSize") Integer pageSize) {
        return R.success(shopService.getGoodsOfShopId(id,categoryId,currentPage,pageSize));
    }

}
