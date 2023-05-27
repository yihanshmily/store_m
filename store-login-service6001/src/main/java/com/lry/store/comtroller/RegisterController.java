package com.lry.store.comtroller;

import com.lry.store.domain.User;
import com.lry.store.service.RegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private RegisterService registerService;

//    用户注册
    @PostMapping("/user")
    public String registerUser(@RequestBody User user){
        return registerService.registerUser(user);
    }
}
