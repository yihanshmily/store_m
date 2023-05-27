package com.lry.store.service.impl;

import com.lry.store.domain.Shoping;
import com.lry.store.dto.ShopingDto;
import com.lry.store.mapper.ShopingMapper;
import com.lry.store.service.ShopingService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopingServiceImpl implements ShopingService {

    @Resource
    private ShopingMapper shopingMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createShoping(Shoping shoping) {
        shoping.setId(SnowflakeIdWorker.getNextId());
        Integer integer = shopingMapper.createShoping(shoping);
        return R.returnString(integer);
    }

    @Override
    public String getShopingByUserId(String userId) {
        List<ShopingDto> shopingDtoList = shopingMapper.getShopingByUserId(userId);
        for (ShopingDto shopingDto : shopingDtoList) {
            String[] split = shopingDto.getGoodsImg().split(",");
            shopingDto.setGoodsImg(split[0]);
        }
        return R.success(shopingDtoList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteShoping(String id) {
        Integer integer = shopingMapper.deleteShoping(id);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteGoodsOfShoping(String ids) {
        Integer integer = shopingMapper.deleteGoodsOfShoping(ids);
        return R.returnString(integer);
    }
}
