package com.lry.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private String id;
    private String goodsId;
    private String userId;
    private String shopId;
    private String orderId;
    private String img;
    private String content;
    private Integer score;
    private Boolean isHead;
    private String headCommentId;
    private Integer giveLike;
    private Date createTime;
    private Date updateTime;
}
