package com.lry.store.mapper;

import com.lry.store.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface AddressMapper {
    List<Address> getAddressOfUserId(@Param("userId") String userId);

    Integer createAddress(Address address);

    Address getOne(@Param("id") String id);

    Integer cloDefault(@Param("userId") String userId);

    Integer updateAddress(Address address);

    Integer deleteAddress(@Param("id") String id);
}
