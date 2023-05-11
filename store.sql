/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : store

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 11/05/2023 19:11:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `address_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_default` tinyint(4) NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES (1, 1, '扬州庐江舒县', 0, '2023-04-08 19:23:41', '2023-04-08 19:23:44', '周公瑾', '13049283047');
INSERT INTO `t_address` VALUES (303206675249106944, 1, '庐江', 1, '2023-05-06 08:43:27', '2023-05-06 08:43:27', '周郎', '13049583402');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '衣服', '2023-04-02 11:01:45');
INSERT INTO `t_category` VALUES (2, '游戏', '2023-04-02 11:01:53');
INSERT INTO `t_category` VALUES (3, '电器', '2023-04-02 11:01:58');
INSERT INTO `t_category` VALUES (4, '家具', '2023-04-02 11:02:04');
INSERT INTO `t_category` VALUES (5, '生鲜', '2023-04-14 14:18:40');
INSERT INTO `t_category` VALUES (6, '运动', '2023-04-14 14:18:56');
INSERT INTO `t_category` VALUES (7, '美食', '2023-04-14 14:19:27');
INSERT INTO `t_category` VALUES (8, '装饰', '2023-05-11 15:12:38');
INSERT INTO `t_category` VALUES (9, '户外', '2023-05-11 15:12:38');
INSERT INTO `t_category` VALUES (10, '书本', '2023-05-11 15:12:38');
INSERT INTO `t_category` VALUES (11, '化妆', '2023-05-11 15:12:38');
INSERT INTO `t_category` VALUES (12, '个人用品', '2023-05-11 15:12:38');

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `goods_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `t_collect_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_collect_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `t_shop` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_collect
-- ----------------------------

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_head` tinyint(4) NOT NULL DEFAULT 0,
  `head_commentId` bigint(20) NULL DEFAULT NULL,
  `give_like` int(11) NULL DEFAULT 0 COMMENT '点赞数',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `order_id` bigint(20) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon`  (
  `id` bigint(20) NOT NULL,
  `meet_money` int(11) NOT NULL,
  `cut_money` int(11) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `goods_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for t_foot
-- ----------------------------
DROP TABLE IF EXISTS `t_foot`;
CREATE TABLE `t_foot`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updated_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `t_foot_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_foot_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_foot
-- ----------------------------
INSERT INTO `t_foot` VALUES (305126873568907264, 1, 305115616811945984, '2023-05-11 15:53:39', '2023-05-11 15:53:39');
INSERT INTO `t_foot` VALUES (305126909224685568, 1, 305115616811945984, '2023-05-11 15:53:47', '2023-05-11 15:53:47');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NOT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_status` tinyint(4) NULL DEFAULT 1,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `category_id` bigint(20) NOT NULL,
  `sale_room` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (1, 292061642181578752, '无', '204536puubc54mqbu5uozz.jpg,', 10, '无', 1, '2023-05-11 11:17:59', '2023-05-11 11:17:59', 1, 0);
INSERT INTO `t_goods` VALUES (305115616811945984, 292061642181578752, '大玩偶女生睡觉超大神奇宝贝公仔', 'my.jpg,QQ图片20220524140025.png,QQ图片20221216161755.jpg,', 169, '神奇宝贝公仔', 1, '2023-05-11 15:53:45', '2023-05-11 15:08:54', 2, 4);
INSERT INTO `t_goods` VALUES (305116762607718400, 292061642181578752, '卡通呆萌老虎马克杯可爱创意陶瓷杯子', '2114.jpg,5346.jpg,231443.jpg,', 12, '杯子', 1, '2023-05-11 15:13:28', '2023-05-11 15:13:28', 4, 0);
INSERT INTO `t_goods` VALUES (305124243715133440, 292061642181578752, '手镯女999足银手环素圈', '2572430-202204250912186265f572a0f56.jpg,20211201010119_2d00c.jpg,', 138, '晶莹剔透', 1, '2023-05-11 15:43:12', '2023-05-11 15:43:11', 8, 0);
INSERT INTO `t_goods` VALUES (305124552092946432, 292061642181578752, '白熊猫双眼熊猫计时精钢表带', 'img_62aa7ce81655c30.jpg,v2-24ec290a9db9e1f5d16df38d5f067dbc_720w.webp,', 69, '秀气', 1, '2023-05-11 15:44:25', '2023-05-11 15:44:25', 8, 0);

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager`  (
  `id` bigint(20) NOT NULL,
  `sole` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sole`(`sole`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES (1, '284700', 'admin', '123');
INSERT INTO `t_manager` VALUES (2, '350391', 'aaa', '123');

-- ----------------------------
-- Table structure for t_managerdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_managerdetail`;
CREATE TABLE `t_managerdetail`  (
  `id` bigint(20) NOT NULL,
  `manager_id` bigint(20) NOT NULL,
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_specil` tinyint(4) NULL DEFAULT 0,
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `manager_id`(`manager_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_managerdetail
-- ----------------------------
INSERT INTO `t_managerdetail` VALUES (1, 1, '13049829301', NULL, 1, '2023-03-31 21:18:49', '2023-03-31 21:18:47');
INSERT INTO `t_managerdetail` VALUES (2, 2, '13073920123', NULL, 0, '2023-04-01 15:17:51', '2023-03-31 21:21:41');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(20) NOT NULL,
  `sole` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `coupon_id` bigint(20) NULL DEFAULT NULL,
  `number` int(11) NOT NULL,
  `total_price` decimal(6, 2) NOT NULL,
  `is_user` tinyint(4) NULL DEFAULT 1,
  `is_shop` tinyint(4) NULL DEFAULT 1,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '待评价',
  `pay_way` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `address_id`(`address_id`) USING BTREE,
  INDEX `coupon_id`(`coupon_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `t_shop` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_order_ibfk_4` FOREIGN KEY (`address_id`) REFERENCES `t_address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (305126901926596609, 596608, 305115616811945984, 292061642181578752, 1, 303206675249106944, NULL, 4, 676.00, 1, 1, '2023-05-11 15:53:45', '2023-05-11 15:53:45', '待评价', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_repertory
-- ----------------------------
DROP TABLE IF EXISTS `t_repertory`;
CREATE TABLE `t_repertory`  (
  `id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `number` int(11) NOT NULL DEFAULT 0,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lateAdd_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `sum_total` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `t_repertory_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_repertory_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `t_shop` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_repertory
-- ----------------------------
INSERT INTO `t_repertory` VALUES (305115616858083328, 305115616811945984, 292061642181578752, -4, '成都', '2023-05-11 15:53:45', '2023-05-11 15:08:54', '2023-05-11 15:08:54', 0);
INSERT INTO `t_repertory` VALUES (305116762712576000, 305116762607718400, 292061642181578752, 0, '成都', '2023-05-11 15:13:28', '2023-05-11 15:13:28', '2023-05-11 15:13:28', 0);
INSERT INTO `t_repertory` VALUES (305124243744493568, 305124243715133440, 292061642181578752, 0, '成都', '2023-05-11 15:43:11', '2023-05-11 15:43:11', '2023-05-11 15:43:11', 0);
INSERT INTO `t_repertory` VALUES (305124552172638208, 305124552092946432, 292061642181578752, 0, '成都', '2023-05-11 15:44:25', '2023-05-11 15:44:25', '2023-05-11 15:44:25', 0);

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop`  (
  `id` bigint(20) NOT NULL,
  `sole` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sole`(`sole`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO `t_shop` VALUES (292061642181578752, '920616', '成都绫瑶', '123');

-- ----------------------------
-- Table structure for t_shopdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_shopdetail`;
CREATE TABLE `t_shopdetail`  (
  `id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_status` tinyint(4) NULL DEFAULT 1,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `shop_id`(`shop_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shopdetail
-- ----------------------------
INSERT INTO `t_shopdetail` VALUES (1, 1, '13099450234', '23_2495.jpg', 1, '2023-04-05 10:48:44', '2023-03-31 22:43:24');
INSERT INTO `t_shopdetail` VALUES (292061642252881920, 292061642181578752, '13049586938', 'v2-0f6d4424294edc22ce742c501df9c1c9_r.jpg', 1, '2023-05-10 20:15:33', '2023-05-10 20:15:33');

-- ----------------------------
-- Table structure for t_shoping
-- ----------------------------
DROP TABLE IF EXISTS `t_shoping`;
CREATE TABLE `t_shoping`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `number` int(11) NOT NULL,
  `text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `t_shoping_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_shoping_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shoping
-- ----------------------------

-- ----------------------------
-- Table structure for t_ucoupon
-- ----------------------------
DROP TABLE IF EXISTS `t_ucoupon`;
CREATE TABLE `t_ucoupon`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `coupon_id` bigint(20) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `is_use` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `coupon_id`(`coupon_id`) USING BTREE,
  CONSTRAINT `t_ucoupon_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_ucoupon_ibfk_2` FOREIGN KEY (`coupon_id`) REFERENCES `t_coupon` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ucoupon
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL,
  `sole` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sole`(`sole`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '347011', '周瑜', '123');
INSERT INTO `t_user` VALUES (2, '034291', '孙策', '123');

-- ----------------------------
-- Table structure for t_userdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_userdetail`;
CREATE TABLE `t_userdetail`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_status` tinyint(4) NULL DEFAULT 1,
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_userdetail
-- ----------------------------
INSERT INTO `t_userdetail` VALUES (1, 1, '13049582932', '20211201010119_2d00c.jpg', 1, '2023-05-11 15:50:14', '2023-05-11 15:50:14');
INSERT INTO `t_userdetail` VALUES (2, 2, '13092837591', 'da.webp', 1, '2023-04-10 15:33:56', '2023-03-31 22:29:40');

-- ----------------------------
-- Table structure for t_wallet
-- ----------------------------
DROP TABLE IF EXISTS `t_wallet`;
CREATE TABLE `t_wallet`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `wallet` decimal(10, 2) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_wallet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_wallet
-- ----------------------------
INSERT INTO `t_wallet` VALUES (1, 1, 133294.73, '2023-04-28 15:53:03', '2023-04-28 15:53:03');

-- ----------------------------
-- Table structure for t_walletdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_walletdetail`;
CREATE TABLE `t_walletdetail`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL DEFAULT 1,
  `money` decimal(10, 2) NOT NULL,
  `is_add` tinyint(4) NULL DEFAULT 0,
  `is_dec` tinyint(4) NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `t_walletdetail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_walletdetail
-- ----------------------------
INSERT INTO `t_walletdetail` VALUES (305126902006288384, 1, 305115616811945984, 676.00, 0, 1, '2023-05-11 15:53:45', '2023-05-11 15:53:45');

SET FOREIGN_KEY_CHECKS = 1;
