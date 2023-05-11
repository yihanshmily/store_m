package com.lry.store.controller;

import com.lry.store.service.FootService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/foot")
public class FootController {

    @Resource
    private FootService footService;

//    删除指定用户的足迹
    @DeleteMapping("/{userId}")
    public String delFootByUserId(@PathVariable("userId") String userId){
        return footService.delFootByUserId(userId);
    }

//    获取指定用户的足迹
    @GetMapping("/{userId}")
    public String getFootByUserId(@PathVariable("userId") String userId){
        return footService.getFootByUserId(userId);
    }
}
