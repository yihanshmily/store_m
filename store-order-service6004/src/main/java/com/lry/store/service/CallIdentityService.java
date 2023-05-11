package com.lry.store.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(value = "store-identity-service")
public interface CallIdentityService {

    //    下单消费
    @PutMapping("/wallet/orderIng/{userId}/{goodsId}/{money}")
    public String desWallet(@PathVariable("userId") String userId,@PathVariable("goodsId") String goodsId,
                            @PathVariable("money") Double money);
}
