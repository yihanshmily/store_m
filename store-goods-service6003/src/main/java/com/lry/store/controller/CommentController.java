package com.lry.store.controller;

import com.lry.store.domain.Comment;
import com.lry.store.service.CommentService;
import com.lry.store.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/goods/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

//    对订单进行评论
    @PostMapping
    public String createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

//   修改评论点赞数
    @PutMapping("/give/{id}/{giveLike}")
    public String updateGive(@PathVariable("id") String id,@PathVariable("giveLike") Integer giveLike){
        return commentService.updateGive(id,giveLike);
    }

//    获取头评论
    @GetMapping("/head/{goodsId}")
    public String getCommentIsHead(@PathVariable("goodsId") String goodsId){
        return R.success(commentService.getCommentIsHead(goodsId));
    }

//    获取非头评论
    @GetMapping("/notHead/{goodsId}/{headId}")
    public String getCommentNotHead(@PathVariable("goodsId") String goodsId,
                                    @PathVariable("headId") String headId){
        return R.success(commentService.getCommentNotHead(goodsId,headId));
    }

    /*
    * 供其他服务调用
    * */

    //    获取指定订单id的评论
    @GetMapping("/getOrder/{orderId}")
    public Comment getCommentByOrderId(@PathVariable("orderId") String orderId){
        return commentService.getCommentByOrderId(orderId);
    }
}
