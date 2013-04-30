/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50166
Source Host           : 169.169.43.85:3306
Source Database       : ForensicLion

Target Server Type    : MYSQL
Target Server Version : 50166
File Encoding         : 65001

Date: 2013-03-25 14:33:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `case_charge`
-- ----------------------------
DROP TABLE IF EXISTS `case_charge`;
CREATE TABLE `case_charge` (
  `charge_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收费编号',
  `case_id` varchar(10) DEFAULT NULL COMMENT '案件号',
  `charge_class` varchar(100) DEFAULT NULL COMMENT '收费项目',
  `charge_standard_type` varchar(100) DEFAULT NULL COMMENT '标准类型',
  `charge_amount` decimal(10,0) DEFAULT NULL COMMENT '收费金额',
  `charge_remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`charge_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='鉴定收费';

-- ----------------------------
-- Records of case_charge
-- ----------------------------

-- ----------------------------
-- Table structure for `case_check_infor`
-- ----------------------------
DROP TABLE IF EXISTS `case_check_infor`;
CREATE TABLE `case_check_infor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '检材编号',
  `case_id` varchar(10) DEFAULT NULL COMMENT '所属案件编号',
  `check_name` varchar(360) DEFAULT NULL COMMENT '名称',
  `check_class` varchar(360) DEFAULT NULL COMMENT '检材类别',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `get_date` date DEFAULT NULL COMMENT '提取日期',
  `barcode` varchar(300) DEFAULT NULL COMMENT '条形码',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='鉴定检材信息';

-- ----------------------------
-- Records of case_check_infor
-- ----------------------------

-- ----------------------------
-- Table structure for `case_doc`
-- ----------------------------
DROP TABLE IF EXISTS `case_doc`;
CREATE TABLE `case_doc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件编号',
  `case_id` varchar(10) DEFAULT NULL COMMENT '案件编号',
  `description` varchar(360) DEFAULT NULL COMMENT '描述',
  `filename` varchar(360) DEFAULT NULL COMMENT '文件名',
  `filesize` varchar(360) DEFAULT NULL COMMENT '大小',
  `filetype` varchar(360) DEFAULT NULL COMMENT '类型',
  `data` mediumblob COMMENT '数据',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='案件文件';

-- ----------------------------
-- Records of case_doc
-- ----------------------------

-- ----------------------------
-- Table structure for `case_identified_info`
-- ----------------------------
DROP TABLE IF EXISTS `case_identified_info`;
CREATE TABLE `case_identified_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '被鉴定人编号',
  `case_id` varchar(10) DEFAULT NULL COMMENT '案件号',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `idcard` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `education` varchar(100) DEFAULT NULL COMMENT '文化程度',
  `nation` varchar(100) DEFAULT NULL COMMENT '民族',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='被鉴定人信息';

-- ----------------------------
-- Records of case_identified_info
-- ----------------------------

-- ----------------------------
-- Table structure for `case_infor`
-- ----------------------------
DROP TABLE IF EXISTS `case_infor`;
CREATE TABLE `case_infor` (
  `case_id` varchar(10) NOT NULL DEFAULT '' COMMENT '案件号',
  `identify_major` varchar(60) DEFAULT NULL COMMENT '鉴定专业',
  `entrust_date` date DEFAULT NULL COMMENT '委托日期',
  `identify_request` varchar(300) DEFAULT NULL COMMENT '鉴定要求',
  `entruster_address` varchar(300) DEFAULT NULL COMMENT '联系地址',
  `report_getway` varchar(30) DEFAULT NULL COMMENT '文书领取',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收件人',
  `receiver_address` varchar(300) DEFAULT NULL COMMENT '邮寄地址',
  `receiver_code` varchar(10) DEFAULT NULL COMMENT '邮寄邮编',
  `receiver_email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `entruster` varchar(100) DEFAULT NULL COMMENT '委托方',
  `entruster_relation` varchar(100) DEFAULT NULL COMMENT '与本案关系',
  `entruster_num` varchar(30) DEFAULT NULL COMMENT '委托宗号',
  `linkman` varchar(30) DEFAULT NULL COMMENT '联 系 人',
  `linkman_tel` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `linkman_fax` varchar(30) DEFAULT NULL COMMENT '传真号码',
  `identify_sender` varchar(30) DEFAULT NULL COMMENT '送 检 人',
  `insurance_unit` varchar(100) DEFAULT NULL COMMENT '保险单位',
  `insurance_linkman` varchar(30) DEFAULT NULL COMMENT '保险单位联系人',
  `insurance_tel` varchar(30) DEFAULT NULL COMMENT '保险单位联系电话1',
  `insurance_email` varchar(50) DEFAULT NULL COMMENT '保险单位电子邮件',
  `case_date` date DEFAULT NULL COMMENT '案发日期',
  `case_class` varchar(100) DEFAULT NULL COMMENT '案件类别',
  `case_identify_times` int(11) DEFAULT NULL COMMENT '鉴定次数',
  `case_progress` varchar(100) DEFAULT NULL COMMENT '案件阶段',
  `case_remark` varchar(3000) DEFAULT NULL COMMENT '简案摘要',
  `status` varchar(100) DEFAULT NULL COMMENT '案件状态',
  PRIMARY KEY (`case_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='案件信息';

-- ----------------------------
-- Records of case_infor
-- ----------------------------

-- ----------------------------
-- Table structure for `case_internal_statistics`
-- ----------------------------
DROP TABLE IF EXISTS `case_internal_statistics`;
CREATE TABLE `case_internal_statistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '内部统计编码',
  `case_id` varchar(10) DEFAULT NULL COMMENT '案件编号',
  `payee` varchar(100) DEFAULT NULL COMMENT '收款人',
  `identify_assistant` varchar(100) DEFAULT NULL COMMENT '鉴定助理',
  `appraiser1` varchar(100) DEFAULT NULL COMMENT '鉴定人一',
  `appraiser2` varchar(100) DEFAULT NULL COMMENT '鉴定人二',
  `signer` varchar(100) DEFAULT NULL COMMENT '签发人',
  `sources` varchar(400) DEFAULT NULL COMMENT '来源渠道',
  `operation_maintain` varchar(400) DEFAULT NULL COMMENT '业务维护',
  `vip` varchar(400) DEFAULT NULL COMMENT 'VIP客户',
  `operations_owner` varchar(400) DEFAULT NULL COMMENT '业务归口',
  `remark` varchar(1200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='内部统计';

-- ----------------------------
-- Records of case_internal_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for `case_pic`
-- ----------------------------
DROP TABLE IF EXISTS `case_pic`;
CREATE TABLE `case_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片编号',
  `case_id` varchar(100) DEFAULT NULL COMMENT '案件编号',
  `description` varchar(360) DEFAULT NULL COMMENT '描述',
  `filename` varchar(360) DEFAULT NULL COMMENT '文件名',
  `filesize` varchar(360) DEFAULT NULL COMMENT '大小',
  `filetype` varchar(360) DEFAULT NULL COMMENT '类型',
  `data` mediumblob COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_pic
-- ----------------------------

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parentid` bigint(11) NOT NULL COMMENT '父节点ID',
  `name` varchar(100) NOT NULL COMMENT '节点名',
  `code` varchar(100) NOT NULL COMMENT '节点代码',
  `content` varchar(100) DEFAULT NULL COMMENT '内容',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `doc_template`
-- ----------------------------
DROP TABLE IF EXISTS `doc_template`;
CREATE TABLE `doc_template` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '模版编号',
  `description` varchar(360) DEFAULT NULL COMMENT '模板描述',
  `filename` varchar(360) DEFAULT NULL COMMENT '文件名',
  `filesize` varchar(360) DEFAULT NULL COMMENT '文件大小',
  `filetype` varchar(360) DEFAULT NULL COMMENT '文件类型',
  `data` mediumblob COMMENT '文件数据',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `loginname` varchar(10) DEFAULT NULL COMMENT '登录名',
  `passwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `major` varchar(60) DEFAULT NULL COMMENT '专业',
  `jobtitle` varchar(60) DEFAULT NULL COMMENT '职称',
  `practice_num` varchar(30) DEFAULT NULL COMMENT '执业证号',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  `registdate` datetime DEFAULT NULL COMMENT '注册时间',
  `logindate` datetime DEFAULT NULL COMMENT '上次登录时间',
  `status` int(11) DEFAULT '1' COMMENT '状态 1为有效 0 为锁定',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `user_function`
-- ----------------------------
DROP TABLE IF EXISTS `user_function`;
CREATE TABLE `user_function` (
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户ID',
  `function_id` bigint(11) DEFAULT NULL COMMENT '功能ID',
  KEY `FK5552CDCC8E447AF6` (`user_id`),
  KEY `FK5552CDCC9A6F75D6` (`function_id`),
  KEY `FK5552CDCCEC651B94` (`function_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `usermanageHis`
-- ----------------------------
DROP TABLE IF EXISTS `usermanageHis`;
CREATE TABLE `usermanageHis` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(11) NOT NULL COMMENT '用户姓名',
  `opdate` datetime NOT NULL COMMENT '操作时间',
  `opip` varchar(20) NOT NULL COMMENT '操作IP',
  `opcd` varchar(30) NOT NULL COMMENT '操作类型',
  `content` varchar(1200) NOT NULL COMMENT '操作内容',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermanageHis
-- ----------------------------
