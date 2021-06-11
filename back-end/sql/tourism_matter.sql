/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : tourism_matter

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 12/06/2021 07:09:41
*/
create database tourism_matter;
use tourism_matter;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for forget_passwd
-- ----------------------------
DROP TABLE IF EXISTS `forget_passwd`;
CREATE TABLE `forget_passwd`  (
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mail_code` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forget_passwd
-- ----------------------------
INSERT INTO `forget_passwd` VALUES ('323063040@qq.com', 'a862', '2021-04-05 09:37:46');
INSERT INTO `forget_passwd` VALUES ('3230630440@qq.com', 'bf84', NULL);
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '5eb1', '2021-04-05 10:33:44');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '1fc8', '2021-04-05 11:18:40');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'b663', '2021-04-05 11:43:02');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'e48b', '2021-04-05 11:40:58');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '4053', '2021-04-05 15:51:34');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '7f71', '2021-04-05 15:51:35');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '7138', '2021-04-05 15:51:35');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '9216', '2021-04-05 15:51:36');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '3ade', '2021-04-05 15:51:37');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '24eb', '2021-04-05 15:51:39');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'b320', '2021-04-05 15:51:39');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '808b', '2021-04-05 15:51:40');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '177f', '2021-04-05 15:51:41');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '12e3', '2021-04-05 15:51:43');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'bb2b', '2021-04-05 15:51:43');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '6895', '2021-04-05 17:14:14');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '6ece', '2021-04-05 17:16:33');
INSERT INTO `forget_passwd` VALUES ('3155284171@qq.com', '819e', '2021-04-05 17:37:08');
INSERT INTO `forget_passwd` VALUES ('3155284171@qq.com', '941f', '2021-04-05 17:41:10');
INSERT INTO `forget_passwd` VALUES ('3155284171@qq.com', '6112', '2021-04-05 18:16:21');
INSERT INTO `forget_passwd` VALUES ('3155284171@qq.com', 'eedd', '2021-04-05 18:18:28');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '9b23', '2021-04-06 14:10:23');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'a197', '2021-04-14 09:01:20');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '1dfa', '2021-04-14 16:08:25');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '7b42', '2021-04-15 08:47:42');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '436c', '2021-04-16 08:42:20');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '077c', '2021-04-16 08:43:21');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'cef1', '2021-04-16 08:44:03');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'a52e', '2021-04-16 08:44:44');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '6dc2', '2021-04-16 08:45:41');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '0757', '2021-04-16 08:46:14');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'a4ab', '2021-04-16 08:46:43');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '7120', '2021-04-16 08:48:58');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '6f98', '2021-04-16 08:50:11');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'f2f6', '2021-04-16 08:57:09');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '27ae', '2021-04-16 08:59:35');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '082a', '2021-04-16 09:03:30');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '9a6a', '2021-04-16 09:04:20');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '3f07', '2021-04-16 09:05:36');
INSERT INTO `forget_passwd` VALUES ('2577907504@qq.com', '38cc', '2021-04-16 09:24:48');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '8c35', '2021-04-18 18:59:49');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'fdab', '2021-04-18 19:01:42');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '36f9', '2021-04-18 19:02:51');
INSERT INTO `forget_passwd` VALUES ('2577907504@qq.com', '0d47', '2021-04-18 19:06:11');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '03ea', '2021-05-28 11:37:19');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '11e8', '2021-05-28 11:37:32');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '1181', '2021-05-28 11:37:34');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', '36c5', '2021-05-28 11:37:35');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'eafb', '2021-05-28 11:37:35');
INSERT INTO `forget_passwd` VALUES ('3230630470@qq.com', 'b12d', '2021-05-28 11:40:56');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, 'geng');

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `branch_id` bigint NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int NOT NULL,
  `log_created` datetime(0) NOT NULL,
  `log_modified` datetime(0) NOT NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `passwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `identity` bit(1) NULL DEFAULT 00110000,
  `is_infor` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`u_id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, '3230630470@qq.com', '20030311', b'1', b'1');
INSERT INTO `user` VALUES (9, '3155284171@qq.com', '200303gg', b'0', b'0');
INSERT INTO `user` VALUES (11, '2577907504@qq.com', '200303', b'0', b'1');

-- ----------------------------
-- Table structure for user_infor
-- ----------------------------
DROP TABLE IF EXISTS `user_infor`;
CREATE TABLE `user_infor`  (
  `u_id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `the_say` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE,
  UNIQUE INDEX `fk_inforuid`(`u_id`) USING BTREE,
  CONSTRAINT `fk_inforuid` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_infor
-- ----------------------------
INSERT INTO `user_infor` VALUES (6, '管理员1', 'http:^^192.168.112.145:8888^group1^M00^00^03^wKhwkWC2GNiAR5b2AAF4Hn4SN4E91.jpeg', '管理员天下第一');
INSERT INTO `user_infor` VALUES (11, '宁佳毅', 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWB8EuuAd1dlAAF4Hn4SN4E26.jpeg', '我爱吃屎');

SET FOREIGN_KEY_CHECKS = 1;
