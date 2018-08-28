/*
Navicat MySQL Data Transfer

Source Server         : 本地测试
Source Server Version : 50630
Source Host           : localhost:3306
Source Database       : table

Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2018-08-28 16:19:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_oauth2_client`
-- ----------------------------
DROP TABLE IF EXISTS `tb_oauth2_client`;
CREATE TABLE `tb_oauth2_client` (
  `tb_oauth2_id` varchar(32) NOT NULL DEFAULT '' COMMENT '客户端表ID',
  `tb_oauth2_client_name` varchar(100) NOT NULL DEFAULT '' COMMENT '客户端名',
  `tb_oauth2_client_id` varchar(100) NOT NULL DEFAULT '' COMMENT '客户端ID',
  `tb_oauth2_client_secret` varchar(100) NOT NULL DEFAULT '' COMMENT '客户端密码',
  PRIMARY KEY (`tb_oauth2_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_oauth2_client
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `tb_user_id` char(32) NOT NULL COMMENT '用户UUID',
  `tb_user_login_name` varchar(20) NOT NULL COMMENT '用户登陆名',
  `tb_user_nick_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `tb_user_password_salt` varchar(8) DEFAULT '' COMMENT '用户密码盐',
  `tb_user_password` varchar(32) NOT NULL DEFAULT '' COMMENT '用户密码(为了保证Hash最长32位)',
  `tb_user_role` tinyint(2) NOT NULL DEFAULT '1' COMMENT '用户权限 0系统管理员 1后端管理 2数据管理',
  PRIMARY KEY (`tb_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('123123', '11', '12', '', '11', '1');
