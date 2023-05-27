package com.lry.store.controller;

import com.lry.store.service.WalletService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/wallet")
public class WalletController {

    @Resource
    private WalletService walletService;

    /*
    * 修改
    * */

//    账号充值
    @PutMapping("/{userId}/{money}")
    public String addWallet(@PathVariable("userId") String userId, @PathVariable("money") Double money){
        return walletService.addWallet(userId, money);
    }

    /*
    * 查询
    * */

//    查询指定账户的钱包
    @GetMapping("/{userId}")
    public String getWalletOfUserId(@PathVariable("userId") String userId){
        return walletService.getWalletOfUserId(userId);
    }

//    查看账号一段时间的账单结果
    @GetMapping("/{userId}/{searchTime}/{endTime}")
    public String getWalletCount(@PathVariable("userId") String userId,
                                 @PathVariable("searchTime") String searchTime,
                                 @PathVariable("endTime") String endTime){
        return walletService.getWalletCount(userId, searchTime,endTime);
    }

    /*
    * 供其他服务调用
    * */

    //    创建用户的钱包
    @PostMapping("/{userId}")
    public String createWalletOfUser(@PathVariable("userId") String userId){
        return walletService.createWalletOfUser(userId);
    }

//    根据商品删除消费记录
    @DeleteMapping("/goodsOfWallet/{ids}")
    public String deleteWalletDetails(@PathVariable("ids") String ids){
        return walletService.deleteWalletDetails(ids);
    }

//    清空消费记录
    @DeleteMapping("/{userId}")
    public String deleteWallet(@PathVariable("userId") String userId){
        return walletService.deleteWallet(userId);
    }

    //    下单消费
    @PutMapping("/orderIng/{userId}/{goodsId}/{money}")
    public String desWallet(@PathVariable("userId") String userId,@PathVariable("goodsId") String goodsId,
                            @PathVariable("money") Double money){
        return walletService.desWallet(userId,goodsId, money);
    }
}
