/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : lv_tu_matter

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 18/05/2021 09:21:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img`  (
  `i_id` int NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dateime` date NULL DEFAULT NULL,
  `u_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES (15, 'qwerras', '2021-04-06', 4);
INSERT INTO `img` VALUES (18, 'qwerras', '2021-04-06', 1);
INSERT INTO `img` VALUES (19, 'qwerras', '2021-04-06', 1);
INSERT INTO `img` VALUES (20, 'qwerras', '2021-04-06', 1);
INSERT INTO `img` VALUES (21, 'qwerras', '2021-04-06', 1);
INSERT INTO `img` VALUES (22, 'qwerras', '2021-04-06', 1);
INSERT INTO `img` VALUES (28, 'http:^^192.168.112.145:8888^group1^M00^00^01^wKhwkWBuYGmAagw0AABPM6pU2vQ31.jpeg', '2021-04-08', 6);
INSERT INTO `img` VALUES (29, 'http:^^192.168.112.145:8888^group1^M00^00^01^wKhwkWBuZkWAEqibAAGtnWcRulw42.jpeg', '2021-04-08', 6);
INSERT INTO `img` VALUES (38, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWB8D_eAQPjFAABPM6pU2vQ49.jpeg', '2021-04-18', 5);
INSERT INTO `img` VALUES (40, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWB8ECeAO-FdAABPM6pU2vQ84.jpeg', '2021-04-18', 6);
INSERT INTO `img` VALUES (41, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWB8ENeAC2_-AAF4Hn4SN4E56.jpeg', '2021-04-18', 6);
INSERT INTO `img` VALUES (43, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWB8z_WAdW9MAADZPC_YEuI07.jpeg', '2021-04-19', 6);
INSERT INTO `img` VALUES (44, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWB8z_qAIWwGAADni5x-vvY16.jpeg', '2021-04-19', 6);
INSERT INTO `img` VALUES (46, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWCHXP6Ab2yVAABPM6pU2vQ57.jpeg', '2021-04-27', 11);
INSERT INTO `img` VALUES (47, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWCHXgqAJSB1AAF4Hn4SN4E36.jpeg', '2021-04-27', 11);
INSERT INTO `img` VALUES (48, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWCHb9qAOmzMAAMS5SjvJjU99.jpeg', '2021-04-27', 6);
INSERT INTO `img` VALUES (49, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWCHb-eAC3wpAABPM6pU2vQ75.jpeg', '2021-04-27', 6);
INSERT INTO `img` VALUES (50, 'http:^^192.168.112.145:8888^group1^M00^00^02^wKhwkWCHb-mAYOiJAABPM6pU2vQ17.jpeg', '2021-04-27', 6);

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
