/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 127.0.0.1:3306
 Source Schema         : res

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 27/11/2018 00:24:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question_res_ref
-- ----------------------------
DROP TABLE IF EXISTS `question_res_ref`;
CREATE TABLE `question_res_ref`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_res_ref
-- ----------------------------
INSERT INTO `question_res_ref` VALUES (1, 1, 1);
INSERT INTO `question_res_ref` VALUES (2, 1, 2);
INSERT INTO `question_res_ref` VALUES (3, 1, 3);
INSERT INTO `question_res_ref` VALUES (4, 2, 1);
INSERT INTO `question_res_ref` VALUES (5, 2, 2);
INSERT INTO `question_res_ref` VALUES (6, 2, 3);
INSERT INTO `question_res_ref` VALUES (7, 3, 1);
INSERT INTO `question_res_ref` VALUES (8, 3, 2);
INSERT INTO `question_res_ref` VALUES (9, 3, 3);
INSERT INTO `question_res_ref` VALUES (10, 4, 1);
INSERT INTO `question_res_ref` VALUES (11, 4, 2);
INSERT INTO `question_res_ref` VALUES (12, 4, 3);
INSERT INTO `question_res_ref` VALUES (13, 5, 1);
INSERT INTO `question_res_ref` VALUES (14, 5, 2);
INSERT INTO `question_res_ref` VALUES (15, 5, 3);
INSERT INTO `question_res_ref` VALUES (16, 6, 1);
INSERT INTO `question_res_ref` VALUES (17, 6, 2);
INSERT INTO `question_res_ref` VALUES (18, 6, 3);
INSERT INTO `question_res_ref` VALUES (19, 7, 1);
INSERT INTO `question_res_ref` VALUES (20, 7, 2);
INSERT INTO `question_res_ref` VALUES (21, 7, 3);
INSERT INTO `question_res_ref` VALUES (22, 8, 1);
INSERT INTO `question_res_ref` VALUES (23, 8, 2);
INSERT INTO `question_res_ref` VALUES (24, 8, 3);
INSERT INTO `question_res_ref` VALUES (25, 9, 1);
INSERT INTO `question_res_ref` VALUES (26, 9, 2);
INSERT INTO `question_res_ref` VALUES (27, 9, 3);
INSERT INTO `question_res_ref` VALUES (28, 10, 1);
INSERT INTO `question_res_ref` VALUES (29, 10, 2);
INSERT INTO `question_res_ref` VALUES (30, 10, 3);
INSERT INTO `question_res_ref` VALUES (31, 11, 1);
INSERT INTO `question_res_ref` VALUES (32, 11, 2);
INSERT INTO `question_res_ref` VALUES (33, 11, 3);
INSERT INTO `question_res_ref` VALUES (34, 12, 1);
INSERT INTO `question_res_ref` VALUES (35, 12, 2);
INSERT INTO `question_res_ref` VALUES (36, 12, 3);
INSERT INTO `question_res_ref` VALUES (37, 13, 1);
INSERT INTO `question_res_ref` VALUES (38, 13, 2);
INSERT INTO `question_res_ref` VALUES (39, 13, 3);
INSERT INTO `question_res_ref` VALUES (40, 14, 1);
INSERT INTO `question_res_ref` VALUES (41, 14, 2);
INSERT INTO `question_res_ref` VALUES (42, 14, 3);
INSERT INTO `question_res_ref` VALUES (43, 15, 6);
INSERT INTO `question_res_ref` VALUES (44, 15, 7);
INSERT INTO `question_res_ref` VALUES (45, 15, 8);
INSERT INTO `question_res_ref` VALUES (46, 16, 7);
INSERT INTO `question_res_ref` VALUES (47, 16, 8);
INSERT INTO `question_res_ref` VALUES (48, 17, 7);
INSERT INTO `question_res_ref` VALUES (49, 18, 7);
INSERT INTO `question_res_ref` VALUES (50, 18, 8);
INSERT INTO `question_res_ref` VALUES (51, 18, 9);
INSERT INTO `question_res_ref` VALUES (52, 18, 10);
INSERT INTO `question_res_ref` VALUES (53, 19, 9);
INSERT INTO `question_res_ref` VALUES (54, 19, 10);
INSERT INTO `question_res_ref` VALUES (55, 19, 8);
INSERT INTO `question_res_ref` VALUES (56, 20, 9);
INSERT INTO `question_res_ref` VALUES (57, 20, 10);
INSERT INTO `question_res_ref` VALUES (58, 20, 7);
INSERT INTO `question_res_ref` VALUES (59, 21, 9);
INSERT INTO `question_res_ref` VALUES (60, 21, 10);
INSERT INTO `question_res_ref` VALUES (61, 22, 10);
INSERT INTO `question_res_ref` VALUES (62, 22, 8);
INSERT INTO `question_res_ref` VALUES (63, 22, 9);
INSERT INTO `question_res_ref` VALUES (64, 23, 8);
INSERT INTO `question_res_ref` VALUES (65, 24, 9);
INSERT INTO `question_res_ref` VALUES (66, 24, 10);
INSERT INTO `question_res_ref` VALUES (67, 25, 8);
INSERT INTO `question_res_ref` VALUES (68, 25, 7);
INSERT INTO `question_res_ref` VALUES (69, 25, 9);
INSERT INTO `question_res_ref` VALUES (71, 27, 9);
INSERT INTO `question_res_ref` VALUES (72, 27, 10);
INSERT INTO `question_res_ref` VALUES (73, 28, 7);
INSERT INTO `question_res_ref` VALUES (74, 28, 9);
INSERT INTO `question_res_ref` VALUES (75, 28, 10);
INSERT INTO `question_res_ref` VALUES (76, 29, 9);
INSERT INTO `question_res_ref` VALUES (77, 30, 8);
INSERT INTO `question_res_ref` VALUES (78, 30, 7);
INSERT INTO `question_res_ref` VALUES (79, 31, 7);
INSERT INTO `question_res_ref` VALUES (80, 31, 8);
INSERT INTO `question_res_ref` VALUES (81, 31, 9);
INSERT INTO `question_res_ref` VALUES (82, 32, 9);
INSERT INTO `question_res_ref` VALUES (83, 33, 7);
INSERT INTO `question_res_ref` VALUES (84, 34, 13);
INSERT INTO `question_res_ref` VALUES (85, 34, 14);

