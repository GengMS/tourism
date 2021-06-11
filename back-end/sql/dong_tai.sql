/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : dong_tai

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 12/06/2021 07:05:37
*/
create database dong_tai;
use dong_tai;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `d_id` int NOT NULL,
  `u_id` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `c_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `fk_com_did`(`d_id`) USING BTREE,
  CONSTRAINT `fk_com_did` FOREIGN KEY (`d_id`) REFERENCES `dong` (`d_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `d_id` int NOT NULL,
  `type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `fk_did`(`d_id`) USING BTREE,
  CONSTRAINT `fk_did` FOREIGN KEY (`d_id`) REFERENCES `dong` (`d_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (93, 117, '标题', '宁佳毅xx');
INSERT INTO `content` VALUES (94, 117, '图片', 'http://192.168.112.145:8888/group1/M00/00/03/wKhwkWC2GqKAXf1sAABPM6pU2vQ08.jpeg');
INSERT INTO `content` VALUES (95, 118, '标题', 'sdfs');
INSERT INTO `content` VALUES (96, 119, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (97, 120, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (98, 121, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (99, 122, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (100, 123, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (101, 124, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (102, 125, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (103, 126, '标题', '宁佳毅他家');

-- ----------------------------
-- Table structure for dong
-- ----------------------------
DROP TABLE IF EXISTS `dong`;
CREATE TABLE `dong`  (
  `d_id` int NOT NULL AUTO_INCREMENT,
  `u_id` int NULL DEFAULT NULL,
  `type` bit(1) NULL DEFAULT NULL,
  `dot_count` int NULL DEFAULT 0,
  `comments_count` int NULL DEFAULT 0,
  `sight` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`d_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dong
-- ----------------------------
INSERT INTO `dong` VALUES (117, 6, b'0', 1, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (118, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (119, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (120, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (121, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (122, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (123, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (124, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (125, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (126, 6, b'0', 0, 0, '宁佳毅他家');

-- ----------------------------
-- Table structure for dot
-- ----------------------------
DROP TABLE IF EXISTS `dot`;
CREATE TABLE `dot`  (
  `d_id` int NOT NULL,
  `u_id` int NULL DEFAULT NULL,
  `do_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`do_id`) USING BTREE,
  INDEX `fk_dot_did`(`d_id`) USING BTREE,
  CONSTRAINT `fk_dot_did` FOREIGN KEY (`d_id`) REFERENCES `dong` (`d_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dot
-- ----------------------------
INSERT INTO `dot` VALUES (117, 6, 93);

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
) ENGINE = InnoDB AUTO_INCREMENT = 695 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
