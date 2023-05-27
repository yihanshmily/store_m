package com.lry.store.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "store-identity-service")
public interface CallIdentityService {

    //    创建用户的钱包
    @PostMapping("/wallet/{userId}")
    public String createWalletOfUser(@PathVariable("userId") String userId);

    //    清空消费记录
    @DeleteMapping("/wallet/{userId}")
    public String deleteWallet(@PathVariable("userId") String userId);
}
