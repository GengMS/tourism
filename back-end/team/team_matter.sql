/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : team_matter

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 18/05/2021 09:22:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for path_infor
-- ----------------------------
DROP TABLE IF EXISTS `path_infor`;
CREATE TABLE `path_infor`  (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `t_id` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE,
  INDEX `fk_p_tid`(`t_id`) USING BTREE,
  CONSTRAINT `fk_p_tid` FOREIGN KEY (`t_id`) REFERENCES `team_infor` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of path_infor
-- ----------------------------
INSERT INTO `path_infor` VALUES (4, 5, 'df');
INSERT INTO `path_infor` VALUES (5, 5, 'dfs');
INSERT INTO `path_infor` VALUES (9, 7, 'df');
INSERT INTO `path_infor` VALUES (10, 7, 'df');
INSERT INTO `path_infor` VALUES (11, 7, 'dfddf');
INSERT INTO `path_infor` VALUES (12, 7, 'df');
INSERT INTO `path_infor` VALUES (13, 8, 'ddd');
INSERT INTO `path_infor` VALUES (14, 8, 'aaa');
INSERT INTO `path_infor` VALUES (15, 8, 'bb');
INSERT INTO `path_infor` VALUES (16, 8, 'cc');
INSERT INTO `path_infor` VALUES (17, 8, 'dfdf');
INSERT INTO `path_infor` VALUES (18, 9, 'ddd');
INSERT INTO `path_infor` VALUES (19, 9, 'aaa');
INSERT INTO `path_infor` VALUES (20, 9, 'bb');
INSERT INTO `path_infor` VALUES (21, 9, 'cc');
INSERT INTO `path_infor` VALUES (22, 9, 'dfdf');
INSERT INTO `path_infor` VALUES (23, 10, 'ddd');
INSERT INTO `path_infor` VALUES (24, 10, 'aaa');
INSERT INTO `path_infor` VALUES (25, 10, 'bb');
INSERT INTO `path_infor` VALUES (26, 10, 'cc');
INSERT INTO `path_infor` VALUES (27, 10, 'dfdf');
INSERT INTO `path_infor` VALUES (28, 11, 'ddd');
INSERT INTO `path_infor` VALUES (29, 11, 'aaa');
INSERT INTO `path_infor` VALUES (30, 11, 'bb');
INSERT INTO `path_infor` VALUES (31, 11, 'cc');
INSERT INTO `path_infor` VALUES (32, 11, 'dfdf');
INSERT INTO `path_infor` VALUES (33, 12, 'ddd');
INSERT INTO `path_infor` VALUES (34, 12, 'aaa');
INSERT INTO `path_infor` VALUES (35, 12, 'bb');
INSERT INTO `path_infor` VALUES (36, 12, 'cc');
INSERT INTO `path_infor` VALUES (37, 12, 'dfdf');
INSERT INTO `path_infor` VALUES (38, 13, 'ddd');
INSERT INTO `path_infor` VALUES (39, 13, 'aaa');
INSERT INTO `path_infor` VALUES (40, 13, 'bb');
INSERT INTO `path_infor` VALUES (41, 13, 'cc');
INSERT INTO `path_infor` VALUES (42, 13, 'dfdf');
INSERT INTO `path_infor` VALUES (43, 14, 'ddd');
INSERT INTO `path_infor` VALUES (44, 14, 'aaa');
INSERT INTO `path_infor` VALUES (45, 14, 'bb');
INSERT INTO `path_infor` VALUES (46, 14, 'cc');
INSERT INTO `path_infor` VALUES (47, 14, 'dfdf');
INSERT INTO `path_infor` VALUES (53, 16, 'ddd');
INSERT INTO `path_infor` VALUES (54, 16, 'aaa');
INSERT INTO `path_infor` VALUES (55, 16, 'bb');
INSERT INTO `path_infor` VALUES (56, 16, 'cc');
INSERT INTO `path_infor` VALUES (57, 16, 'dfdf');
INSERT INTO `path_infor` VALUES (58, 17, 'ddd');
INSERT INTO `path_infor` VALUES (59, 17, 'aaa');
INSERT INTO `path_infor` VALUES (60, 17, 'bb');
INSERT INTO `path_infor` VALUES (61, 17, 'cc');
INSERT INTO `path_infor` VALUES (62, 17, 'dfdf');
INSERT INTO `path_infor` VALUES (63, 18, '从北京出发');
INSERT INTO `path_infor` VALUES (64, 18, '高速');
INSERT INTO `path_infor` VALUES (65, 18, '高速1');
INSERT INTO `path_infor` VALUES (66, 18, '高速2');
INSERT INTO `path_infor` VALUES (67, 18, '高速3');
INSERT INTO `path_infor` VALUES (68, 18, '海南');

-- ----------------------------
-- Table structure for phone_num
-- ----------------------------
DROP TABLE IF EXISTS `phone_num`;
CREATE TABLE `phone_num`  (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `phone_number` bigint NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`p_id`) USING BTREE,
  UNIQUE INDEX `uk_phone_num`(`phone_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_num
-- ----------------------------
INSERT INTO `phone_num` VALUES (1, 15010499404, '2021-04-25 14:19:11');

-- ----------------------------
-- Table structure for team_infor
-- ----------------------------
DROP TABLE IF EXISTS `team_infor`;
CREATE TABLE `team_infor`  (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `introduce` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  `departure` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `provider` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_infor
-- ----------------------------
INSERT INTO `team_infor` VALUES (5, 'df', 3, '河北省-唐山市-路南区', '天津市-市辖区-河东区', 'df');
INSERT INTO `team_infor` VALUES (7, '宁家一', 2000, '天津市-市辖区-和平区', '新疆维吾尔自治区-乌鲁木齐市-天山区', '宁佳毅');
INSERT INTO `team_infor` VALUES (8, 'sf', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (9, 'sfq', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (10, 'sfqq', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (11, 'sfqqa', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (12, 'sfqqad', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (13, 'sfqqaddf', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (14, 'sfqqaddfdf', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (16, 'sfqqaddfdfdfddf', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (17, 'sfqqaddfdfdfddfssssss', 1500, '天津市-市辖区-和平区', '北京市-市辖区-东城区', 'dfdf');
INSERT INTO `team_infor` VALUES (18, '中国海南三日游三日游三日游三日游三日游三日游三日游三日游三日游三日游三日游三日游三日游三日游三日游三', 3000, '北京市-市辖区-东城区', '天津市-市辖区-和平区', '宁佳毅他爸爸');

-- ----------------------------
-- Table structure for team_infor_img
-- ----------------------------
DROP TABLE IF EXISTS `team_infor_img`;
CREATE TABLE `team_infor_img`  (
  `ti_id` int NOT NULL AUTO_INCREMENT,
  `t_id` int NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ti_id`) USING BTREE,
  INDEX `fk_ti_tid`(`t_id`) USING BTREE,
  CONSTRAINT `fk_ti_tid` FOREIGN KEY (`t_id`) REFERENCES `team_infor` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_infor_img
-- ----------------------------
INSERT INTO `team_infor_img` VALUES (2, 5, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWB-JuSARSg-AAMS5SjvJjU68.jpeg');
INSERT INTO `team_infor_img` VALUES (5, 7, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCIRGABagnAABPM6pU2vQ07.jpeg');
INSERT INTO `team_infor_img` VALUES (6, 7, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCIRWAIh3GAAF4Hn4SN4E25.jpeg');
INSERT INTO `team_infor_img` VALUES (7, 8, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (8, 8, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (9, 8, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (10, 9, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (11, 9, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (12, 9, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (13, 10, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (14, 10, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (15, 10, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (16, 11, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (17, 11, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (18, 11, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (19, 12, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (20, 12, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (21, 12, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (22, 13, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (23, 13, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (24, 13, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (25, 14, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (26, 14, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (27, 14, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (31, 16, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (32, 16, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (33, 16, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (34, 17, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaWAd36-AABPM6pU2vQ25.jpeg');
INSERT INTO `team_infor_img` VALUES (35, 17, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLaiASpmpAAF4Hn4SN4E15.jpeg');
INSERT INTO `team_infor_img` VALUES (36, 17, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCCLbKAZUjgAAMS5SjvJjU98.jpeg');
INSERT INTO `team_infor_img` VALUES (37, 18, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCHYXSAGHkNAAF4Hn4SN4E35.jpeg');
INSERT INTO `team_infor_img` VALUES (38, 18, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCHYXeAKgXsAABPM6pU2vQ68.jpeg');
INSERT INTO `team_infor_img` VALUES (39, 18, 'http://192.168.112.145:8888/group1/M00/00/02/wKhwkWCHYXqAfxtdAABPM6pU2vQ94.jpeg');

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
) ENGINE = InnoDB AUTO_INCREMENT = 294 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
