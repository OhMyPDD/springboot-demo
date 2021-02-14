/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-06 11:29:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(4) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '12');
INSERT INTO `user` VALUES ('2', 'ls', '12');
INSERT INTO `user` VALUES ('3', 'aa', '14');
INSERT INTO `user` VALUES ('4', 'aa', '14');
INSERT INTO `user` VALUES ('5', 'aaaa', '13');
INSERT INTO `user` VALUES ('6', 'aa', '23');
INSERT INTO `user` VALUES ('7', 'aa', '23');
INSERT INTO `user` VALUES ('8', 'aa', '23');
INSERT INTO `user` VALUES ('9', 'aa', '23');
