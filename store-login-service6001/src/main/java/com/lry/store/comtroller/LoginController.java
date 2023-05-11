package com.lry.store.comtroller;

import com.lry.store.domain.Manager;
import com.lry.store.domain.Shop;
import com.lry.store.domain.User;
import com.lry.store.service.LoginService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

//    商铺人员登录
    @PostMapping("/shop")
    public String shopLogin(@RequestBody Shop shop){
        Shop shopLogin = loginService.shopLogin(shop);
        if (shopLogin == null){
            return R.error("空");
        }else if(shopLogin != null && shopLogin.getIsStatus()) {
            return R.success(shopLogin);
        }else {
            return R.error("账号被冻结");
        }
    }

//    用户登录
    @PostMapping("/user")
    public String userLogin(@RequestBody User user){
        User userLogin = loginService.userLogin(user.getName(),user.getPwd());
        if (userLogin != null && userLogin.getIsStatus()){
            return R.success(userLogin);
        }else if (userLogin == null){
            return R.error("空");
        }else {
            return R.error("账号被冻结");
        }
    }

//    管理员登录
    @PostMapping("/manager")
    public String managerLogin(@RequestBody Manager manager){
        Manager managerLogin = loginService.managerLogin(manager);
        if (managerLogin != null){
            return R.success(managerLogin);
        }else {
            return R.error("登录失败");
        }
    }
}
