package com.lry.store.controller;

import com.lry.store.domain.Manager;
import com.lry.store.domain.Shop;
import com.lry.store.domain.User;
import com.lry.store.dto.PageDto;
import com.lry.store.service.ManagerService;
import com.lry.store.service.ShopService;
import com.lry.store.service.UserService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/identity")
public class getAllController {

    @Resource
    private ManagerService managerService;

    @Resource
    private UserService userService;

    @Resource
    private ShopService shopService;

    //    根据商品或用户名获取对应的头像信息
    @GetMapping("/getImg/{identity}/{news}")
    public String getImg(@PathVariable("identity") String identity, @PathVariable("news") String news) {
        if ("user".equals(identity)){
            return R.success(userService.getImg(news));
        }else {
            String img = shopService.getImg(news);
            return R.success(img);
        }
    }

    //    获取单独的信息/登录
    @GetMapping("/{identity}/{id}")
    public String getOnlyInfoById(@PathVariable("identity") String identity, @PathVariable("id") String id) {
        if ("管理员".equals(identity)) {
            Manager manager = managerService.getOnlyInfoById(id);
            return R.success(manager);
        } else if ("用户".equals(identity)) {
            User user = userService.getOnlyInfoById(id);
                return R.success(user);
        } else {
            Shop shop = shopService.getOnlyInfoById(id);
                return R.success(shop);
        }
    }

    //    修改状态
    @PutMapping("/{identity}/{id}")
    public String updateStatus(@PathVariable("identity") String identity, @PathVariable("id") String id) {
        if ("管理员".equals(identity)) {
            managerService.updateStatus(id);
        } else if ("用户".equals(identity)) {
            userService.updateStatus(id);
        } else {
            shopService.updateStatus(id);
        }
        return R.success("修改成功");
    }

//    模糊查询
    @GetMapping("/{identity}/like/{searchName}/{currentPage}/{number}")
    public String likeSearch(@PathVariable("identity") String identity,
                             @PathVariable("searchName") String searchName,
                             @PathVariable("currentPage") Integer currentPage,
                             @PathVariable("number") Integer number){
        PageDto pageDto = null;
        if ("all".equals(searchName)){
            searchName = "%";
        }
        if ("管理员".equals(identity)){
            pageDto = managerService.getAllByLikes(searchName,currentPage,number);
        }else if ("用户".equals(identity)){
            pageDto = userService.getAllByLikes(searchName,currentPage,number);
        }else {
            pageDto = shopService.getAllByLikes(searchName,currentPage,number);
        }
        return R.success(pageDto);
    }

//    提供给其他服务调用

    //    得到用户信息
    @GetMapping("/get/user/{id}")
    public User getUserToOtherService(@PathVariable("id") String id){
        return userService.getOnlyInfoById(id);
    }

    //    得到商铺信息
    @GetMapping("/get/shop/{id}")
    public Shop getShopToOtherService(@PathVariable("id") String id){
        return shopService.getOnlyInfoById(id);

    }
}
