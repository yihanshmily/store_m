package com.lry.store.service.impl;

import com.lry.store.domain.Manager;
import com.lry.store.dto.PageDto;
import com.lry.store.mapper.ManagerMapper;
import com.lry.store.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public PageDto getAllByLikes(String searchName,Integer currentPage, Integer number) {
        PageDto pageDto = new PageDto();
        List<Manager> managerList = managerMapper.getAllByLikes(searchName,(currentPage-1)*number,number);
        int counts = managerMapper.getCounts(searchName);
        pageDto.setDataList(managerList);
        pageDto.setNumbers(counts);
        pageDto.setTotalPages(counts/number);
        return pageDto;
    }

    @Override
    public Manager getOnlyInfoById(String id) {
       return managerMapper.getOnlyInfoById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(String id) {
        managerMapper.updateStatus(id);
    }

}
