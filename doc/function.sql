/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50166
Source Host           : 169.169.43.85:3306
Source Database       : ForensicLion

Target Server Type    : MYSQL
Target Server Version : 50166
File Encoding         : 65001

Date: 2013-03-06 15:19:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `function`
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `fun_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `parent` bigint(20) DEFAULT NULL,
  `fun_name` varchar(120) DEFAULT NULL,
  `fun_content` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`fun_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('1', '6', '用户管理', '用户管理');
INSERT INTO `function` VALUES ('2', '-1', '案件管理', '案件管理');
INSERT INTO `function` VALUES ('3', '1', '添加用户', '添加用户');
INSERT INTO `function` VALUES ('4', '1', '删除用户', '删除用户');
INSERT INTO `function` VALUES ('5', '1', '编辑用户', '编辑用户');
INSERT INTO `function` VALUES ('6', '-1', '系统管理', '系统管理');
