package com.lry.store.mapper;

import com.lry.store.domain.User;
import com.lry.store.domain.UserDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    Integer registerUser(User user);

    Integer registerUserDetail(UserDetail userDetail);
}
