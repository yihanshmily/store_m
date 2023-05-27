package com.lry.store.service.impl;

import com.lry.store.domain.Foot;
import com.lry.store.domain.Goods;
import com.lry.store.domain.Repertory;
import com.lry.store.dto.PageDto;
import com.lry.store.mapper.CommentMapper;
import com.lry.store.mapper.FootMapper;
import com.lry.store.mapper.GoodsMapper;
import com.lry.store.mapper.RepertoryMapper;
import com.lry.store.service.CallOrderService;
import com.lry.store.service.CallService;
import com.lry.store.service.GoodsService;
import com.lry.store.utils.R;
import com.lry.store.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private RepertoryMapper repertoryMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private FootMapper footMapper;

    @Resource
    private CallService callService;

    @Resource
    private CallOrderService callOrderService;

//    新增商品
    @Override
//    @GlobalTransactional(name = "goods-add",rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void addGoods(Goods goods) {
        String snowId = SnowflakeIdWorker.getNextId();
        goods.setId(snowId);
        goods.setCreateTime(new Date());
        goodsMapper.addGoods(goods);
//        同时创建相应的库存信息
        Repertory repertory = new Repertory();
        repertory.setId(SnowflakeIdWorker.getNextId());
        repertory.setGoodsId(snowId);
        repertory.setShopId(goods.getShopId());
        repertoryMapper.addRepertory(repertory);

    }

//    获取所有商品
    @Override
//    @GlobalTransactional(name = "goods-OneImgAll",rollbackFor = Exception.class)
    public PageDto getAllGoods(Integer currentPage, Integer pageSize) {
        PageDto pageDto = new PageDto();
        List<Goods> goodsList = goodsMapper.getAllGoods((currentPage - 1)*pageSize, pageSize);
        for (Goods goods : goodsList) {
            String[] split = goods.getImg().split(",");
            goods.setImg(split[0]);
        }
        Integer count = goodsList.size();
        pageDto.setDataList(goodsList);
        pageDto.setNumbers(count);
        pageDto.setTotalPages(count/pageSize);
        return pageDto;
    }

//    通过id获取商品
    @Override
    public Goods getGoodsById(String goodsId,String userId) {
        if (!"0".equals(userId)) {
            String footId = SnowflakeIdWorker.getNextId();
            footMapper.createFoot(new Foot(footId,userId,goodsId,new Date(),new Date()));
        }
        return goodsMapper.getGoodsById(goodsId);
    }

//    通过id获取指定商铺的商品(供其他微服务调用)
    @Override
//    @GlobalTransactional(name = "goods_getByShopId",rollbackFor = Exception.class)
    public List<Goods> getShopGoodsById(String shopId,String categoryId,Integer currentPage, Integer pageSize) {
        if ("all".equals(categoryId)) {
            List<Goods> goodsList = goodsMapper.getShopGoodsById(shopId, (currentPage - 1)*pageSize, pageSize);
            for (Goods goods : goodsList) {
                String[] split = goods.getImg().split(",");
                goods.setImg(split[0]);
            }
            return goodsList;
        } else {
            List<Goods> goodsList = goodsMapper.getShopGoodsByIdAndCategoryId(shopId, categoryId,
                    currentPage - 1, pageSize);
            for (Goods goods : goodsList) {
                String[] split = goods.getImg().split(",");
                goods.setImg(split[0]);
            }
            return goodsList;
        }
    }

//    获取指定商铺的商品个数
    @Override
    public int getShopGoodsCountByShopId(String shopId) {
        return goodsMapper.getShopGoodsCountByShopId(shopId);
    }

//    获取指定商铺及其分类的商品
    @Override
