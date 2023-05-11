package com.lry.store.controller;

import com.lry.store.domain.Address;
import com.lry.store.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

//    新增地址
    @PostMapping("/{userId}")
    public String createAddress(@RequestBody Address address,@PathVariable("userId") String userId){
        return addressService.createAddress(address,userId);
    }

//    删除指定地址
    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable("id") String id){
        return addressService.deleteAddress(id);
    }

//    修改指定地址
    @PutMapping("/{userId}")
    public String updateAddress(@RequestBody Address address,@PathVariable("userId") String userId){
        return addressService.updateAddress(address,userId);
    }

//   获取单个地址信息
    @GetMapping("/getOne/{id}")
    public String getOne(@PathVariable("id") String id){
        return addressService.getOne(id);
    }

//    获取用户地址
    @GetMapping("/{userId}")
    public String getAddressOfUserId(@PathVariable("userId") String userId){
        return addressService.getAddressOfUserId(userId);
    }
}
