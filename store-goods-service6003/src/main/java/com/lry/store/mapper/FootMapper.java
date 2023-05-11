package com.lry.store.mapper;

import com.lry.store.domain.Foot;
import com.lry.store.dto.FootDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface FootMapper {

    void createFoot(Foot foot);

    Set<FootDto> getFootByUserId(@Param("userId") String userId);

    void deleteFootByUserId(@Param("userId") String userId);

    Integer delGoodsOfFoot(@Param("ids") String ids);
}
