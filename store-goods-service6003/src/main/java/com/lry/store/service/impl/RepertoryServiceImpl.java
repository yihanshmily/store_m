package com.lry.store.service.impl;

import com.lry.store.dto.PageDto;
import com.lry.store.dto.RepertoryDto;
import com.lry.store.mapper.GoodsMapper;
import com.lry.store.mapper.RepertoryMapper;
import com.lry.store.service.RepertoryService;
import com.lry.store.utils.R;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepertoryServiceImpl implements RepertoryService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private RepertoryMapper repertoryMapper;

    @Override
//    @GlobalTransactional(name = "repertory_getByShopId",rollbackFor = Exception.class)
    public PageDto getRepertory(String shopId,String searchName, Integer currentPage, Integer pageSize) {
        PageDto pageDto = new PageDto();
        if (searchName.equals("all")){
            searchName = "%";
        }
        List<String> goodsIds = goodsMapper.getGoodsIdByName(searchName,shopId);
        List<RepertoryDto> repertoryList =null;
        Integer number = 0;
        if (goodsIds.size() != 0){
            String ids = "";
            for (int j = 0; j < goodsIds.size(); j++) {
                ids+=goodsIds.get(j);
                if(j!= goodsIds.size()-1){
                    ids+=",";
                }
            }
            repertoryList = repertoryMapper.getRepertory(shopId, ids,
                    (currentPage - 1) * pageSize, pageSize);
            for (RepertoryDto repertoryDto : repertoryList) {
                String[] img = repertoryDto.getGoodsImg().split(",");
                repertoryDto.setGoodsImg(img[0]);
            }
            number = repertoryList.size();
        }
        pageDto.setNumbers(number);
        pageDto.setTotalPages(number/pageSize);
        pageDto.setDataList(repertoryList);
        return pageDto;
    }

    @Override
    public RepertoryDto getRepertoryId(String id) {
        RepertoryDto repertoryDto = repertoryMapper.getRepertoryId(id);
        String[] split = repertoryDto.getGoodsImg().split(",");
        repertoryDto.setGoodsImg(split[0]);
        return repertoryDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addRepertorySum(String shopId, String id, Integer addSum) {
        Integer integer = repertoryMapper.addRepertorySum(shopId, id, addSum);
       return returnString(integer);
    }

    @Override
    public String getGoodsRep(String goodId) {
        Integer integer = repertoryMapper.getGoodsRep(goodId);
        return R.success(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String desRepertory(String goodsId, Integer number) {
        Integer integer = repertoryMapper.desRepertory(goodsId, number);
        return R.returnString(integer);
    }

    //    返回语句
    private String returnString(Integer integer) {
        if (integer>=1){
            return R.success("成功");
        }else {
            return R.error("失败");
        }
    }
}
