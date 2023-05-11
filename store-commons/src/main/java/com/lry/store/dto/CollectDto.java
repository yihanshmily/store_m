package com.lry.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectDto {
    private String userId;
    private String userName;
    private String userImg;
}
