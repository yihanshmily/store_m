package com.lry.store.service;

import com.lry.store.domain.Manager;
import com.lry.store.dto.PageDto;

public interface ManagerService {

    PageDto getAllByLikes(String searchName,Integer currentPage, Integer number);

    Manager getOnlyInfoById(String id);

    void updateStatus(String id);

}
