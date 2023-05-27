package com.lry.store.service.impl;

import com.lry.store.dto.FootDto;
import com.lry.store.mapper.FootMapper;
import com.lry.store.service.FootService;
import com.lry.store.utils.R;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class FootServiceImpl implements FootService {

    @Resource
    private FootMapper footMapper;

    @Override
    public String getFootByUserId(String userId) {
        Set<FootDto> footDtoSet = footMapper.getFootByUserId(userId);
        for (FootDto footDto : footDtoSet) {
            String[] split = footDto.getGoodsImg().split(",");
            footDto.setGoodsImg(split[0]);
        }
        return R.success(footDtoSet);
    }

    //    根据商品删除足迹
    @Transactional(rollbackFor = Exception.class)
    public String delGoodsOfFoot(String ids) {
        Integer integer = footMapper.delGoodsOfFoot(ids);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delFootByUserId(String userId) {
        footMapper.deleteFootByUserId(userId);
        return R.success("成功");
    }
}
