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

 Date: 18/05/2021 09:19:14
*/

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
INSERT INTO `comment` VALUES (83, 5, 'sad', 3);
INSERT INTO `comment` VALUES (83, 5, 'sad', 4);
INSERT INTO `comment` VALUES (83, 5, 'sad', 5);
INSERT INTO `comment` VALUES (83, 5, 'aaa', 6);
INSERT INTO `comment` VALUES (83, 5, 'dfdf', 7);
INSERT INTO `comment` VALUES (83, 5, 'dfdf', 8);
INSERT INTO `comment` VALUES (83, 5, 'aaa', 9);
INSERT INTO `comment` VALUES (83, 5, 'aaaa', 10);
INSERT INTO `comment` VALUES (83, 5, 'aaaaaaaaa', 11);
INSERT INTO `comment` VALUES (83, 5, 'dfd', 12);
INSERT INTO `comment` VALUES (83, 5, 'dfdf', 13);
INSERT INTO `comment` VALUES (83, 5, 'sd', 14);
INSERT INTO `comment` VALUES (83, 5, 'sd', 15);
INSERT INTO `comment` VALUES (83, 6, 'sds', 16);
INSERT INTO `comment` VALUES (106, 5, 'df', 22);
INSERT INTO `comment` VALUES (106, 5, 'sdfd', 23);
INSERT INTO `comment` VALUES (106, 5, 'dfd', 24);
INSERT INTO `comment` VALUES (106, 5, 'dfd', 25);
INSERT INTO `comment` VALUES (106, 5, 'a', 26);
INSERT INTO `comment` VALUES (106, 5, '哈喽', 27);
INSERT INTO `comment` VALUES (106, 5, 'a', 28);
INSERT INTO `comment` VALUES (95, 5, '宁佳毅xx', 29);
INSERT INTO `comment` VALUES (95, 6, '宁佳毅确实是xx', 30);
INSERT INTO `comment` VALUES (115, 6, 'dfd', 31);
INSERT INTO `comment` VALUES (115, 6, 'ss', 32);
INSERT INTO `comment` VALUES (115, 11, '年后', 33);
INSERT INTO `comment` VALUES (107, 11, '你好', 34);

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
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (53, 83, '标题', 'df');
INSERT INTO `content` VALUES (54, 84, '标题', '你好');
INSERT INTO `content` VALUES (55, 85, '标题', 'dfdf');
INSERT INTO `content` VALUES (56, 86, '标题', '念念佛');
INSERT INTO `content` VALUES (57, 87, '标题', 'erfsf');
INSERT INTO `content` VALUES (58, 88, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (59, 89, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (60, 90, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (61, 91, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (62, 92, '标题', 'dfd ');
INSERT INTO `content` VALUES (63, 93, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (64, 94, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (65, 95, '标题', '宁佳毅他家');
INSERT INTO `content` VALUES (66, 96, '标题', 'dfdf');
INSERT INTO `content` VALUES (71, 99, '标题', 'a');
INSERT INTO `content` VALUES (72, 100, '标题', 'b');
INSERT INTO `content` VALUES (73, 101, '标题', 'a');
INSERT INTO `content` VALUES (74, 102, '标题', 'a');
INSERT INTO `content` VALUES (75, 103, '标题', 'a');
INSERT INTO `content` VALUES (76, 104, '标题', 'df');
INSERT INTO `content` VALUES (79, 106, '标题', '王志心');
INSERT INTO `content` VALUES (80, 107, '标题', '宁佳毅开心就好');
INSERT INTO `content` VALUES (81, 107, '图片', 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWB8D2qAfnwUAABPM6pU2vQ33.jpeg');
INSERT INTO `content` VALUES (82, 108, '标题', 'sdfd');
INSERT INTO `content` VALUES (83, 109, '标题', 'aa');
INSERT INTO `content` VALUES (84, 110, '标题', 'aa');
INSERT INTO `content` VALUES (85, 111, '标题', 'aa');
INSERT INTO `content` VALUES (86, 112, '标题', 'aa');
INSERT INTO `content` VALUES (87, 113, '标题', 'aa');
INSERT INTO `content` VALUES (88, 114, '标题', 'aa');
INSERT INTO `content` VALUES (89, 115, '标题', 'aa');
INSERT INTO `content` VALUES (90, 116, '标题', '你好');
INSERT INTO `content` VALUES (91, 116, '图片', 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCHYGGAA3UHAABPM6pU2vQ51.jpeg');
INSERT INTO `content` VALUES (92, 116, '图片', 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCHYGOAUCv9AAF4Hn4SN4E63.jpeg');

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
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dong
-- ----------------------------
INSERT INTO `dong` VALUES (83, 5, b'0', 2, 14, '');
INSERT INTO `dong` VALUES (84, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (85, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (86, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (87, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (88, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (89, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (90, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (91, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (92, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (93, 6, b'0', 0, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (94, 6, b'0', 1, 0, '宁佳毅他家');
INSERT INTO `dong` VALUES (95, 6, b'0', 2, 2, '宁佳毅他家');
INSERT INTO `dong` VALUES (96, 6, b'0', 0, 0, 'dfdfd');
INSERT INTO `dong` VALUES (99, 5, b'0', 0, 0, 'aa');
INSERT INTO `dong` VALUES (100, 5, b'0', 0, 0, 'asd');
INSERT INTO `dong` VALUES (101, 5, b'0', 0, 0, 'aa');
INSERT INTO `dong` VALUES (102, 5, b'0', 1, 0, 'aa');
INSERT INTO `dong` VALUES (103, 5, b'0', 0, 0, 'aa');
INSERT INTO `dong` VALUES (104, 5, b'0', 1, 0, 'df');
INSERT INTO `dong` VALUES (106, 5, b'0', 1, 7, '石家庄新华');
INSERT INTO `dong` VALUES (107, 5, b'0', 1, 1, '新华');
INSERT INTO `dong` VALUES (108, 6, b'0', 0, 0, 'aa');
INSERT INTO `dong` VALUES (109, 6, b'0', 0, 0, 'aa');
INSERT INTO `dong` VALUES (110, 6, b'0', 0, 0, 'aa');
INSERT INTO `dong` VALUES (111, 6, b'0', 0, 0, 'aa');
INSERT INTO `dong` VALUES (112, 6, b'0', 1, 0, 'aa');
INSERT INTO `dong` VALUES (113, 6, b'0', 1, 0, 'aa');
INSERT INTO `dong` VALUES (114, 6, b'0', 2, 0, 'aa');
INSERT INTO `dong` VALUES (115, 6, b'0', 1, 3, 'aa');
INSERT INTO `dong` VALUES (116, 11, b'0', 0, 0, '宁佳毅他家');

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
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dot
-- ----------------------------
INSERT INTO `dot` VALUES (104, 5, 79);
INSERT INTO `dot` VALUES (94, 5, 80);
INSERT INTO `dot` VALUES (106, 5, 83);
INSERT INTO `dot` VALUES (95, 5, 84);
INSERT INTO `dot` VALUES (115, 6, 85);
INSERT INTO `dot` VALUES (114, 6, 86);
INSERT INTO `dot` VALUES (113, 6, 87);
INSERT INTO `dot` VALUES (112, 6, 88);
INSERT INTO `dot` VALUES (114, 11, 89);
INSERT INTO `dot` VALUES (107, 11, 90);
INSERT INTO `dot` VALUES (95, 11, 91);
INSERT INTO `dot` VALUES (102, 11, 92);

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
) ENGINE = InnoDB AUTO_INCREMENT = 668 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
