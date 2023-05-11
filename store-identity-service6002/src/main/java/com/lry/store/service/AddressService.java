package com.lry.store.service;

import com.lry.store.domain.Address;

public interface AddressService {
    String getAddressOfUserId(String userId);

    String createAddress(Address address, String userId);

    String getOne(String id);

    String updateAddress(Address address, String userId);

    String deleteAddress(String id);
}
