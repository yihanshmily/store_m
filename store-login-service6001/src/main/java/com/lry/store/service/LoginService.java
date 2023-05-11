package com.lry.store.service;

import com.lry.store.domain.Manager;
import com.lry.store.domain.Shop;
import com.lry.store.domain.User;

public interface LoginService {
    User userLogin(String name, String pwd);

    Manager managerLogin(Manager manager);

    Shop shopLogin(Shop shop);
}
