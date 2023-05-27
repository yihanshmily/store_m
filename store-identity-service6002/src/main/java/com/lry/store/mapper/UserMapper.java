package com.lry.store.mapper;

import com.lry.store.domain.Manager;
import com.lry.store.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int getCounts(@Param("searchName") String searchName);

    List<User> getAllByLikes(@Param("searchName") String searchName,@Param("currentPage")Integer currentPage,
                       @Param("number")Integer number);

    User getOnlyInfoById(@Param("id") String id);

    void updateStatus(@Param("id") String id);

    String getImg(@Param("news") String news);

    int updateInfo(User user);

    Integer updatePwd(@Param("id") String id, @Param("oldPwd") String oldPwd, @Param("newPwd") String newPwd);

    Integer userIsNull(@Param("userName") String userName);
}
