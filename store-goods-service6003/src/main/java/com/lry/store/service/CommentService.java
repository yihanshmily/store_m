package com.lry.store.service;

import com.lry.store.domain.Comment;
import com.lry.store.dto.CommentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentIsHead(String goodsId);


    List<CommentDto> getCommentNotHead(String goodsId,String headId);

    Comment getCommentByOrderId(String orderId);

    String createComment(Comment comment);

    String updateGive(String id,Integer giveLike);
}
