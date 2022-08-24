/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : school_new

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/08/2022 08:57:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `t_id` int(0) NULL DEFAULT NULL,
  `s_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `teacher`(`t_id`) USING BTREE,
  INDEX `student`(`s_id`) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 2, 1001);
INSERT INTO `class` VALUES (2, 2, 1002);
INSERT INTO `class` VALUES (3, 2, 1003);
INSERT INTO `class` VALUES (4, 2, 1004);
INSERT INTO `class` VALUES (5, 2, 1005);
INSERT INTO `class` VALUES (6, 2, 1006);
INSERT INTO `class` VALUES (7, 2, 1007);
INSERT INTO `class` VALUES (8, 2, 1008);
INSERT INTO `class` VALUES (9, 2, 1009);
INSERT INTO `class` VALUES (10, 2, 1010);
INSERT INTO `class` VALUES (11, 3, 1001);
INSERT INTO `class` VALUES (12, 3, 1002);
INSERT INTO `class` VALUES (13, 3, 1003);
INSERT INTO `class` VALUES (14, 3, 1004);
INSERT INTO `class` VALUES (15, 3, 1005);
INSERT INTO `class` VALUES (16, 3, 1006);
INSERT INTO `class` VALUES (17, 3, 1007);
INSERT INTO `class` VALUES (18, 3, 1008);
INSERT INTO `class` VALUES (19, 3, 1009);
INSERT INTO `class` VALUES (20, 3, 1010);
INSERT INTO `class` VALUES (29, 2, 1015);

SET FOREIGN_KEY_CHECKS = 1;
