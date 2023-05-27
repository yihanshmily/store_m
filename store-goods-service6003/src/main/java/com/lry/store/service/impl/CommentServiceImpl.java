package com.lry.store.service.impl;

import com.lry.store.domain.Comment;
import com.lry.store.domain.Shop;
import com.lry.store.domain.User;
import com.lry.store.dto.CommentDto;
import com.lry.store.mapper.CommentMapper;
import com.lry.store.service.CallOrderService;
import com.lry.store.service.CallService;
import com.lry.store.service.CommentService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

@Service

public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CallService callService;

    @Resource
    private CallOrderService callOrderService;

    @Override
    public List<CommentDto> getCommentIsHead(String goodsId) {
        List<Comment> commentList = commentMapper.getCommentAboutHead(goodsId,1);
        return getCommentInfo(commentList,goodsId);
    }

    @Override
    public List<CommentDto> getCommentNotHead(String goodsId,String headId) {
        List<Comment> commentList = commentMapper.getCommentAboutNotHead(goodsId,headId,0);
        return getCommentInfo(commentList,goodsId);
    }

    @Override
    public Comment getCommentByOrderId(String orderId) {
        return commentMapper.getCommentByOrderId(orderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createComment(Comment comment) {
        comment.setId(SnowflakeIdWorker.getNextId());
        Integer integer = commentMapper.createComment(comment);
//        修改订单的状态
        if(comment.getIsHead()){
            callOrderService.updateOrderStatus(comment.getOrderId(),"待分享");
        }
        return R.returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateGive(String id,Integer giveLike) {
        Integer integer = commentMapper.updateGive(id,giveLike);
        return R.returnString(integer);
    }

    //    获取评论信息
//    @GlobalTransactional(name = "comment_getById",rollbackFor = Exception.class)
    private List<CommentDto> getCommentInfo(List<Comment> commentList,String goodsId) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        if (commentList!= null && commentList.size() > 0) {
            for (Comment comment : commentList) {
                CommentDto commentDto = new CommentDto();
                User user = callService.getUserToOtherService(comment.getUserId());
                Shop shop = callService.getShopToOtherService(comment.getShopId());
                BeanUtils.copyProperties(comment,commentDto);
                commentDto.setUserName(user.getName());
                String[] userSplit = user.getImg().split(",");
                commentDto.setUserImg(userSplit[0]);
                commentDto.setShopName(shop.getName());
                String[] shopSplit = shop.getImg().split(",");
                commentDto.setShopImg(shopSplit[0]);
                commentDto.setSonComments(commentMapper.getSonComments(comment.getId(),goodsId));
                if (comment.getImg()!=null) {
                    commentDto.setCommentImgs(comment.getImg().split(","));
                }
                commentDtoList.add(commentDto);
            }
        }
        return commentDtoList;
    }

}
