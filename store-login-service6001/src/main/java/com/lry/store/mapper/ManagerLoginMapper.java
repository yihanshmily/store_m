package com.lry.store.mapper;

import com.lry.store.domain.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerLoginMapper {

    Manager managerLogin(Manager manager);
}
