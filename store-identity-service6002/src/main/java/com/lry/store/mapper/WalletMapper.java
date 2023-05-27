package com.lry.store.mapper;

import com.lry.store.domain.Wallet;
import com.lry.store.domain.WalletDetail;
import com.lry.store.dto.WalletDetailDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WalletMapper {
    Integer createWallet(WalletDetail walletDetail);

    List<WalletDetailDto> getWalletCount(@Param("userId") String userId, @Param("searchTIme") String searchTime,
                        @Param("endTime") String endTime);

    WalletDetailDto getWalletOfUserId(@Param("userId") String userId);

    Integer addWallet(@Param("userId") String userId, @Param("money") Double money);

    Integer desWallet(@Param("userId") String userId, @Param("money") Double money);

    Integer deleteWallet(@Param("userId") String userId);

    Integer deleteWalletDetails(@Param("ids") String ids);

    Integer createWalletOfUser(@Param("id") String id, @Param("userId") String userId);
}
