package com.lry.store.service.impl;

import com.lry.store.domain.Collect;
import com.lry.store.domain.Goods;
import com.lry.store.dto.CollectDto;
import com.lry.store.dto.PageDto;
import com.lry.store.mapper.CollectMapper;
import com.lry.store.service.CollectService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Resource
    private CollectMapper collectMapper;

    @Override
//    @GlobalTransactional(name = "collect_getByShopId",rollbackFor = Exception.class)
    public String getUserByShopId(String shopId,Integer currentPage,Integer pageSize) {
        PageDto pageDto = new PageDto();
        List<CollectDto> collectDtoList =
                collectMapper.getUserByShopId(shopId, (currentPage-1)*pageSize, pageSize);
        for (CollectDto collectDto : collectDtoList) {
            String[] split = collectDto.getUserImg().split(",");
            collectDto.setUserImg(split[0]);
        }
        int number = collectDtoList.size();
        pageDto.setNumbers(number);
        pageDto.setTotalPages(number/pageSize);
        pageDto.setDataList(collectDtoList);
        return R.success(pageDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateCollectOfUserGoods(String userId, String goodsId,String shopId, Boolean isCollect) {
        Collect collect = new Collect(SnowflakeIdWorker.getNextId(),userId,goodsId,shopId);
        if (isCollect){
            collectMapper.createCollect(collect);
        }else {
            collectMapper.delCollect(collect);
        }
        return R.success("成功");
    }

    @Override
    public String isCollect(String userId, String goodsId) {
        Integer sum = collectMapper.isCollect(userId, goodsId);
        if (sum>=1){
            return R.success(true);
        }else {
            return R.success(false);
        }
    }

    @Override
    public String getGoodsAllOfUserId(String userId) {
        List<Goods> goodsList = collectMapper.getAllGoodsOfUserId(userId);
        for (Goods goods : goodsList) {
            String[] split = goods.getImg().split(",");
            goods.setImg(split[0]);
        }
        return R.success(goodsList);
    }

    @Override
    public String getCount(String userId) {
        return R.success(collectMapper.getCount(userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delAllCollect(String userId) {
        Integer integer = collectMapper.delAllCollect(userId);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delGoodsByIds(String ids) {
        Integer integer = collectMapper.delGoodsByIds(ids);
        return R.returnString(integer);
    }
}
