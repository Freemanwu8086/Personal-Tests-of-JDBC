/*
 Navicat Premium Data Transfer

 Source Server         : wsq
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : java

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 03/01/2021 20:27:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cbook
-- ----------------------------
DROP TABLE IF EXISTS `cbook`;
CREATE TABLE `cbook`  (
  `isbn` char(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `class` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subclass` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `pubdate` date NULL DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`isbn`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cbook
-- ----------------------------
INSERT INTO `cbook` VALUES ('9787302117285', '计算机基础', '计算机文化基础', '计算机基础实用教程', '刘福才', 30, '2009-01-01', '本书由浅入深、循序渐进地介绍了计算机的基础知识。 ');
INSERT INTO `cbook` VALUES ('9787302132899', '计算机网络', 'TCP/IP', '用Spec C作系统设计', '边计年等', 25, '2008-01-01', '全书共分6章。');
INSERT INTO `cbook` VALUES ('9787302148920', '电子信息', '电子信息基础', '电路实验与测量', '徐云', 28, '2008-05-01', '本书由实验知识、电路原理实验和附录三部分组成。');
INSERT INTO `cbook` VALUES ('9787302150039', '电子信息', '电子信息基础', '电子电路的计算机辅助分析与设计方法（第2版）', '杨华中、汪蕙等', 29, '2008-02-01', '本书全面地介绍了计算机辅助电路设计的基本理论和算法。');
INSERT INTO `cbook` VALUES ('9787302151968', '电子信息', '微电子', '微系统设计与制造（清华大学信息科学技术学院教材——微电子光电子系列）', '王喆垚', 59, '2008-02-01', '微系统（MEMS）是一门多学科高度交叉的前沿学科领域');
INSERT INTO `cbook` VALUES ('9787302153580', '计算机', '其他', '信息对抗技术', '粟苹', 46, '2008-03-01', '本书在阐述信息对抗技术基本概念的基础上，重点介绍');
INSERT INTO `cbook` VALUES ('9787302153603', '电子信息', '通信工程', '通信中的同步技术及应用', '季仲梅等', 19, '2008-02-01', '本书在讲述锁相技术的基础上，根据通信领域的新发展');
INSERT INTO `cbook` VALUES ('9787302153795', '电子信息', '光电子', '高档AVR单片机原理及应用', '胡汉才', 49, '2008-02-01', '本书以ATmega系列嵌入式单片机为主线');
INSERT INTO `cbook` VALUES ('9787302154334', '电子信息', '电子信息基础', '数字信号处理及MATLAB实现（第二版）', '余成波、杨菁、杨如民等', 23, '2008-01-01', '本书就数字信号处理的基本理论、算法及MATLAB实现进行系统的论述。');
INSERT INTO `cbook` VALUES ('9787302154549', '图形图像与多媒体', '多媒体', 'Authorware多媒体课件制作实用教程（第二版）', '缪亮、付邦道', 29, '2008-01-01', 'Authorware是美国Macromedia公司推出的、功能强大的多媒体制作软件');
INSERT INTO `cbook` VALUES ('9787302154914', '图形图像与多媒体', '多媒体', '多媒体技术应用（第2版）', '陈洁', 23, '2008-01-01', '本书介绍了多媒体的基本概念和多媒体作品的基本制作技术');
INSERT INTO `cbook` VALUES ('9787302155218', '计算机网络', '计算机网络', '计算机网络实用教程（第二版）', '陈明', 34, '2008-02-01', '本书较详细地介绍了计算机网络原理');
INSERT INTO `cbook` VALUES ('9787302155508', '计算机网络', '计算机网络', 'PHP Web程序设计教程与实验', '徐辉等', 38, '2008-01-01', '本书以PHP 5为主要编程工具，以MySQL 4.1为Web数据库');
INSERT INTO `cbook` VALUES ('9787302156048', '计算机技术及应用', '计算机技术及应用', '计算机应用基础教程（第2版）', '刘旸、纪玉波、李欣', 34, '2008-01-01', '本书是《计算机应用基础教程》的第2版。');
INSERT INTO `cbook` VALUES ('9787302156451', '算法与程序设计', 'Java', 'Java与UML面向对象程序设计教程', '刘晓冬', 32, '2008-01-01', '本书将Java程序设计技术与面向对象思想并重');
INSERT INTO `cbook` VALUES ('9787302156772', '电子信息', '电子信息基础', '电子技术基础', '李洁', 25, '2008-01-01', '为适应计算机的普及和通信技术的广泛应用');
INSERT INTO `cbook` VALUES ('9787302156796', '信息安全', '密码学', '密码学导引：原理与应用', '肖国镇等', 29, '2008-01-01', '随着电子通信的发展，信息安全在实际应用中越来越重要了。');

SET FOREIGN_KEY_CHECKS = 1;
