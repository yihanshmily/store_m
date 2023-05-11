package com.lry.store.mapper;

import com.lry.store.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    Integer getSonComments(@Param("commentId") String commentId,@Param("goodsId") String goodsId);

    List<Comment> getCommentAboutHead(@Param("goodsId") String goodsId, @Param("number") int number);

    Integer getCommentByGoodsId(@Param("ids") String ids);

    void deleteCommentByGoodsId(@Param("ids") String ids);

    List<Comment> getCommentAboutNotHead(@Param("goodsId") String goodsId,
                                         @Param("headId") String headId,@Param("number") int number);

    Comment getCommentByOrderId(@Param("orderId") String orderId);

    Integer createComment(Comment comment);

    Integer updateGive(@Param("id") String id, @Param("giveLike") Integer giveLike);
}
