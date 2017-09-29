/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : leangoo

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-09-14 23:26:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT,
  `board_name` varchar(255) DEFAULT NULL,
  `board_start_date` date DEFAULT NULL,
  `board_end_date` date DEFAULT NULL,
  `board_start` int(11) DEFAULT NULL,
  `board_locate` int(11) DEFAULT NULL,
  `board_is_archive` int(2) DEFAULT NULL,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '1', '2017-09-07', '2017-08-26', null, null, null);
INSERT INTO `board` VALUES ('2', '2', '2017-09-13', null, null, null, null);
INSERT INTO `board` VALUES ('3', '3', '2017-09-11', null, null, null, null);
INSERT INTO `board` VALUES ('4', '4', '2017-09-18', null, null, null, null);
INSERT INTO `board` VALUES ('5', '5', '2017-09-12', null, null, null, null);
INSERT INTO `board` VALUES ('6', 'test', null, null, null, null, null);
INSERT INTO `board` VALUES ('7', 'test', null, null, null, null, null);
INSERT INTO `board` VALUES ('8', 'test', null, null, null, null, null);
INSERT INTO `board` VALUES ('9', 'test', null, null, null, null, null);
INSERT INTO `board` VALUES ('10', 'test', null, null, null, null, null);
INSERT INTO `board` VALUES ('11', 'test', null, null, null, null, null);

-- ----------------------------
-- Table structure for board_list
-- ----------------------------
DROP TABLE IF EXISTS `board_list`;
CREATE TABLE `board_list` (
  `id` int(11) NOT NULL,
  `board_id` int(11) DEFAULT NULL,
  `list_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of board_list
-- ----------------------------

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_name` varchar(255) DEFAULT NULL,
  `card_intro` varchar(255) DEFAULT NULL,
  `card_end_date` date DEFAULT NULL,
  `card_start_date` date DEFAULT NULL,
  `card_label` varchar(255) DEFAULT NULL,
  `card_workload` double DEFAULT NULL,
  `card_locate` int(11) DEFAULT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '2', 'Intro2', '2017-09-06', null, null, null, null);
INSERT INTO `card` VALUES ('2', '1', 'Intro1', null, null, null, null, null);
INSERT INTO `card` VALUES ('3', '3', 'Intro3', null, null, null, null, null);
INSERT INTO `card` VALUES ('4', '4', 'Intro4', null, '2017-09-05', null, null, null);
INSERT INTO `card` VALUES ('5', '5', 'Intro5', null, null, null, null, null);

-- ----------------------------
-- Table structure for card_user
-- ----------------------------
DROP TABLE IF EXISTS `card_user`;
CREATE TABLE `card_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card_user
-- ----------------------------
INSERT INTO `card_user` VALUES ('1', '1', '1');
INSERT INTO `card_user` VALUES ('2', '2', '1');
INSERT INTO `card_user` VALUES ('3', '1', '2');
INSERT INTO `card_user` VALUES ('4', '3', '3');
INSERT INTO `card_user` VALUES ('5', '4', '3');
INSERT INTO `card_user` VALUES ('6', '4', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `comment_content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', null);
INSERT INTO `comment` VALUES ('2', '1', '2', null);
INSERT INTO `comment` VALUES ('3', '2', '3', null);
INSERT INTO `comment` VALUES ('4', '2', '1', null);
INSERT INTO `comment` VALUES ('5', '3', '4', null);
INSERT INTO `comment` VALUES ('6', '4', '4', null);

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list` (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `list_name` varchar(255) DEFAULT NULL,
  `list_locate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of list
-- ----------------------------
INSERT INTO `list` VALUES ('1', '1', null);
INSERT INTO `list` VALUES ('2', '2', null);
INSERT INTO `list` VALUES ('3', '3', null);
INSERT INTO `list` VALUES ('4', '4', null);
INSERT INTO `list` VALUES ('5', '5', null);
INSERT INTO `list` VALUES ('6', '6', null);