-- ----------------------------
-- Table structure for sys_question
-- ----------------------------
DROP TABLE IF EXISTS `sys_question`;
CREATE TABLE `sys_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_by` int(11) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `is_del` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_question
-- ----------------------------
INSERT INTO `sys_question` VALUES (15, '测试题库1', '测试题库1', 13, '2018-11-21 11:06:24', '1');
INSERT INTO `sys_question` VALUES (16, '测试题库2', '测试题库2', 13, '2018-11-21 11:06:32', '1');
INSERT INTO `sys_question` VALUES (17, '题库11', '题库', 9, '2018-11-21 18:43:42', '1');
INSERT INTO `sys_question` VALUES (18, '12', '23', 13, '2018-11-21 11:06:34', '1');
INSERT INTO `sys_question` VALUES (19, '1', '2', 13, '2018-11-21 11:06:35', '1');
INSERT INTO `sys_question` VALUES (20, '1', '2', 13, '2018-11-21 11:06:36', '1');
INSERT INTO `sys_question` VALUES (21, '1', '2', 13, '2018-11-21 11:06:38', '1');
INSERT INTO `sys_question` VALUES (22, '1', '2', 13, '2018-11-21 11:06:39', '1');
INSERT INTO `sys_question` VALUES (23, '1', '2', 13, '2018-11-21 11:06:40', '1');
INSERT INTO `sys_question` VALUES (24, '1', '2', 13, '2018-11-21 11:06:41', '1');
INSERT INTO `sys_question` VALUES (25, '1', '2', 13, '2018-11-21 11:06:43', '1');
INSERT INTO `sys_question` VALUES (27, '一年级', '一年级', 13, '2018-11-21 11:06:44', '1');
INSERT INTO `sys_question` VALUES (28, '1', '2', 13, '2018-11-21 11:06:46', '1');
INSERT INTO `sys_question` VALUES (29, '语文', '语文', 13, '2018-11-25 19:53:08', '1');
INSERT INTO `sys_question` VALUES (30, '测试题库2', '测试题库2', 13, '2018-11-25 19:53:12', '1');
INSERT INTO `sys_question` VALUES (31, '测试资源3', '测试资源3', 13, '2018-11-25 19:53:16', '1');
INSERT INTO `sys_question` VALUES (32, '测试题库22222', '语文', 9, '2018-11-21 18:43:29', '1');
INSERT INTO `sys_question` VALUES (33, '题库1', '题库1', 13, '2018-11-25 19:53:19', '1');
INSERT INTO `sys_question` VALUES (34, '语文一年级资源', '语文一年级资源（课+题）', 13, '2018-11-25 20:05:11', '0');

