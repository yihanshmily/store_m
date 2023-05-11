package com.lry.store.mapper;

import com.lry.store.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper {
    User userLogin(@Param("name") String name, @Param("pwd") String pwd);
}
