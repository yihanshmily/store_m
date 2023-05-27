package com.lry.store.service.impl;

import com.lry.store.domain.Wallet;
import com.lry.store.domain.WalletDetail;
import com.lry.store.dto.WalletDetailDto;
import com.lry.store.mapper.WalletMapper;
import com.lry.store.service.WalletService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Resource
    private WalletMapper walletMapper;

    @Override
    public String getWalletCount(String userId, String searchTime,String endTime) {
        searchTime = searchTime.substring(0,searchTime.length() - 3);
        endTime = endTime.substring(0,endTime.length() - 3);
//        查询收入与支出
        List<WalletDetailDto> walletCountList = walletMapper.getWalletCount(userId, searchTime, endTime);
        Double addCount = 0.00, desCount = 0.00;
        for (WalletDetail walletDetail : walletCountList) {
            if (walletDetail.getIsAdd()){
                addCount+=walletDetail.getMoney();
            }else {
                desCount += walletDetail.getMoney();
            }
        }
        WalletDetailDto walletDetailDto = new WalletDetailDto();
        walletDetailDto.setAddCount(addCount);
        walletDetailDto.setDesCount(desCount);
//        添加账单信息
        for (WalletDetailDto detailDto : walletCountList) {
            String[] split = detailDto.getGoodsImg().split(",");
            detailDto.setGoodsImg(split[0]);
        }
        walletDetailDto.setWalletDetailDtoList(walletCountList);
        return R.success(walletDetailDto);
    }

    @Override
    public String getWalletOfUserId(String userId) {
        return R.success(walletMapper.getWalletOfUserId(userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addWallet(String userId,Double money) {
        walletMapper.addWallet(userId, money);
        String goodsId = "1";
        WalletDetail walletDetail = returnWalletDetail(userId,goodsId, money);
        walletDetail.setIsAdd(true);
        walletDetail.setIsDec(false);
        Integer integer = walletMapper.createWallet(walletDetail);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String desWallet(String userId,String goodsId, Double money) {
        walletMapper.desWallet(userId, money);
        WalletDetail walletDetail = returnWalletDetail(userId, goodsId, money);
        walletDetail.setIsAdd(false);
        walletDetail.setIsDec(true);
        Integer integer = walletMapper.createWallet(walletDetail);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteWallet(String userId) {
        Integer integer = walletMapper.deleteWallet(userId);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteWalletDetails(String ids) {
        Integer integer = walletMapper.deleteWalletDetails(ids);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createWalletOfUser(String userId) {
        String id = SnowflakeIdWorker.getNextId();
        Integer integer = walletMapper.createWalletOfUser(id, userId);
        return R.returnString(integer);
    }

    private WalletDetail returnWalletDetail(String userId,String goodsId, Double money) {
        String walletId = SnowflakeIdWorker.getNextId();
        WalletDetail walletDetail = new WalletDetail();
        walletDetail.setId(walletId);
        walletDetail.setUserId(userId);
        walletDetail.setMoney(money);
        walletDetail.setGoodsId(goodsId);
        return walletDetail;
    }

}