-- ----------------------------
-- Table structure for list_card
-- ----------------------------
DROP TABLE IF EXISTS `list_card`;
CREATE TABLE `list_card` (
  `id` int(11) NOT NULL,
  `card_id` int(11) DEFAULT NULL,
  `list_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of list_card
-- ----------------------------
INSERT INTO `list_card` VALUES ('1', '1', '1');
INSERT INTO `list_card` VALUES ('2', '2', '1');
INSERT INTO `list_card` VALUES ('3', '3', '2');
INSERT INTO `list_card` VALUES ('4', '4', '2');
INSERT INTO `list_card` VALUES ('5', '5', '3');
INSERT INTO `list_card` VALUES ('6', '6', '3');
INSERT INTO `list_card` VALUES ('7', '7', '3');
INSERT INTO `list_card` VALUES ('8', '8', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `permission_url` varchar(255) DEFAULT NULL,
  `permission_method` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'add', null, null);
INSERT INTO `permission` VALUES ('2', 'delete', null, null);
INSERT INTO `permission` VALUES ('3', 'query', null, null);
INSERT INTO `permission` VALUES ('4', 'update', null, null);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `project_intro` varchar(255) DEFAULT NULL,
  `project_create_date` date DEFAULT NULL,
  `project_start_date` date DEFAULT NULL,
  `project_end_date` date DEFAULT NULL,
  `project_is_archive` int(2) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '1', 'Intro1', '2017-08-31', '2017-10-04', null, null);
INSERT INTO `project` VALUES ('2', '2', 'Intro2', null, null, null, null);
INSERT INTO `project` VALUES ('3', '3', 'Intro3', '2017-09-06', null, null, null);
INSERT INTO `project` VALUES ('4', '4', 'Intro4', null, '2017-09-05', null, null);
INSERT INTO `project` VALUES ('5', '5', 'Intro', '2017-09-05', null, null, null);

-- ----------------------------
-- Table structure for project_board
-- ----------------------------
DROP TABLE IF EXISTS `project_board`;
CREATE TABLE `project_board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `board_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_board
-- ----------------------------
INSERT INTO `project_board` VALUES ('1', '1', '1');
INSERT INTO `project_board` VALUES ('2', '2', '1');
INSERT INTO `project_board` VALUES ('3', '3', '1');
INSERT INTO `project_board` VALUES ('4', '2', '2');
INSERT INTO `project_board` VALUES ('5', '1', '3');
INSERT INTO `project_board` VALUES ('6', '3', '3');
INSERT INTO `project_board` VALUES ('7', '1', '2');
INSERT INTO `project_board` VALUES ('8', '1', '1');
INSERT INTO `project_board` VALUES ('9', '1', '1');
INSERT INTO `project_board` VALUES ('10', '1', '1');
INSERT INTO `project_board` VALUES ('11', '1', '1');
INSERT INTO `project_board` VALUES ('12', '1', '1');
INSERT INTO `project_board` VALUES ('13', '1', '1');

-- ----------------------------
-- Table structure for project_user
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `is_personal` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_user
-- ----------------------------
INSERT INTO `project_user` VALUES ('1', '1', '1', '1');
INSERT INTO `project_user` VALUES ('2', '2', '1', '0');
INSERT INTO `project_user` VALUES ('3', '3', '1', '0');
INSERT INTO `project_user` VALUES ('4', '1', '2', '1');
INSERT INTO `project_user` VALUES ('5', '2', '3', '0');
INSERT INTO `project_user` VALUES ('6', '2', '2', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '3');
INSERT INTO `role` VALUES ('2', 'customer', '2');
INSERT INTO `role` VALUES ('3', '测试3', '31');
INSERT INTO `role` VALUES ('4', 'admin', '2');
INSERT INTO `role` VALUES ('5', 'custom', '1');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `permisson_id` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '1');
INSERT INTO `role_permission` VALUES ('3', '3', '1');
INSERT INTO `role_permission` VALUES ('5', '1', '1');
INSERT INTO `role_permission` VALUES ('6', '2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_sex` int(2) NOT NULL,
  `user_intro` varchar(255) DEFAULT NULL,
  `user_avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'agzou', 'admin', null, '1', 'This is test Update', null);
INSERT INTO `user` VALUES ('2', 'admin', 'admin', null, '1', null, null);
INSERT INTO `user` VALUES ('3', 'agzou', 'admin', null, '0', null, null);
INSERT INTO `user` VALUES ('4', 'admin', 'admin', null, '0', 'This is intro', null);
INSERT INTO `user` VALUES ('5', 'agzou', 'agzou', null, '1', null, null);

-- ----------------------------
-- Table structure for user_friend
-- ----------------------------
DROP TABLE IF EXISTS `user_friend`;
CREATE TABLE `user_friend` (
  `id` int(11) NOT NULL,
  `friend_to` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_friend
-- ----------------------------
INSERT INTO `user_friend` VALUES ('1', '1', '1');
INSERT INTO `user_friend` VALUES ('2', '2', '1');
INSERT INTO `user_friend` VALUES ('3', '3', '2');
INSERT INTO `user_friend` VALUES ('4', '3', '3');
INSERT INTO `user_friend` VALUES ('5', '5', '5');
INSERT INTO `user_friend` VALUES ('6', '4', '4');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '1', '3');
INSERT INTO `user_role` VALUES ('4', '4', '1');
INSERT INTO `user_role` VALUES ('5', '5', '4');
