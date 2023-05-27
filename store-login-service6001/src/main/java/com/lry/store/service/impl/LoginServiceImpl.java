package com.lry.store.service.impl;

import com.lry.store.domain.Manager;
import com.lry.store.domain.Shop;
import com.lry.store.domain.User;
import com.lry.store.mapper.ManagerLoginMapper;
import com.lry.store.mapper.ShopLoginMapper;
import com.lry.store.mapper.UserLoginMapper;
import com.lry.store.service.CallIdentityService;
import com.lry.store.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserLoginMapper userLoginMapper;

    @Resource
    private ManagerLoginMapper managerLoginMapper;

    @Resource
    private ShopLoginMapper shopLoginMapper;

    @Resource
    private CallIdentityService callIdentityService;

    @Override
    public User userLogin(String name, String pwd) {
        User user = userLoginMapper.userLogin(name, pwd);
//        清空指定用户的消费记录
//        callIdentityService.deleteWallet(user.getId());
        return user;
    }

    @Override
    public Manager managerLogin(Manager manager) {
        return managerLoginMapper.managerLogin(manager);
    }

    @Override
    public Shop shopLogin(Shop shop) {
        return shopLoginMapper.shopLogin(shop);
    }
}
