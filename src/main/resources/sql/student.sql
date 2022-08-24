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

 Date: 24/08/2022 08:57:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_no` int(0) NOT NULL,
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`s_no`) USING BTREE,
  UNIQUE INDEX `name`(`s_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (12, '赵六3', '2022-08-19', '男');
INSERT INTO `student` VALUES (1001, '李1', '2022-08-18', '男');
INSERT INTO `student` VALUES (1002, '李2', '2022-08-18', '女');
INSERT INTO `student` VALUES (1003, '李3', '2022-08-18', '男');
INSERT INTO `student` VALUES (1004, '李4', '2022-08-18', '男');
INSERT INTO `student` VALUES (1005, '李5', '2022-08-18', '男');
INSERT INTO `student` VALUES (1006, '李6', '2022-08-18', '男');
INSERT INTO `student` VALUES (1007, '李7', '2022-08-18', '女');
INSERT INTO `student` VALUES (1008, '李8', '2022-08-18', '男');
INSERT INTO `student` VALUES (1009, '李9', '2022-08-18', '女');
INSERT INTO `student` VALUES (1010, '李10', '2022-08-18', '男');
INSERT INTO `student` VALUES (1011, '赵六4', '2022-08-19', '男');
INSERT INTO `student` VALUES (1012, '许志威', '2000-05-02', '男');
INSERT INTO `student` VALUES (1013, '许志威2', '2000-05-02', '男');
INSERT INTO `student` VALUES (1014, '许志威1', '2000-05-02', '男');
INSERT INTO `student` VALUES (1015, '许志威3', '2000-05-02', '男');
INSERT INTO `student` VALUES (1028, 'xzw', '2022-08-19', '男');

SET FOREIGN_KEY_CHECKS = 1;
