package com.lry.store.service.impl;

import com.lry.store.domain.Address;
import com.lry.store.mapper.AddressMapper;
import com.lry.store.service.AddressService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public String getAddressOfUserId(String userId) {
        return R.success(addressMapper.getAddressOfUserId(userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createAddress(Address address, String userId) {
        if (address.getIsDefault()){
            addressMapper.cloDefault(userId);
        }
        address.setId(SnowflakeIdWorker.getNextId());
        Integer integer = addressMapper.createAddress(address);
        return R.returnString(integer);
    }

    @Override
    public String getOne(String id) {
        return R.success(addressMapper.getOne(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateAddress(Address address, String userId) {
        if (address.getIsDefault()){
            addressMapper.cloDefault(userId);
        }
        Integer integer = addressMapper.updateAddress(address);
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteAddress(String id) {
        Integer integer = addressMapper.deleteAddress(id);
        return R.returnString(integer);
    }
}
