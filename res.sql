/*
 Navicat MySQL Data Transfer

 Source Server         : 127.0.0.1
 Source Server Version : 50636
 Source Host           : 127.0.0.1
 Source Database       : res

 Target Server Version : 50636
 File Encoding         : utf-8

 Date: 11/14/2018 15:23:35 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `question_res_ref`
-- ----------------------------
DROP TABLE IF EXISTS `question_res_ref`;
CREATE TABLE `question_res_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `sys_question`
-- ----------------------------
DROP TABLE IF EXISTS `sys_question`;
CREATE TABLE `sys_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_name` varchar(50) NOT NULL,
  `content` varchar(500) NOT NULL,
  `create_by` int(11) NOT NULL,
  `is_del` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `sys_res`
-- ----------------------------
DROP TABLE IF EXISTS `sys_res`;
CREATE TABLE `sys_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(50) NOT NULL,
  `img_path_id` varchar(200) NOT NULL,
  `res_path_id` varchar(200) NOT NULL,
  `res_type` char(10) NOT NULL COMMENT '1 word 2 ppt 3 video ',
  `security_level` char(10) NOT NULL,
  `autor_name` varchar(50) NOT NULL,
  `expiry_date` varchar(255) NOT NULL,
  `creator_id` int(11) NOT NULL,
  `audit_status` char(1) NOT NULL DEFAULT '0' COMMENT '是否审核通过 0未通过 1通过',
  `is_del` char(1) NOT NULL DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_res`
-- ----------------------------
BEGIN;
INSERT INTO `sys_res` VALUES ('1', '21', '', '23123', '1', '1', 'crystal', '2018-11-03', '1', '0', '0'), ('2', '2.pdf', '', '/upload/2018-11-06/7a9fffa2-b743-45ce-9eeb-9c190045ff00.pdf', '1', '1', 'krystal', '2018-11-02', '1', '0', '0'), ('3', '2.pdf', '/upload/2018-11-13/a3028ad4-ef1f-41b7-aaeb-53ba17ef68da.jpg', '/upload/2018-11-13/6f31a60f-9f16-41bc-8852-f1302baf47af.pdf', '1', '5', '12345', '2018-11-13', '1', '0', '0'), ('4', '2.pdf', '/upload/2018-11-13/c3cbd1be-b581-4ad4-884f-09551348d92f.jpg', '/upload/2018-11-13/1082d2e4-cf4e-4f65-9606-6c3fa9957df5.pdf', '1', '5', '12345', '2018-11-13', '1', '0', '0'), ('5', '2.pdf', '/upload/2018-11-13/add44125-7a9f-4916-9f58-8c221e347a2c.jpg', '/upload/2018-11-13/157418b4-a678-4f95-ace3-12ce50c4ea4c.pdf', '1', '5', '12345', '2018-11-13', '1', '0', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_res_path`
-- ----------------------------
DROP TABLE IF EXISTS `sys_res_path`;
CREATE TABLE `sys_res_path` (
  `id` int(11) NOT NULL,
  `res_name` varchar(100) NOT NULL,
  `res_path` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_en_name` varchar(50) NOT NULL,
  `is_del` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('2', '学生', 'student', '0'), ('3', '老师', 'teacher', '0'), ('4', '管理员', 'admin', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('1', '1', '2'), ('2', '2', '3'), ('3', '3', '4'), ('4', '4', '2');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `sex` int(11) NOT NULL,
  `is_del` char(1) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'student', 'student', 'student@qq.com', '15266778390', '0', '0', '2018-10-29 10:47:15'), ('2', 'teacher', 'teacher', 'teacher@qq.com', '15627384971', '1', '0', '0000-00-00 00:00:00'), ('3', 'admin', 'admin', 'admin@qq.com', '15602938475', '0', '0', '2018-11-01 00:03:38'), ('4', '123', '123456', '', '', '0', '1', '2018-11-14 12:29:16');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
