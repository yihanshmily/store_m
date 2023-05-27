package com.lry.store.service.impl;

import com.lry.store.domain.User;
import com.lry.store.domain.UserDetail;
import com.lry.store.mapper.RegisterMapper;
import com.lry.store.service.CallIdentityService;
import com.lry.store.service.RegisterService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private RegisterMapper registerMapper;

    @Resource
    private CallIdentityService callIdentityService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String registerUser(User user) {
        String id = SnowflakeIdWorker.getNextId();
        user.setId(id);
        user.setSole(id.substring(12, 18));
//        创建用户
        Integer integer = registerMapper.registerUser(user);
        if(integer != 0){
            UserDetail userDetail = new UserDetail();
            userDetail.setId(SnowflakeIdWorker.getNextId());
            userDetail.setUserId(user.getId());
//            创建用户详情
            registerMapper.registerUserDetail(userDetail);
//            创建用户的钱包
            callIdentityService.createWalletOfUser(id);
        }
        return R.success("成功");
    }
}
