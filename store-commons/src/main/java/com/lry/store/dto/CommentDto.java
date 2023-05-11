package com.lry.store.dto;

import com.lry.store.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto extends Comment {
    private String userName;
    private String userImg;
    private String shopName;
    private String shopImg;
    private Integer sonComments;
    private String[] commentImgs;
}
