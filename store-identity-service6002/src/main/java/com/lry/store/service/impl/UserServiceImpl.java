package com.lry.store.service.impl;

import com.lry.store.domain.Manager;
import com.lry.store.domain.User;
import com.lry.store.dto.PageDto;
import com.lry.store.mapper.UserMapper;
import com.lry.store.service.UserService;
import com.lry.store.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageDto getAllByLikes(String searchName,Integer currentPage, Integer number) {
        PageDto pageDto = new PageDto();
        List<User> managerList = userMapper.getAllByLikes(searchName,(currentPage-1)*number,number);
        int counts = userMapper.getCounts(searchName);
        pageDto.setDataList(managerList);
        pageDto.setNumbers(counts);
        pageDto.setTotalPages(counts/number);
        return pageDto;
    }

    @Override
    public User getOnlyInfoById(String id) {
        return userMapper.getOnlyInfoById(id);
    }

    @Override
    public void updateStatus(String id) {
        userMapper.updateStatus(id);
    }

    @Override
    public String getImg(String news) {
        return userMapper.getImg(news);
    }

    @Override
    public String updateInfo(User user) {
        int sum = userMapper.updateInfo(user);
        return returnInfo(sum);
    }

    @Override
    public String updatePwd(String id, String oldPwd, String newPwd) {
        Integer integer = userMapper.updatePwd(id, oldPwd, newPwd);
        return returnInfo(integer);
    }

    public String returnInfo(Integer sum){
        if (sum >=1) {
            return R.success("成功");
        }else {
            return R.error("失败");
        }
    }
}