-- ----------------------------
-- Table structure for sys_res
-- ----------------------------
DROP TABLE IF EXISTS `sys_res`;
CREATE TABLE `sys_res`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `img_path_id` int(11) NOT NULL,
  `res_path_id` int(11) NOT NULL,
  `res_type` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '1 word 2 ppt 3 video ',
  `security_level` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `autor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `expiry_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `creator_id` int(11) NOT NULL,
  `audit_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '是否审核通过 0未通过 1通过',
  `create_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `is_del` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_res
-- ----------------------------
INSERT INTO `sys_res` VALUES (6, '测试资源', 10, 9, '3', '语文', '测试资源', '1', 13, '1', '2018-11-20 21:32:49', '1');
INSERT INTO `sys_res` VALUES (7, '测试资源2', 12, 11, '3', '数学', '测试资源2', '2', 13, '1', '2018-11-25 19:52:31', '1');
INSERT INTO `sys_res` VALUES (8, '测试资源3', 14, 13, '1', '英语', '测试资源3', '3', 13, '1', '2018-11-25 19:52:33', '1');
INSERT INTO `sys_res` VALUES (9, '资源4', 19, 22, '3', '语文', '资源4', '1', 13, '1', '2018-11-25 19:52:35', '1');
INSERT INTO `sys_res` VALUES (10, '两种监听', 21, 20, '3', '英语', '朱老师', '1', 9, '1', '2018-11-25 19:52:38', '1');
INSERT INTO `sys_res` VALUES (11, '语文第二课视频', 25, 24, '3', '语文', '李老师', '1', 13, '1', '2018-11-25 19:52:40', '1');
INSERT INTO `sys_res` VALUES (12, '小蜗牛', 27, 26, '2', '语文', '王老师', '1', 13, '1', '2018-11-25 19:52:43', '1');
INSERT INTO `sys_res` VALUES (13, '小蜗牛', 29, 28, '2', '语文', '王老师', '1', 9, '1', '2018-11-25 19:56:32', '0');
INSERT INTO `sys_res` VALUES (14, '语文一年级上某课练习题', 31, 30, '1', '语文', '李老师', '1', 13, '1', '2018-11-25 19:59:25', '0');
INSERT INTO `sys_res` VALUES (15, '某课教学视频', 33, 32, '3', '数学', '某某', '2', 13, '1', '2018-11-25 20:03:03', '0');

