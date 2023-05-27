package com.lry.store.service;

import com.lry.store.domain.User;
import com.lry.store.dto.PageDto;

public interface UserService {

    PageDto getAllByLikes(String searchName,Integer currentPage, Integer number);

    User getOnlyInfoById(String id);

    void updateStatus(String id);

    String getImg(String news);

    String updateInfo(User user);

    String updatePwd(String id, String oldPwd, String newPwd);

    String userIsNull(String userName);
}
