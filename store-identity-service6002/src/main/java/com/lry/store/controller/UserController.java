package com.lry.store.controller;

import com.lry.store.domain.User;
import com.lry.store.domain.UserDetail;
import com.lry.store.service.UserService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/identity/user")
public class UserController {

    @Resource
    private UserService userService;

    //    修改密码
    @PutMapping("/updatePwd/{id}/{oldPwd}/{newPwd}")
    public String updatePwd(@PathVariable("id") String id,@PathVariable("oldPwd") String oldPwd,
                            @PathVariable("newPwd") String newPwd){
        return userService.updatePwd(id, oldPwd, newPwd);
    }

//    修改用户信息
    @PutMapping
    public String updateInfo(@RequestBody User user){
        return userService.updateInfo(user);
    }

//    根据用户名查询此用户是否存在
    @GetMapping("/isNull/{userName}")
    public String userIsNull(@PathVariable("userName") String userName){
        return userService.userIsNull(userName);
    }

//    根据userId获取用户信息
    @GetMapping("/{userId}")
    public String getUserId(@PathVariable("userId") String userId){
        return R.success(userService.getOnlyInfoById(userId));
    }
}