//    @GlobalTransactional(name = "goods_getByShopId_category",rollbackFor = Exception.class)
    public PageDto getShopGoodsByIdOfMySelf(String shopId, String categoryId, Integer currentPage, Integer pageSize) {
        PageDto pageDto = new PageDto();
        List<Goods> goodsList = null;
        int number = 0;
        if ("all".equals(categoryId)) {
            goodsList = goodsMapper.getShopGoodsById(shopId, (currentPage - 1)*pageSize, pageSize);
            for (Goods goods : goodsList) {
                String[] split = goods.getImg().split(",");
                goods.setImg(split[0]);
            }
        } else {
            goodsList = goodsMapper.getShopGoodsByIdAndCategoryId(shopId, categoryId,
                    (currentPage - 1)*pageSize, pageSize);
            for (Goods goods : goodsList) {
                String[] split = goods.getImg().split(",");
                goods.setImg(split[0]);
            }
        }
        number = goodsList.size();
        pageDto.setNumbers(number);
        pageDto.setTotalPages(number/pageSize);
        pageDto.setDataList(goodsList);
        return pageDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
//    @GlobalTransactional(name = "goods_deleteById",rollbackFor = Exception.class)
    public String deleteById(String ids) {
        ids = ids.substring(0, ids.length() - 1);
//        删除已领取的优惠卷
        goodsMapper.delGoodsOfCoupon(ids);
//        删除商品优惠卷
        goodsMapper.delCouponOfGoods(ids);
//        删除商品库存
        repertoryMapper.deleteById(ids);
//        删除商品收藏
        callService.delGoodsByIds(ids);
//        删除商品的消费记录
        callService.deleteWalletDetails(ids);
//        删除商品足迹
        footMapper.delGoodsOfFoot(ids);
//        删除购物车
        callOrderService.deleteGoodsOfShoping(ids);
//        删除商品订单
        callOrderService.delGoodsOfOrder(ids);
//        根据商品id查询商品评论
        Integer i = commentMapper.getCommentByGoodsId(ids);
        if (i>=1){
            commentMapper.deleteCommentByGoodsId(ids);
        }
        //        删除商品
        Integer integer = goodsMapper.deleteById(ids);
        return returnString(integer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateGoodsById(Goods goods) {
        Integer integer = goodsMapper.updateGoods(goods);
        return returnString(integer);
    }

    @Override
    public String getGoodsBySeral(String seral, Integer currentPage, Integer pageSize) {
        PageDto pageDto = new PageDto();
        List<Goods> goodsList = null;
        int size =0;
        if ("collect".equals(seral)) {
            goodsList = goodsMapper.getGoodsCollectBySeral(seral,
                    (currentPage - 1) * pageSize, pageSize);
            seral = "id";
        }else if ("comment".equals(seral)) {
            goodsList = goodsMapper.getGoodsCommentBySeral(seral,
                    (currentPage - 1) * pageSize, pageSize);
            seral = "id";
        }
        if (goodsList != null) {
            size = goodsList.size();
        }
        goodsList = goodsMapper.getGoodsBySeral(seral,
                (currentPage - 1) * (pageSize-size), pageSize-size);
        for (Goods goods : goodsList) {
            String[] split = goods.getImg().split(",");
            goods.setImg(split[0]);
        }
        Integer number = goodsMapper.getCountGoods();
        pageDto.setNumbers(number);
        pageDto.setTotalPages(number/pageSize);
        pageDto.setDataList(goodsList);
        return R.success(pageDto);
    }

    @Override
    public String getGoodsByCategory(String categoryId) {
        if ("all".equals(categoryId)) {
            categoryId = "%";
        }
        List<Goods> goodsList = goodsMapper.getGoodsByCategory(categoryId);
        for (Goods goods : goodsList) {
            String[] split = goods.getImg().split(",");
            goods.setImg(split[0]);
        }
        return R.success(goodsList);
    }

    @Override
    public String getGoodsLikeName(String searchName) {
        if ("all".equals(searchName)) {
            searchName = "%";
        }
        List<Goods> goodsList = goodsMapper.getGoodsLikeName(searchName);
        for (Goods goods : goodsList) {
            String[] split = goods.getImg().split(",");
            goods.setImg(split[0]);
        }
        return R.success(goodsList);
    }

    @Override
    public String getGoodsByShopId(String shopId) {
        return R.success(goodsMapper.getGoodsByShopId(shopId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateGoodsSaleRoom(String goodsId, Integer saleRoom) {
        Integer integer = goodsMapper.updateGoodsSaleRoom(goodsId, saleRoom);
        return R.returnString(integer);
    }

    //    返回语句
    private String returnString(Integer integer) {
        if (integer>=1){
            return R.success("成功");
        }else {
            return R.error("失败");
        }
    }
}
