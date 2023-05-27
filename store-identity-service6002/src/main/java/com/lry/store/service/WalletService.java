package com.lry.store.service;

public interface WalletService {
    String getWalletCount(String userId, String searchTime,String endTime);

    String getWalletOfUserId(String userId);

    String addWallet(String userId, Double money);

    String desWallet(String userId,String goodsId, Double money);

    String deleteWallet(String userId);

    String deleteWalletDetails(String ids);

    String createWalletOfUser(String userId);
}
