package com.lry.store.mapper;

import com.lry.store.domain.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerMapper {

    int getCounts(@Param("searchName") String searchName);

    List<Manager> getAllByLikes(@Param("searchName") String searchName,@Param("currentPage")Integer currentPage,
                       @Param("number")Integer number);

    Manager getOnlyInfoById(@Param("id") String id);

    void updateStatus(@Param("id") String id);
}