-- ----------------------------
-- Table structure for sys_res_path
-- ----------------------------
DROP TABLE IF EXISTS `sys_res_path`;
CREATE TABLE `sys_res_path`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `res_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_res_path
-- ----------------------------
INSERT INTO `sys_res_path` VALUES (1, '2.pdf', '/upload/2018-11-14/8381f795-9e6e-44df-b1b1-7c03fa817c19.pdf');
INSERT INTO `sys_res_path` VALUES (2, '2.pdf', '/upload/2018-11-14/487b4277-a276-44f5-8a48-b854e0995602.pdf');
INSERT INTO `sys_res_path` VALUES (3, 'cvm_init.log', '\\upload\\2018-11-18\\94862413-23f0-4cec-9395-1c28fc53bbce.log');
INSERT INTO `sys_res_path` VALUES (4, 'cvm_init.log', '\\upload\\2018-11-18\\601752ee-bbe6-41a6-a0c4-cc07699cc7ad.log');
INSERT INTO `sys_res_path` VALUES (5, '_FI8}5KZYA28OT81$DJ]ULS.jpg', '\\upload\\2018-11-18\\1d6c8514-cd35-4644-b3fd-17a022711d0b.jpg');
INSERT INTO `sys_res_path` VALUES (6, '8D3L@`PUM9GWVP@O)0SY]EE.jpg', '\\upload\\2018-11-18\\bfc1eea2-a22e-47be-af50-b3139d4ff2ee.jpg');
INSERT INTO `sys_res_path` VALUES (7, '4X$LKJFAUB842UWF]I6H[~3.jpg', '\\upload\\2018-11-18\\2f4b92d8-3f45-4848-8a78-66e8fe3d852b.jpg');
INSERT INTO `sys_res_path` VALUES (8, '8$`N]@5YRTTLO6@D)0I%E)B.jpg', '\\upload\\2018-11-18\\66dc000b-56c4-4be0-9bfa-53d19d183649.jpg');
INSERT INTO `sys_res_path` VALUES (9, '8D3L@`PUM9GWVP@O)0SY]EE.jpg', '\\upload\\2018-11-18\\fa807651-57d3-4499-afec-1e62a3e3a04a.jpg');
INSERT INTO `sys_res_path` VALUES (10, '8$`N]@5YRTTLO6@D)0I%E)B.jpg', '\\upload\\2018-11-18\\17ab43b6-4ff6-4ced-810f-b9e795f5d424.jpg');
INSERT INTO `sys_res_path` VALUES (11, '2Y9EWP@0R7BA){B`72WZ6H3.jpg', '\\upload\\2018-11-18\\58f05ab8-e9c8-487d-bb9a-55e9f878355d.jpg');
INSERT INTO `sys_res_path` VALUES (12, '4X$LKJFAUB842UWF]I6H[~3.jpg', '\\upload\\2018-11-18\\ee954ef2-ac27-47f9-8cee-eb2113f73f82.jpg');
INSERT INTO `sys_res_path` VALUES (13, '9U12Q1]46O%YGZFV3@306(I.jpg', '\\upload\\2018-11-18\\6011f614-651c-42be-8aab-b56b3e0bff86.jpg');
INSERT INTO `sys_res_path` VALUES (14, '9U12Q1]46O%YGZFV3@306(I.jpg', '\\upload\\2018-11-18\\0d5e387a-a286-4ba4-bd73-dcf367ce7613.jpg');
INSERT INTO `sys_res_path` VALUES (15, '7BQGQKD$73E[30QXN2]}%YT.gif', '\\upload\\2018-11-20\\64173eac-1ed4-46e1-a1ee-504b2507541d.gif');
INSERT INTO `sys_res_path` VALUES (16, '2Y9EWP@0R7BA){B`72WZ6H3.jpg', '\\upload\\2018-11-20\\1daf0d90-a646-48c2-9303-cb83a9cd9e4a.jpg');
INSERT INTO `sys_res_path` VALUES (17, '8D3L@`PUM9GWVP@O)0SY]EE.jpg', '\\upload\\2018-11-20\\32c71e5d-896f-4f55-a462-1f52548977a5.jpg');
INSERT INTO `sys_res_path` VALUES (18, '8D3L@`PUM9GWVP@O)0SY]EE.jpg', '\\upload\\2018-11-20\\92a8ad57-49ea-41c4-af4a-8215b95d24a4.jpg');
INSERT INTO `sys_res_path` VALUES (19, 'FHN_RS[`{32OIEDDP]EMU5Y.png', '\\upload\\2018-11-20\\fdba6c54-3ca1-401e-9f57-f08b854afbfb.png');
INSERT INTO `sys_res_path` VALUES (20, 'android21 两种监听器.exe', '\\upload\\2018-11-20\\3d94bf63-e345-4b58-adbd-2933feab20b9.exe');
INSERT INTO `sys_res_path` VALUES (21, '1.png', '\\upload\\2018-11-20\\ace93046-b9a2-492b-9f82-0013059fd950.png');
INSERT INTO `sys_res_path` VALUES (22, 'syslog.txt', '\\upload\\2018-11-21\\b3c38944-e6df-455c-ace0-52a43a6dc595.txt');
INSERT INTO `sys_res_path` VALUES (23, 'kk 2018-09-03 15-58-35.mp4', '\\upload\\2018-11-25\\40cf4175-46bb-4f81-9d76-cfc2c9a3cbe3.mp4');
INSERT INTO `sys_res_path` VALUES (24, 'kk 2018-09-03 15-58-35.mp4', '\\upload\\2018-11-25\\7dc53088-9f17-4bb3-992f-f017ad91aa32.mp4');
INSERT INTO `sys_res_path` VALUES (25, '1.png', '\\upload\\2018-11-25\\942b9973-df4f-4544-9a04-9867d3be03e8.png');
INSERT INTO `sys_res_path` VALUES (26, '小蜗牛.ppt', '\\upload\\2018-11-25\\2c3ab89e-9486-4d13-8bc4-a88dd9c77db7.ppt');
INSERT INTO `sys_res_path` VALUES (27, '图片1.jpg', '\\upload\\2018-11-25\\00d23e99-fe7a-4e9e-ac02-ededf300b4c0.jpg');
INSERT INTO `sys_res_path` VALUES (28, '小蜗牛.ppt', '\\upload\\2018-11-25\\fe4c9ba6-b70a-4b5e-9d49-d1a838e9915c.ppt');
INSERT INTO `sys_res_path` VALUES (29, '图片1.jpg', '\\upload\\2018-11-25\\8a0f357f-6e9d-42be-bd12-3ebbd9ed2e9f.jpg');
INSERT INTO `sys_res_path` VALUES (30, '语文一年级某课练习题.doc', '\\upload\\2018-11-25\\41b59a16-ebf7-48f8-b428-abe4268b37b4.doc');
INSERT INTO `sys_res_path` VALUES (31, '图片2.jpg', '\\upload\\2018-11-25\\7bbb8e74-bb1c-4dbe-9c27-420708c40877.jpg');
INSERT INTO `sys_res_path` VALUES (32, '数学某课教学视频.mp4', '\\upload\\2018-11-25\\550d384c-5710-48f0-8720-971a556247d6.mp4');
INSERT INTO `sys_res_path` VALUES (33, '1.png', '\\upload\\2018-11-25\\27f23859-5ebe-4b4f-970a-87e03226098e.png');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_en_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `is_del` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (2, '学生', 'student', '0');
INSERT INTO `sys_role` VALUES (3, '老师', 'teacher', '0');
INSERT INTO `sys_role` VALUES (4, '管理员', 'admin', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 8, 4);
INSERT INTO `sys_user_role` VALUES (9, 9, 3);
INSERT INTO `sys_user_role` VALUES (10, 10, 2);
INSERT INTO `sys_user_role` VALUES (11, 11, 3);
INSERT INTO `sys_user_role` VALUES (12, 12, 3);
INSERT INTO `sys_user_role` VALUES (13, 13, 4);
INSERT INTO `sys_user_role` VALUES (15, 14, 2);
INSERT INTO `sys_user_role` VALUES (16, 15, 2);
INSERT INTO `sys_user_role` VALUES (17, 16, 2);
INSERT INTO `sys_user_role` VALUES (18, 17, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sex` int(11) NOT NULL,
  `is_del` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, 'zhaomeng', 'zhaomeng', '', '', 0, '0', '2018-11-14 22:10:55');
INSERT INTO `user` VALUES (9, 'teacher', 'teacher', '', '', 0, '0', '2018-11-15 14:11:52');
INSERT INTO `user` VALUES (10, 'student', 'student', '', '', 0, '0', '2018-11-15 14:39:52');
INSERT INTO `user` VALUES (11, 'teacher1', 'teacher1', '', '', 0, '0', '2018-11-15 20:29:45');
INSERT INTO `user` VALUES (12, 'student1', 'student1', ' ', ' ', 0, '0', '2018-11-15 21:55:59');
INSERT INTO `user` VALUES (13, 'admin', 'admin', '', '', 0, '0', '2018-11-15 22:05:24');
INSERT INTO `user` VALUES (14, 'student3', 'student3', '', '', 0, '1', '2018-11-15 22:08:16');
INSERT INTO `user` VALUES (15, 'student4', 'student4', '', '', 0, '1', '2018-11-15 22:11:15');
INSERT INTO `user` VALUES (16, 'student6', 'student6', '', '', 0, '1', '2018-11-15 22:35:56');
INSERT INTO `user` VALUES (17, 'student7', 'student7', '', '', 0, '1', '2018-11-15 22:37:02');

SET FOREIGN_KEY_CHECKS = 1;
