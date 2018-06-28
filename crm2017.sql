/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50549
Source Host           : 127.0.0.1:3306
Source Database       : crm2017

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2017-10-16 22:19:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendanceexport
-- ----------------------------
DROP TABLE IF EXISTS `attendanceexport`;
CREATE TABLE `attendanceexport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_username` varchar(255) DEFAULT NULL,
  `latedays` int(11) DEFAULT NULL,
  `earlydays` int(11) DEFAULT NULL,
  `attendancedays` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendanceexport
-- ----------------------------

-- ----------------------------
-- Table structure for attendancesheet
-- ----------------------------
DROP TABLE IF EXISTS `attendancesheet`;
CREATE TABLE `attendancesheet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_username` varchar(20) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `signintime` datetime DEFAULT NULL,
  `signouttime` datetime DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `retroactivetime` datetime DEFAULT NULL,
  `latedays` int(11) DEFAULT NULL,
  `earlyleavedays` int(11) DEFAULT NULL,
  `attendancedays` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendancesheet
-- ----------------------------
INSERT INTO `attendancesheet` VALUES ('139', 'admin', '192.168.10.131', '1', '2017-10-14 15:06:58', null, '1', '2017-10-16 20:15:06', '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('140', 'admin', '192.168.10.233', '1', null, '2017-10-15 15:07:01', null, null, '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('141', 'admin', '192.168.10.131', '0', '2017-10-15 15:07:05', null, '1', '2017-10-16 20:15:15', '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('143', 'admin', '192.168.1.1', '0', null, '2017-10-15 19:28:21', null, null, '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('146', 'liudh', '192.168.1.1', '1', '2017-10-15 23:38:21', null, null, null, '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('147', 'admin', '192.168.10.96', '1', '2017-10-16 08:53:00', null, null, null, '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('148', 'liming', '192.168.10.233', '1', '2017-10-16 13:00:28', null, null, null, '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('149', 'admin', '192.168.10.131', '0', null, '2017-10-16 20:15:10', null, null, '0', '0', '0');
INSERT INTO `attendancesheet` VALUES ('150', 'admin', '192.168.10.131', '0', null, '2017-10-16 20:15:27', null, null, '0', '0', '0');

-- ----------------------------
-- Table structure for bigclient
-- ----------------------------
DROP TABLE IF EXISTS `bigclient`;
CREATE TABLE `bigclient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `school` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `abbreviation_one` varchar(255) DEFAULT NULL,
  `abbreviation_two` varchar(255) DEFAULT NULL,
  `marketing_id` bigint(20) DEFAULT NULL,
  `follow_id` bigint(20) DEFAULT NULL,
  `schooltype` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `schoolproperties` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `starlevel` varchar(255) DEFAULT NULL,
  `deptmanage` varchar(255) DEFAULT NULL,
  `eductionalsystme` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postalcode` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `employeenumber` int(11) DEFAULT NULL,
  `teachernumber` int(11) DEFAULT NULL,
  `inschoolnumber` int(11) DEFAULT NULL,
  `ITnumber` int(11) DEFAULT NULL,
  `cooperationschool` bit(1) DEFAULT b'0',
  `signnumber` int(11) DEFAULT NULL,
  `hotspotlevel` varchar(255) DEFAULT NULL,
  `hotspotdescribe` varchar(255) DEFAULT NULL,
  `schoolinfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bigclient
-- ----------------------------
INSERT INTO `bigclient` VALUES ('1', '小码哥', '1', '1', '1', '1', '3', '本科', '高级', '广州', '科技', '2017-10-12', '★★★', '', '', '123', '', '', '', '', '', '', null, null, null, null, '\0', '1', '普通', '', '');
INSERT INTO `bigclient` VALUES ('2', '黑客', '66', '66', '66', '1', '6', '本科', '高级', '广州', '科技', '2017-10-10', '★★★★★', '66', '四年全日制', '9999', '66', '66', '66', '66', '66', '66', '66', '66', '66', '66', '', '66', '普通', '66', '66');

-- ----------------------------
-- Table structure for cat
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cat
-- ----------------------------

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `chargedate` date DEFAULT NULL,
  `chargemoney` decimal(10,0) DEFAULT NULL,
  `classroom_id` bigint(20) DEFAULT NULL,
  `payee_id` bigint(20) DEFAULT NULL,
  `chargetype` bigint(20) DEFAULT NULL,
  `billnumber` varchar(255) DEFAULT NULL,
  `ticket` bit(1) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `marketing_id` bigint(20) DEFAULT NULL,
  `classchange` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge
-- ----------------------------
INSERT INTO `charge` VALUES ('4', '81', '2017-10-06', '55', '1', '1', '138', '99', '', '197', '77', '1', '77');
INSERT INTO `charge` VALUES ('6', null, '2017-06-14', '32316', null, null, null, null, '\0', '197', null, '1', null);
INSERT INTO `charge` VALUES ('7', null, '2017-04-14', '32319', null, null, null, null, '\0', '197', null, '1', null);
INSERT INTO `charge` VALUES ('8', null, '2017-10-14', '3313', null, null, null, null, '\0', '199', null, '2', null);
INSERT INTO `charge` VALUES ('9', null, '2017-06-12', '3316', null, null, null, null, '\0', '199', null, '2', null);
INSERT INTO `charge` VALUES ('10', null, '2017-10-14', '63143', null, null, null, null, '\0', '200', null, '3', null);
INSERT INTO `charge` VALUES ('11', null, '2017-10-14', '63146', null, null, null, null, '\0', '200', null, '3', null);
INSERT INTO `charge` VALUES ('14', '98', '2017-10-16', '10000', '1', '1', null, '86b168d8-e6ee-4051-af1e-b36d781e232a', '\0', null, '', '5', '');
INSERT INTO `charge` VALUES ('15', '96', '2017-10-16', '10000', '6', '1', '143', 'd5879ebe-d4f2-4277-abb9-f70187e2475b', '\0', '197', '', '1', '');

-- ----------------------------
-- Table structure for classcoursemanage
-- ----------------------------
DROP TABLE IF EXISTS `classcoursemanage`;
CREATE TABLE `classcoursemanage` (
  `id` bigint(20) NOT NULL,
  `Classroom_id` bigint(20) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classcoursemanage
-- ----------------------------

-- ----------------------------
-- Table structure for classcoursemanageitem
-- ----------------------------
DROP TABLE IF EXISTS `classcoursemanageitem`;
CREATE TABLE `classcoursemanageitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `weekday` int(11) DEFAULT NULL,
  `room_id` bigint(255) DEFAULT NULL,
  `coursename` varchar(255) DEFAULT NULL,
  `gradeTeacher_id` bigint(20) DEFAULT NULL,
  `courseTeacher_id` bigint(255) DEFAULT NULL,
  `class_id` bigint(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classcoursemanageitem
-- ----------------------------
INSERT INTO `classcoursemanageitem` VALUES ('2', '2017-10-26', '3', '1', 'java课程', '2', '2', '1', '无', '1');
INSERT INTO `classcoursemanageitem` VALUES ('3', '2017-10-11', '2', '1', 'web开发', '3', '2', '3', '', '1');
INSERT INTO `classcoursemanageitem` VALUES ('4', '2017-09-24', '1', '1', 'gg', null, '3', '3', '', '0');
INSERT INTO `classcoursemanageitem` VALUES ('5', '2017-10-05', '0', '1', 'fgff', '2', '2', '3', 'aaa', '0');
INSERT INTO `classcoursemanageitem` VALUES ('6', '2017-10-12', '2', null, '', null, null, null, '', '1');
INSERT INTO `classcoursemanageitem` VALUES ('7', null, '4', null, '', null, null, null, '', '0');
INSERT INTO `classcoursemanageitem` VALUES ('8', null, null, null, 'huh', null, null, null, '', null);
INSERT INTO `classcoursemanageitem` VALUES ('9', '2017-10-04', '2', '2', '', '2', '1', '1', '', '1');
INSERT INTO `classcoursemanageitem` VALUES ('10', '2017-10-07', '2', '3', 'spring', '2', '6', '7', '厉害了', '1');

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `institute_id` bigint(20) DEFAULT NULL,
  `classteacher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES ('1', 'Java班', '4', '2');
INSERT INTO `classroom` VALUES ('3', 'ui班', '4', '1');
INSERT INTO `classroom` VALUES ('4', 'H5班', '2', '2');
INSERT INTO `classroom` VALUES ('5', 'java5班', null, null);
INSERT INTO `classroom` VALUES ('6', 'java1班', '2', '2');
INSERT INTO `classroom` VALUES ('7', 'java2班', '3', null);
INSERT INTO `classroom` VALUES ('8', 'java3班', null, '2');
INSERT INTO `classroom` VALUES ('9', 'java4班', '4', null);
INSERT INTO `classroom` VALUES ('10', 'ui1班', null, null);
INSERT INTO `classroom` VALUES ('11', 'ui2班', '4', null);
INSERT INTO `classroom` VALUES ('12', '思想政治1班', null, null);
INSERT INTO `classroom` VALUES ('13', '思想政治2班', null, null);
INSERT INTO `classroom` VALUES ('14', 'ui班', '4', '3');
INSERT INTO `classroom` VALUES ('15', 'HTML班', '4', '3');
INSERT INTO `classroom` VALUES ('16', 'java2期', '3', '5');
INSERT INTO `classroom` VALUES ('17', 'java3期', '3', '2');

-- ----------------------------
-- Table structure for classroommanage
-- ----------------------------
DROP TABLE IF EXISTS `classroommanage`;
CREATE TABLE `classroommanage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `seatnumber` int(11) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroommanage
-- ----------------------------
INSERT INTO `classroommanage` VALUES ('1', 'A教室', '1201', '299', '1');
INSERT INTO `classroommanage` VALUES ('2', 'A教室', '1202', '333', '0');
INSERT INTO `classroommanage` VALUES ('3', 'A教室', '1203', '60', '0');
INSERT INTO `classroommanage` VALUES ('4', 'B教室', '1204', '40', '0');

-- ----------------------------
-- Table structure for contractmanage
-- ----------------------------
DROP TABLE IF EXISTS `contractmanage`;
CREATE TABLE `contractmanage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contractsn` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `signTime` date DEFAULT NULL,
  `saleman_id` bigint(11) DEFAULT NULL,
  `totalamount` decimal(10,0) DEFAULT NULL,
  `orderamount` decimal(10,0) DEFAULT NULL,
  `accessory` varchar(255) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `updateMan_id` bigint(11) DEFAULT NULL,
  `recentUpdateTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contractmanage
-- ----------------------------
INSERT INTO `contractmanage` VALUES ('1', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '1', '2017-10-25', '1', '1111', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '111', '1', '2017-10-15 11:54:22', '4');
INSERT INTO `contractmanage` VALUES ('2', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '2', '2017-10-17', '2', '11', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '1', '1', '2017-10-15 11:38:12', '3');
INSERT INTO `contractmanage` VALUES ('3', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '1', '2017-10-03', '2', '2222', '2222', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '2', '2', '2017-10-15 11:04:05', '3');
INSERT INTO `contractmanage` VALUES ('4', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '96', '2017-10-03', '1', '2222', '2222', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '2', '1', '2017-10-15 12:04:11', '4');
INSERT INTO `contractmanage` VALUES ('5', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '97', '2017-10-03', '1', '33', '33', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '33', '1', '2017-10-15 13:11:58', '3');
INSERT INTO `contractmanage` VALUES ('6', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '95', '2017-10-03', '1', '11', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '1', '1', '2017-10-16 12:45:50', '4');
INSERT INTO `contractmanage` VALUES ('7', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '96', '2017-10-03', '1', '1111', '1111111111', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '1111111', '1', '2017-10-16 11:57:55', '3');
INSERT INTO `contractmanage` VALUES ('8', 'eb3576e6-deb7-4bf5-99e4-d07eaf4e434f', '97', '2017-10-01', '1', '33', '33', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '33', '1', '2017-10-16 11:58:04', '4');
INSERT INTO `contractmanage` VALUES ('9', '4335a513-2610-4350-b2bc-e97f919d70b1', '1', null, '1', null, null, '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '', '1', '2017-10-15 17:06:55', '4');
INSERT INTO `contractmanage` VALUES ('10', 'af-86b2-8ebae2ab3b1f', '1', '2017-10-12', '1', '11', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '11', null, null, '0');
INSERT INTO `contractmanage` VALUES ('11', 'a5-9bd0-fd1417ab7edf', '2', null, '2', '888', '888', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', null, '2', null, '0');
INSERT INTO `contractmanage` VALUES ('12', 'fe-92ac-e890e57a6fa5', null, null, null, '99', '999', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', null, null, null, '0');
INSERT INTO `contractmanage` VALUES ('13', 'ff-8142-534faf487a90', '2', null, '1', '7777', '77', null, null, null, null, '0');
INSERT INTO `contractmanage` VALUES ('14', 'd5-8fa1-c25313ed244d', '2', '2017-10-03', '1', '1233', '333', null, '123', null, null, '0');
INSERT INTO `contractmanage` VALUES ('15', 'd5879ebe-d4f2-4277-abb9-f70187e2475b', '96', '2017-10-16', null, '15999', '15999', null, null, null, null, '0');

-- ----------------------------
-- Table structure for daymission
-- ----------------------------
DROP TABLE IF EXISTS `daymission`;
CREATE TABLE `daymission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `missiontime` date DEFAULT NULL,
  `executor_id` bigint(20) DEFAULT NULL,
  `missioninfo` varchar(255) DEFAULT NULL,
  `handlerinfo` varchar(255) DEFAULT NULL,
  `missionstatus` tinyint(4) DEFAULT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daymission
-- ----------------------------
INSERT INTO `daymission` VALUES ('1', '2017-10-12', '1', '江海是傻瓜5464654658146143\r\n1436251521463541632514631452310356146415614 同，男婴lK嘿嘿嘿嘿嘿嘿嘿嘿kk', '111', '2', '1');
INSERT INTO `daymission` VALUES ('2', '2017-10-13', '1', 'ss', '江海是个SB', '2', '1');
INSERT INTO `daymission` VALUES ('3', '2017-10-14', '1', '582673678367836786978678', '786748367836+78697689786976+8', '1', '1');
INSERT INTO `daymission` VALUES ('4', '2017-10-10', '2', 'wqewewr', '', '1', '1');
INSERT INTO `daymission` VALUES ('6', '2017-10-05', '5', '85867', '876868', '1', '1');
INSERT INTO `daymission` VALUES ('7', '2017-10-13', '1', 'aadrwrfwfwfrw', '', '1', '1');
INSERT INTO `daymission` VALUES ('8', '2017-10-14', '1', '9+/\r\n/8*9+/*+/6/', '', '0', '1');
INSERT INTO `daymission` VALUES ('9', '2017-10-16', '1', '写代码了', '', '1', '1');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'BOSS', '总经办', '0');
INSERT INTO `department` VALUES ('2', 'PERSONAL', '人事部', '0');
INSERT INTO `department` VALUES ('3', 'MARKET', '市场部', '0');
INSERT INTO `department` VALUES ('4', 'SALE', '营销部', '0');
INSERT INTO `department` VALUES ('5', 'IT', '技术部', '0');
INSERT INTO `department` VALUES ('6', 'PRODUCT', '生产部', '0');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `inputtime` date DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_emp_dept` (`dept_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'admin', '超级管理员', '1', null, '513747165@qq.com', '2017-04-17', '0', '1', '1');
INSERT INTO `employee` VALUES ('2', 'liudh', '刘德华', '1', '13088888888', 'liudh3@520it.com', '2017-04-17', '0', '0', '2');
INSERT INTO `employee` VALUES ('3', 'zhangxy', '张学友', '1', '13088888887', 'liudh4@520it.com', '2017-04-17', '0', '0', '3');
INSERT INTO `employee` VALUES ('5', 'liming', '黎明', '1', '13088888886', 'liming9@520it.com', '2017-04-19', '0', '0', '4');
INSERT INTO `employee` VALUES ('6', 'guofc', '郭富城', '1', '13088888885', 'guofc@520it.com', '2017-06-21', '1', '0', '4');
INSERT INTO `employee` VALUES ('7', 'zhangly', '张靓颖', '67dea3d209721d1e5e15a63b4a112ec5', '13764457766', '1019663234@qq.com', '2017-10-16', '0', '0', '2');

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role` (
  `employee_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_role
-- ----------------------------
INSERT INTO `employee_role` VALUES ('2', '3');
INSERT INTO `employee_role` VALUES ('3', '4');
INSERT INTO `employee_role` VALUES ('4', '4');
INSERT INTO `employee_role` VALUES ('7', '2');

-- ----------------------------
-- Table structure for exammanage
-- ----------------------------
DROP TABLE IF EXISTS `exammanage`;
CREATE TABLE `exammanage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `examtime` datetime DEFAULT NULL,
  `examresult` varchar(255) DEFAULT NULL,
  `examremark` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exammanage
-- ----------------------------
INSERT INTO `exammanage` VALUES ('24', '007', 'java升班考试', '82', '2017-10-23 00:00:00', '80', 'remark', '1');
INSERT INTO `exammanage` VALUES ('25', '002', 'java15⑦', '80', '2017-10-02 00:00:00', '56', '002', '1');
INSERT INTO `exammanage` VALUES ('26', '0045', 'java升班考试', '89', '2017-10-19 00:00:00', '20', '12412', '1');
INSERT INTO `exammanage` VALUES ('27', '522144', 'java升班考试', '97', '2017-10-24 00:00:00', null, '二狗个', '1');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` bigint(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `before_id` bigint(20) DEFAULT NULL,
  `after_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `before_id` (`before_id`) USING BTREE,
  KEY `after_id` (`after_id`) USING BTREE,
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`before_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`after_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('12', '85', '2017-10-14 18:43:06', '5555', '3', '3');
INSERT INTO `history` VALUES ('13', '82', '2017-10-14 22:24:40', '', '3', '3');
INSERT INTO `history` VALUES ('14', '85', '2017-10-14 22:34:13', '', '3', '3');

-- ----------------------------
-- Table structure for institute
-- ----------------------------
DROP TABLE IF EXISTS `institute`;
CREATE TABLE `institute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of institute
-- ----------------------------
INSERT INTO `institute` VALUES ('3', 'JAVA', 'Java学院');
INSERT INTO `institute` VALUES ('4', 'UI', 'ui学院');
INSERT INTO `institute` VALUES ('5', 'SHEN', 'SHEN学院');

-- ----------------------------
-- Table structure for linkman
-- ----------------------------
DROP TABLE IF EXISTS `linkman`;
CREATE TABLE `linkman` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `school_id` bigint(20) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `call` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `linkmanstatus_id` bigint(20) DEFAULT NULL,
  `main` bit(1) DEFAULT NULL,
  `institute` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linkman
-- ----------------------------
INSERT INTO `linkman` VALUES ('1', '小明', '112', '22', '22', '22', '22', '22', '118', '\0', '22', '22', '0', '2017-10-11', '22', null);
INSERT INTO `linkman` VALUES ('2', '小红', '112', '院长', '', '46473', '9867', '6879@qq.com', '118', '', '艺术学院', '', null, null, '', null);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `opuser_id` bigint(20) DEFAULT NULL,
  `optime` datetime DEFAULT NULL,
  `opip` varchar(255) DEFAULT NULL,
  `function` varchar(5000) DEFAULT NULL,
  `params` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `opuser_id` (`opuser_id`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`opuser_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115899 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('115882', '1', '2017-09-28 20:22:22', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115883', '1', '2017-09-28 21:17:31', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115884', '1', '2017-09-28 21:19:10', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115885', '1', '2017-09-29 10:46:54', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115886', '1', '2017-09-29 10:51:32', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115887', '1', '2017-09-29 10:51:34', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115888', '1', '2017-09-29 10:51:34', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115889', '1', '2017-09-29 10:52:08', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115890', '1', '2017-09-29 10:52:10', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115891', '1', '2017-09-29 10:52:11', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115892', '1', '2017-09-29 10:52:12', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115893', '1', '2017-09-29 10:52:30', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115894', '1', '2017-09-29 10:52:31', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115895', '1', '2017-09-29 10:52:32', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115896', '1', '2017-09-29 17:25:52', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115897', '1', '2017-09-29 17:28:28', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');
INSERT INTO `log` VALUES ('115898', '1', '2017-09-29 21:06:35', '127.0.0.1', 'EmployeeServiceImpl', '[{\"page\":1,\"rows\":10,\"keyword\":null,\"currentId\":null,\"start\":0}]');

-- ----------------------------
-- Table structure for mydate
-- ----------------------------
DROP TABLE IF EXISTS `mydate`;
CREATE TABLE `mydate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `allDay` bit(1) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mydate
-- ----------------------------
INSERT INTO `mydate` VALUES ('5', '5888', '2017-10-10 00:00:00', null, '', '\0', '', null);
INSERT INTO `mydate` VALUES ('6', '7777777777', '2017-10-10 00:00:00', null, '', '\0', null, null);
INSERT INTO `mydate` VALUES ('7', '777444444', '2017-10-10 00:00:00', '2017-10-06 12:16:00', '', '\0', '', null);
INSERT INTO `mydate` VALUES ('8', '86978896', '2017-10-17 00:00:00', '2017-10-18 12:25:00', '', '\0', '绿色', null);
INSERT INTO `mydate` VALUES ('11', '88787', '2017-10-10 00:00:00', null, '', '\0', '', null);
INSERT INTO `mydate` VALUES ('12', '787654656', '2017-10-10 00:00:00', '2017-10-27 12:33:00', '', '\0', '#FF0000', null);
INSERT INTO `mydate` VALUES ('13', '78368', '2017-10-10 00:00:00', '2017-10-19 12:33:00', '', '\0', '#FF69B4', null);
INSERT INTO `mydate` VALUES ('14', '453', '2017-10-10 00:00:00', '2017-10-18 12:33:00', '', '\0', '', null);
INSERT INTO `mydate` VALUES ('15', '8888', '2017-10-10 00:00:00', '2017-10-20 12:51:00', '', '\0', '#0000FF', null);
INSERT INTO `mydate` VALUES ('16', '88//', '2017-10-17 00:00:00', '2017-10-19 12:51:00', '', '\0', '', null);
INSERT INTO `mydate` VALUES ('19', '玩游戏', '2017-10-03 00:00:00', '2017-10-03 23:36:00', '', '\0', '#FF0000', '2');
INSERT INTO `mydate` VALUES ('21', 'ddsafaw', '2017-10-03 00:00:00', '2017-10-04 16:22:00', '', '\0', '', '1');
INSERT INTO `mydate` VALUES ('22', '打游戏', '2017-10-09 00:00:00', '2017-10-09 23:05:00', '', '\0', '#008000', '1');

-- ----------------------------
-- Table structure for netdisc
-- ----------------------------
DROP TABLE IF EXISTS `netdisc`;
CREATE TABLE `netdisc` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `typeid` bigint(20) DEFAULT NULL,
  `uploadtime` date DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `share` tinyint(4) DEFAULT NULL,
  `parentid` bigint(20) DEFAULT NULL,
  `sharetime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of netdisc
-- ----------------------------
INSERT INTO `netdisc` VALUES ('104', 'Smile. DK - Dragonfly.mp3', '8425450', '6', '2017-10-09', '1', '0', '110', null);
INSERT INTO `netdisc` VALUES ('110', '9999', null, '1', '2017-10-10', '1', '0', null, null);
INSERT INTO `netdisc` VALUES ('117', '环保小视频.mp4', '8401009', '7', '2017-10-10', '1', '1', '110', '2017-10-14');
INSERT INTO `netdisc` VALUES ('118', 'Snipaste_2017-10-16_20-38-38.png', '44186', '2', '2017-10-16', '1', '0', null, null);

-- ----------------------------
-- Table structure for orderbill
-- ----------------------------
DROP TABLE IF EXISTS `orderbill`;
CREATE TABLE `orderbill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` bigint(20) DEFAULT NULL,
  `signTime` date DEFAULT NULL,
  `saleman_id` bigint(11) DEFAULT NULL,
  `totalamount` decimal(10,0) DEFAULT NULL,
  `orderamount` decimal(10,0) DEFAULT NULL,
  `accessory` varchar(255) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `updateMan_id` bigint(11) DEFAULT NULL,
  `recentUpdateTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderbill
-- ----------------------------
INSERT INTO `orderbill` VALUES ('1', '1', '2017-10-25', '1', '1111', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '111', '1', '2017-10-15 11:54:22', '4');
INSERT INTO `orderbill` VALUES ('2', '2', '2017-10-17', '2', '11', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '1', '1', '2017-10-15 11:38:12', '3');
INSERT INTO `orderbill` VALUES ('3', '1', '2017-10-03', '2', '2222', '2222', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '2', '2', '2017-10-15 11:04:05', '3');
INSERT INTO `orderbill` VALUES ('4', '2', '2017-10-03', '1', '2222', '2222', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '2', '1', '2017-10-15 12:04:11', '4');
INSERT INTO `orderbill` VALUES ('5', '89', '2017-10-03', '1', '33', '33', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '33', '1', '2017-10-15 13:11:58', '3');
INSERT INTO `orderbill` VALUES ('6', '95', '2017-10-03', '1', '11', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '1', '1', '2017-10-16 11:54:24', '2');
INSERT INTO `orderbill` VALUES ('7', '96', '2017-10-03', '1', '1111', '1111111111', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '1111111', '1', '2017-10-15 13:15:10', '2');
INSERT INTO `orderbill` VALUES ('8', '95', '2017-10-11', '1', '123', '45', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '444', '1', '2017-10-16 18:29:17', '1');
INSERT INTO `orderbill` VALUES ('9', '1', '2017-10-16', '1', '888', '888', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '888', '1', '2017-10-16 19:24:13', '3');
INSERT INTO `orderbill` VALUES ('10', '97', '2017-10-17', '1', '99', '999', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '999', '1', '2017-10-16 19:36:19', '3');
INSERT INTO `orderbill` VALUES ('11', '98', '2017-10-18', '1', '7777', '77', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '777', '1', '2017-10-16 20:03:16', '3');
INSERT INTO `orderbill` VALUES ('12', '1', '2017-10-17', '1', '444', '44', '/upload/4a354279-6e55-436e-8271-7d4cb382bd29.txt', '44', null, null, '0');
INSERT INTO `orderbill` VALUES ('13', '1', '2017-10-19', '1', '33', '33', '/upload/c9d7d0d2-d7c7-4555-960a-7dc04ab035b9.txt', '33', null, null, '0');
INSERT INTO `orderbill` VALUES ('14', '2', '2017-10-11', '1', '22', '22', '/static/upload/ad67d827-7550-4d4a-bc6b-19ae8bd1a151.png', '', null, null, '0');
INSERT INTO `orderbill` VALUES ('15', '2', '2017-10-19', '1', '11', '11', '/static/upload/0330c9ef-9037-4422-8e97-c00d82d316af.png', '11', null, null, '0');

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paydate` date DEFAULT NULL,
  `paymoney` decimal(10,0) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `cashier_id` bigint(20) DEFAULT NULL,
  `brokerage_id` bigint(20) DEFAULT NULL,
  `paymode_id` bigint(20) DEFAULT NULL,
  `paytype_id` bigint(20) DEFAULT NULL,
  `paysmall_id` bigint(20) DEFAULT NULL,
  `billnumber` varchar(255) DEFAULT NULL,
  `sharecost` decimal(10,0) DEFAULT NULL,
  `sharetype_id` bigint(20) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `auditstatus` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES ('2', '2017-10-05', '88', '88', '1', '1', '139', '114', '115', '88', '88', '116', '117', '0');
INSERT INTO `pay` VALUES ('3', '2017-10-06', '777', '777', '1', '2', '139', '114', '115', '777', '777', '116', '197', '0');
INSERT INTO `pay` VALUES ('4', '2016-09-06', '1000', '', '2', '2', '139', null, null, '', null, null, null, '0');
INSERT INTO `pay` VALUES ('5', '2017-11-14', '222', '', '2', null, '139', null, null, '', null, null, null, '1');
INSERT INTO `pay` VALUES ('6', '2019-03-18', '10003', null, '1', null, '139', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('7', '2017-06-13', '10006', null, '1', null, '139', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('8', '2017-04-11', '10009', null, '1', null, '139', null, null, null, null, null, null, '1');
INSERT INTO `pay` VALUES ('9', '2017-04-13', '10003', null, '2', null, '139', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('10', '2017-04-13', '10006', null, '2', null, '139', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('13', '2015-07-13', '10003', null, '2', null, '139', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('14', '2016-03-13', '10006', null, '2', null, '139', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('15', '2016-10-04', '10009', null, '2', null, '139', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('16', '2017-10-13', '3003', null, '3', null, '138', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('17', '2017-10-13', '3006', null, '3', null, '138', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('18', '2017-10-13', '3009', null, '3', null, '138', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('19', '2017-10-13', '3233', null, '6', null, '138', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('20', '2017-10-13', '3236', null, '6', null, '138', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('21', '2017-10-13', '3239', null, '6', null, '138', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('22', '2017-10-13', '3233', null, '5', null, '140', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('23', '2017-10-13', '3236', null, '5', null, '140', null, null, null, null, null, null, '0');
INSERT INTO `pay` VALUES ('24', '2017-10-13', '3239', null, '5', null, '140', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `resource` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('5', '员工数据', 'employee:list');
INSERT INTO `permission` VALUES ('6', '员工新增', 'employee:save');
INSERT INTO `permission` VALUES ('7', '员工列表', 'employee:index');
INSERT INTO `permission` VALUES ('8', '员工更新', 'employee:update');
INSERT INTO `permission` VALUES ('9', '员工离职', 'employee:quit');

-- ----------------------------
-- Table structure for potentialcustom
-- ----------------------------
DROP TABLE IF EXISTS `potentialcustom`;
CREATE TABLE `potentialcustom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `weChat` varchar(255) DEFAULT NULL COMMENT '微信号',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `buildFileTime` datetime DEFAULT NULL COMMENT '建档日期',
  `inputTime` datetime DEFAULT NULL COMMENT '录入时间',
  `vistitTime` datetime DEFAULT NULL COMMENT '约访时间',
  `education_id` bigint(20) DEFAULT NULL COMMENT '学历',
  `workYear_id` bigint(20) DEFAULT NULL COMMENT '工作年限',
  `intentionClass_id` bigint(20) DEFAULT NULL COMMENT '意向班级',
  `clientType_id` bigint(20) DEFAULT NULL COMMENT '客户类型',
  `collegeEnrolTime` datetime DEFAULT NULL COMMENT '大学入学时间',
  `intentionSubject_id` bigint(20) DEFAULT NULL COMMENT '意向学科',
  `careQuestion` varchar(255) DEFAULT NULL COMMENT '关注问题',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `marketingMan_id` bigint(20) DEFAULT NULL COMMENT '营销人员',
  `intentionSchoolRegion_id` bigint(20) DEFAULT NULL COMMENT '意向校区',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源',
  `qq` varchar(255) DEFAULT NULL,
  `gender` varchar(11) DEFAULT NULL COMMENT '性别',
  `schoolOrTrainOrganization` varchar(255) DEFAULT NULL COMMENT '学校或培训机构',
  `profession` varchar(255) DEFAULT NULL COMMENT '专业',
  `intentionLevel_id` bigint(20) DEFAULT NULL COMMENT '意向程度',
  `otherMarketingMan_id` bigint(20) DEFAULT NULL COMMENT '其他营销人员',
  `collegeClass` varchar(255) DEFAULT NULL COMMENT '大学班级',
  `inputMan_id` bigint(20) DEFAULT NULL COMMENT '录入人',
  `nextFollowUpTime` datetime DEFAULT NULL COMMENT '下次跟进时间',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT 'Email',
  `schoolClient_id` bigint(20) DEFAULT NULL COMMENT '学校客户',
  `region_id` bigint(20) DEFAULT NULL COMMENT '地域',
  `introducer` varchar(255) DEFAULT NULL COMMENT '介绍人',
  `currentState_id` bigint(20) DEFAULT NULL COMMENT '当前状态',
  `bringComputer` tinyint(1) DEFAULT NULL COMMENT '携带笔记本电脑',
  `zeroPay` tinyint(1) DEFAULT NULL COMMENT '零付款',
  `collegeEnglishTest_id` bigint(20) DEFAULT NULL COMMENT '外语水平',
  `payWay_id` bigint(20) DEFAULT NULL COMMENT '付款方式',
  `currentHouseAddress` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `familyAddress` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `registeredAddress` varchar(255) DEFAULT NULL COMMENT '户口所在地',
  `otherLevel` varchar(255) DEFAULT NULL COMMENT '其他水平',
  `trainStartTime` datetime DEFAULT NULL COMMENT '入学时间',
  `selectClass_id` bigint(20) DEFAULT NULL COMMENT '选择班级',
  `planTuition` decimal(10,0) DEFAULT NULL COMMENT '计划学费',
  `trainTuition` decimal(10,0) DEFAULT NULL COMMENT '培训学费',
  `discountInstruction` varchar(255) DEFAULT NULL COMMENT '优惠说明',
  `defraiedTuition` decimal(10,0) DEFAULT NULL COMMENT '已付学费',
  `previousUrgeTime` datetime DEFAULT NULL COMMENT '上次催款时间',
  `completePay` tinyint(1) DEFAULT NULL COMMENT '完成付款',
  `discountWay_id` bigint(20) DEFAULT NULL COMMENT '优惠方式',
  `otherTuition` decimal(10,0) DEFAULT NULL COMMENT '其他费用',
  `totalTuition` decimal(10,0) DEFAULT NULL COMMENT '总费用',
  `dueTuition` decimal(10,0) DEFAULT NULL COMMENT '还欠学费',
  `nextUrgeTime` datetime DEFAULT NULL COMMENT '下次催款时间',
  `discountAmount` decimal(10,0) DEFAULT NULL COMMENT '优惠金额',
  `otherDiscount` decimal(10,0) DEFAULT NULL COMMENT '其他优惠',
  `marketStream` varchar(20) DEFAULT NULL COMMENT '销售流水',
  `finalPayTime` datetime DEFAULT NULL COMMENT '最后付款时间',
  `urgePayTimes` int(11) DEFAULT NULL COMMENT '催款次数',
  `headPortrait` varchar(255) DEFAULT NULL COMMENT '照片',
  `idCardNumber` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `urgentLinkMan` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `urgentTelephone` varchar(255) DEFAULT NULL COMMENT '紧急电话',
  `idCardCopies` varchar(255) DEFAULT NULL COMMENT '身份证复印件',
  `degreeCertificateCopies` varchar(255) DEFAULT NULL COMMENT '学位证复印件',
  `workExperience` varchar(255) DEFAULT NULL COMMENT '工作经历',
  `currentclass_id` bigint(20) DEFAULT NULL COMMENT '当前班级',
  `beforeclass_id` bigint(20) DEFAULT NULL COMMENT '以前班级',
  `flowclass_id` bigint(20) DEFAULT NULL COMMENT '流入班级',
  `studentState_id` bigint(20) DEFAULT NULL COMMENT '状态 正式学员/非正式学员',
  `paystate_id` bigint(20) DEFAULT NULL COMMENT '缴费状态',
  `enroltime` datetime DEFAULT NULL COMMENT '入学时间',
  `inform` int(11) DEFAULT '0' COMMENT '通知',
  `losstime` datetime DEFAULT NULL COMMENT '流失时间',
  `fatalisminschool` bigint(20) DEFAULT NULL COMMENT '上课天数',
  `lossstage` varchar(255) DEFAULT NULL COMMENT '流失阶段',
  `losscause` varchar(255) DEFAULT NULL COMMENT '流失原因',
  `handlerPerson_id` bigint(20) DEFAULT NULL COMMENT '经办人',
  `refundment` tinyint(1) DEFAULT NULL COMMENT '退款',
  PRIMARY KEY (`id`),
  KEY `marketingMan_id` (`marketingMan_id`),
  CONSTRAINT `potentialcustom_ibfk_1` FOREIGN KEY (`marketingMan_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of potentialcustom
-- ----------------------------
INSERT INTO `potentialcustom` VALUES ('81', '宿舍', null, '', null, '2017-10-11 22:42:30', '2017-10-11 22:42:30', null, '110', '146', '3', '127', null, '154', '', '', null, '98', '187', '', '', '', '', '123', null, null, '1', null, '', '', null, '116', '', null, '1', '1', null, null, '', '', '', null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, '2', '2', null, '1', null, null, '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('82', '所示', '33', '33', null, '2017-09-25 10:18:46', '2017-10-12 00:00:00', '2017-10-03 00:00:00', '110', '146', '1', '127', null, '154', '', 'sdsdsdsdsd', '3', '99', '188', '11', '男', '33', '把妹', '120', '2', null, '2', '2017-10-04 00:00:00', '11', 'ssss', null, '117', '龙哥', '129', '1', '1', null, null, '', '', '', null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, '2', '2', null, '5', null, '2017-10-11 00:00:00', '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('85', '迭代', '45', '123456', null, '2017-10-14 11:22:03', '2017-10-14 11:22:03', '2017-10-11 00:00:00', '110', '148', '2', '127', null, '153', '', '', '3', '98', '188', '456789', '0', 'maomoa', '把妹', '121', '2', null, '1', '2017-10-05 00:00:00', '15550201535', 'maomao@mao.com', '2', '114', '', '133', '0', '1', '150', '153', '棠下好又多', '棠下大片路', '新疆乌鲁木齐', null, '2017-10-09 00:00:00', null, '15999', null, '帅', '15200', '2017-10-03 00:00:00', '0', '158', '500', '15999', '799', '2017-10-24 00:00:00', '200', '500', '2017-02-15-00012', null, '5', null, null, null, null, null, null, null, '4', '3', null, '3', '170', '2017-10-15 00:00:00', '1', '2017-10-15 17:15:16', '150', '二月', '泡妹', null, '1');
INSERT INTO `potentialcustom` VALUES ('86', '方法', null, 'wei123456', null, null, '2017-10-14 00:00:00', '2017-10-11 00:00:00', '112', '148', '2', '128', null, '153', '女孩子多不多,漂亮不', '我看是不太想去了', '3', '100', '191', '123456', '女', 'seemygo', '搞基', '121', '3', null, null, '2017-10-11 00:00:00', '132', null, '2', '114', '华哥', '131', '0', '1', null, null, '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, '1', '4', null, '2', '169', '2017-10-04 00:00:00', '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('87', '张磊', null, 'zhanglei123', null, '2017-10-15 11:19:17', '2017-10-15 11:19:17', '2017-10-04 00:00:00', '112', '148', '1', '127', null, '153', '女孩子多不多啊', '多啊', '3', '97', '187', '11114445212', '男', '皇家小码哥', '印钞票', '122', '3', null, '1', '2017-10-12 00:00:00', '112563445', '', '2', '115', '龙18', '131', '1', '1', '150', '152', '躺下好又多', '棠下大片路猪脚饭', '西藏阿里地区', null, null, null, null, null, '', null, '2017-10-24 00:00:00', null, null, '5000', '15000', null, '2017-10-17 00:00:00', '4511', '5601', '1511322332', null, null, null, null, null, null, null, null, null, '3', '4', null, '2', '169', '2017-10-04 00:00:00', '0', '2017-10-17 17:18:37', null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('88', '', null, '', null, '2017-10-15 11:33:16', '2017-10-15 11:33:16', null, '112', '148', null, '127', null, '152', '', '', null, null, '192', '', '', '', '', null, null, null, '1', null, '', '', null, null, '', null, null, null, '149', '153', '', '', '', null, null, null, null, null, '', null, null, null, '158', null, null, null, null, null, null, '', null, '5', null, null, null, null, null, null, null, null, null, null, '1', '169', null, '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('89', '杨威', '42', 'yangwei123', null, '2017-10-16 09:01:40', '2017-10-16 09:01:40', '2017-10-11 00:00:00', '109', '146', '4', '127', null, '152', '吃什么东西', '回国肉', '3', '99', '192', '123456', '男', '小码哥', 'java', '123', '3', null, '1', '2017-10-12 00:00:00', '123456', '21ssdd@qq.com', '2', '117', '毛毛', '160', '1', '1', '150', '154', '天河小码哥', '深圳盐田口岸', '广州深圳', null, '2017-10-18 00:00:00', null, '29000', null, '无', '16009', '2017-10-03 00:00:00', '0', '159', '0', '15999', '-10', '2017-10-02 00:00:00', '0', '0', '', null, '2', null, null, null, null, null, null, null, null, null, null, '1', '168', '2017-10-18 00:00:00', '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('91', 'lala', '21', '121334', null, null, '2017-10-16 00:00:00', '2017-10-17 00:00:00', '183', '150', '9', '165', null, '152', '管饭吗?', '', '3', '193', '192', '454242', '男', '小码哥', 'ios', '172', '3', null, null, '2017-10-17 00:00:00', '234543', '513747165@qq.com', '1', '174', '123', '161', '0', '1', null, null, '', '', '', null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2017-10-01 00:00:00', '1', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('92', '123', null, '', null, null, '2017-10-16 00:00:00', null, '179', '149', null, '167', null, '152', '', '', '3', null, '190', '', '', '', '', null, null, null, null, null, '', '', null, null, '', null, null, '1', null, null, '', '', '', null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('94', '德华大哥', '25', 'sds4546', 'adinmnh', '2017-10-16 15:52:03', '2017-10-16 15:52:03', '2017-10-05 00:00:00', '179', '149', '1', '167', null, '152', '生生死死', '生生死死', '3', '194', '190', '13246546', '男', '小码哥', '歌唱', '169', '3', null, '1', '2017-10-05 00:00:00', '11245265', '15455ssd', '2', '173', 'intro', '162', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, '2017-10-24 00:00:00', '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('95', '张三', '12', '14325', '北京市西单', null, '2017-10-16 00:00:00', '2017-10-17 00:00:00', '181', '150', '1', '166', null, '152', '管饭吗?', '我填的', '3', '194', '188', '234523', '男', '小马哥', '语文', '171', '3', null, null, '2017-10-17 00:00:00', '12425441', '123@qq.com', '2', '173', 'zhang', '160', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, '2017-10-04 00:00:00', '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('96', '老毛', '32', '2324', null, '2017-10-16 15:56:36', '2017-10-16 15:56:36', '2017-10-18 00:00:00', '179', '151', '3', '165', null, '153', '管吃管住', '威哥录入', '3', '194', '188', '4235', '0', '小牛哥', '数学', '170', '3', null, '1', '2017-10-18 00:00:00', '45366', '12568@qq.com', '1', '175', '123', '162', '1', '0', '148', '143', '天河区小码哥', '天河区小码哥', '天河区小码哥', null, '2017-10-10 00:00:00', null, '15999', '15999', '15999', '10000', '2017-10-18 00:00:00', '1', '137', '0', '15999', '5999', '2017-10-23 00:00:00', '0', '0', '201457', null, '2', null, null, null, null, null, null, null, null, null, null, '1', null, '2017-10-01 00:00:00', '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('97', '李二狗', '80', '124684', null, '2017-10-16 16:00:03', '2017-10-16 16:00:03', '2017-10-17 00:00:00', '182', '150', '4', '167', null, '156', '吃饭', '路上捡的', '3', '193', '191', '7889967', '女', '日语学校', '日语', '169', '3', null, '1', '2017-10-17 00:00:00', '5554523', '7988567@163.com', '1', '174', 'amao', '160', '1', '1', '147', '143', '天河小码哥', '天河小码哥', '天河小码哥', null, '2017-10-04 00:00:00', null, '15999', '15999', '无', '10000', '2017-10-18 00:00:00', '0', '137', '0', '15999', '5999', '2017-10-18 00:00:00', '0', '0', '2017-2-25', null, '3', null, null, null, null, null, null, null, null, null, null, '1', null, '2016-02-09 00:00:00', '0', null, null, null, null, null, null);
INSERT INTO `potentialcustom` VALUES ('98', '奔波儿灞', '90', '777', null, '2017-10-16 16:03:25', '2017-10-16 16:03:25', '2017-10-20 00:00:00', '183', '151', '1', '166', null, '152', '飞机接送', '王思聪干爹', '3', '196', '191', '868687', '0', '协和', '土木', '172', '3', null, '1', '2017-10-20 00:00:00', '978988', '3547@qq.com', '1', '178', '我', '163', '1', '0', '147', '143', '天河小裤衩', '天河躺下', '安徽安庆⑩', null, '2017-10-10 00:00:00', null, '15999', '15999', '无', '10000', '2017-10-24 00:00:00', '0', '134', '0', '15999', '5999', '2017-10-04 00:00:00', '0', '0', '2012-17*25', null, '3', null, null, null, null, null, null, null, null, null, null, '0', null, '2015-11-26 00:00:00', '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', 'HR', '人事专员');
INSERT INTO `role` VALUES ('3', 'MARKETMAN', '市场专员');
INSERT INTO `role` VALUES ('4', 'SALEMAN', '销售专员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('3', '2');
INSERT INTO `role_menu` VALUES ('3', '7');
INSERT INTO `role_menu` VALUES ('3', '26');
INSERT INTO `role_menu` VALUES ('3', '27');
INSERT INTO `role_menu` VALUES ('3', '28');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('2', '5');
INSERT INTO `role_permission` VALUES ('2', '6');
INSERT INTO `role_permission` VALUES ('2', '7');
INSERT INTO `role_permission` VALUES ('2', '8');
INSERT INTO `role_permission` VALUES ('2', '9');
INSERT INTO `role_permission` VALUES ('3', '5');
INSERT INTO `role_permission` VALUES ('3', '6');
INSERT INTO `role_permission` VALUES ('3', '7');
INSERT INTO `role_permission` VALUES ('3', '8');
INSERT INTO `role_permission` VALUES ('3', '9');

-- ----------------------------
-- Table structure for salechart
-- ----------------------------
DROP TABLE IF EXISTS `salechart`;
CREATE TABLE `salechart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `saleDate` datetime DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `username_id` bigint(20) DEFAULT NULL,
  `saleAmount` decimal(10,0) DEFAULT NULL,
  `livesubsidy` decimal(10,0) DEFAULT NULL,
  `workday` int(11) DEFAULT NULL,
  `totalworkday` int(11) DEFAULT NULL,
  `socialsecurity` decimal(10,0) DEFAULT NULL,
  `actualsalary` decimal(10,0) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `salesman_id` (`username_id`) USING BTREE,
  KEY `dept_id` (`dept_id`) USING BTREE,
  CONSTRAINT `salechart_ibfk_1` FOREIGN KEY (`username_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `salechart_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salechart
-- ----------------------------
INSERT INTO `salechart` VALUES ('10', '2017-10-14 00:00:00', '3', '2', '1000', '1000', '10', '10', '1000', '1000', 'ff');
INSERT INTO `salechart` VALUES ('11', '2017-10-16 17:13:49', '3', '2', '2000', '2200', '20', '20', '2200', '2200', null);

-- ----------------------------
-- Table structure for systemdictionary
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionary`;
CREATE TABLE `systemdictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemdictionary
-- ----------------------------
INSERT INTO `systemdictionary` VALUES ('12', 'sdfa', 'sadf', 'sadf');
INSERT INTO `systemdictionary` VALUES ('13', 'jjj', 'jjj', 'jjj');
INSERT INTO `systemdictionary` VALUES ('26', 'dd', 'dd', 'dd');
INSERT INTO `systemdictionary` VALUES ('27', 'tt', 'tt', 'tt');
INSERT INTO `systemdictionary` VALUES ('28', '天天', '天天', '天天');
INSERT INTO `systemdictionary` VALUES ('29', '天天', '影院', '一样');
INSERT INTO `systemdictionary` VALUES ('30', '55', '55', '55');
INSERT INTO `systemdictionary` VALUES ('31', 'school', '学校', '111');
INSERT INTO `systemdictionary` VALUES ('32', 'payMode', '支出方式', '花钱');
INSERT INTO `systemdictionary` VALUES ('33', 'payType', '支出类型', '一样花钱');
INSERT INTO `systemdictionary` VALUES ('34', 'paySmall', '小类', '...');
INSERT INTO `systemdictionary` VALUES ('35', 'shareType', '共享类型', 'AA制');
INSERT INTO `systemdictionary` VALUES ('36', 'subject', '学科', '学习吧少年');
INSERT INTO `systemdictionary` VALUES ('37', 'linkmanStatus', '联系人状态', '状态');
INSERT INTO `systemdictionary` VALUES ('38', 'schoolType', '学校类型', '随便填');
INSERT INTO `systemdictionary` VALUES ('39', 'education', '学历', '');
INSERT INTO `systemdictionary` VALUES ('40', 'region', '地域', '');
INSERT INTO `systemdictionary` VALUES ('41', 'schoolProperties', '办学性质', '');
INSERT INTO `systemdictionary` VALUES ('42', 'eductionalsystme', '学制', '');
INSERT INTO `systemdictionary` VALUES ('43', 'hotspotLevel', '热点等级', '');
INSERT INTO `systemdictionary` VALUES ('45', 'src', '信息来源', '');
INSERT INTO `systemdictionary` VALUES ('46', 'gender', '性别', '');
INSERT INTO `systemdictionary` VALUES ('47', 'educationRecord', '学历', '');
INSERT INTO `systemdictionary` VALUES ('48', 'area', '地域', '');
INSERT INTO `systemdictionary` VALUES ('49', 'intentionGrade', '意向程度', '');
INSERT INTO `systemdictionary` VALUES ('50', 'clientType', '客户类型', '');
INSERT INTO `systemdictionary` VALUES ('51', 'currentStatu', '当前的状态', '');
INSERT INTO `systemdictionary` VALUES ('52', 'takePc', '是否携带电脑', '');
INSERT INTO `systemdictionary` VALUES ('53', 'intentionMajor', '意向学科', '');
INSERT INTO `systemdictionary` VALUES ('54', 'workYear', '工作年限', '');
INSERT INTO `systemdictionary` VALUES ('55', 'collegeEnglishTest', '学生外语水平', '');
INSERT INTO `systemdictionary` VALUES ('56', 'payWay', '付款方式', '');
INSERT INTO `systemdictionary` VALUES ('57', 'discountWay', '优惠的方式', '');
INSERT INTO `systemdictionary` VALUES ('58', 'talkType', '交流方式', '');
INSERT INTO `systemdictionary` VALUES ('59', 'intentionSchoolRegion', '意向校区', '');

-- ----------------------------
-- Table structure for systemdictionaryitem
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionaryitem`;
CREATE TABLE `systemdictionaryitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemdictionaryitem
-- ----------------------------
INSERT INTO `systemdictionaryitem` VALUES ('11', '11', '22', '22');
INSERT INTO `systemdictionaryitem` VALUES ('22', '14', 'sdfsd', 'asdf');
INSERT INTO `systemdictionaryitem` VALUES ('23', '14', 'hhhhhh', 'hhhhhhhhh');
INSERT INTO `systemdictionaryitem` VALUES ('24', '14', 'nnnnnnnnnn', 'nnnnnnnn');
INSERT INTO `systemdictionaryitem` VALUES ('25', '14', 'nnnnnnn', 'nnnnnnnnn');
INSERT INTO `systemdictionaryitem` VALUES ('26', null, '', '');
INSERT INTO `systemdictionaryitem` VALUES ('27', null, 'ss', 'ss');
INSERT INTO `systemdictionaryitem` VALUES ('28', null, '22', '22');
INSERT INTO `systemdictionaryitem` VALUES ('29', null, 'cc', 'cc');
INSERT INTO `systemdictionaryitem` VALUES ('44', '28', '11', '11');
INSERT INTO `systemdictionaryitem` VALUES ('45', '28', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('46', '28', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('47', '28', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('48', '28', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('49', '28', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('50', '28', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('51', '28', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('52', '28', '11', '11');
INSERT INTO `systemdictionaryitem` VALUES ('53', '28', '11', '11');
INSERT INTO `systemdictionaryitem` VALUES ('54', '29', '11', '');
INSERT INTO `systemdictionaryitem` VALUES ('55', '29', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('56', '29', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('57', '29', null, null);
INSERT INTO `systemdictionaryitem` VALUES ('58', '29', '22', '');
INSERT INTO `systemdictionaryitem` VALUES ('59', '29', '33', '');
INSERT INTO `systemdictionaryitem` VALUES ('60', '29', '44', '');
INSERT INTO `systemdictionaryitem` VALUES ('61', '29', '55', '');
INSERT INTO `systemdictionaryitem` VALUES ('91', '13', 'kk', 'kk');
INSERT INTO `systemdictionaryitem` VALUES ('96', '12', '111', '111');
INSERT INTO `systemdictionaryitem` VALUES ('97', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('98', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('99', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('100', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('101', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('102', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('103', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('104', '27', '', '');
INSERT INTO `systemdictionaryitem` VALUES ('105', '27', '4444', '888');
INSERT INTO `systemdictionaryitem` VALUES ('106', '27', '41111', '1111');
INSERT INTO `systemdictionaryitem` VALUES ('107', '26', '11', '11');
INSERT INTO `systemdictionaryitem` VALUES ('108', '26', '22', '22');
INSERT INTO `systemdictionaryitem` VALUES ('109', '26', '433', '33');
INSERT INTO `systemdictionaryitem` VALUES ('110', '26', '66', '666');
INSERT INTO `systemdictionaryitem` VALUES ('111', '30', '55', '55');
INSERT INTO `systemdictionaryitem` VALUES ('112', '31', '小码哥', '111');
INSERT INTO `systemdictionaryitem` VALUES ('114', '33', '充Q币', 'qq');
INSERT INTO `systemdictionaryitem` VALUES ('115', '34', '神说要有小类就有小类', '神啊');
INSERT INTO `systemdictionaryitem` VALUES ('116', '35', '我请客你出钱', '水鱼');
INSERT INTO `systemdictionaryitem` VALUES ('118', '37', '在职', '在职');
INSERT INTO `systemdictionaryitem` VALUES ('119', '38', '本科', '专坑人');
INSERT INTO `systemdictionaryitem` VALUES ('120', '39', '高级', '');
INSERT INTO `systemdictionaryitem` VALUES ('121', '40', '广州', '');
INSERT INTO `systemdictionaryitem` VALUES ('122', '41', '科技', '');
INSERT INTO `systemdictionaryitem` VALUES ('123', '42', '四年全日制', '');
INSERT INTO `systemdictionaryitem` VALUES ('124', '43', '普通', '');
INSERT INTO `systemdictionaryitem` VALUES ('125', '58', 'qq', '');
INSERT INTO `systemdictionaryitem` VALUES ('126', '58', '电话', '');
INSERT INTO `systemdictionaryitem` VALUES ('127', '58', '微信', '');
INSERT INTO `systemdictionaryitem` VALUES ('128', '58', '网络交流', '');
INSERT INTO `systemdictionaryitem` VALUES ('129', '58', '其他', '');
INSERT INTO `systemdictionaryitem` VALUES ('134', '57', '老学员介绍', '');
INSERT INTO `systemdictionaryitem` VALUES ('135', '57', '优惠卡', '');
INSERT INTO `systemdictionaryitem` VALUES ('136', '57', '家属特权优惠卡', '');
INSERT INTO `systemdictionaryitem` VALUES ('137', '57', '其他', '');
INSERT INTO `systemdictionaryitem` VALUES ('138', '32', '微信支付', 'qq');
INSERT INTO `systemdictionaryitem` VALUES ('139', '32', '支付包', '');
INSERT INTO `systemdictionaryitem` VALUES ('140', '32', '百度钱包', '');
INSERT INTO `systemdictionaryitem` VALUES ('141', '32', '其他', '');
INSERT INTO `systemdictionaryitem` VALUES ('142', '56', '微信支付', '');
INSERT INTO `systemdictionaryitem` VALUES ('143', '56', '支付宝', '');
INSERT INTO `systemdictionaryitem` VALUES ('144', '56', '现金支付', '');
INSERT INTO `systemdictionaryitem` VALUES ('145', '56', '支付宝支付', '');
INSERT INTO `systemdictionaryitem` VALUES ('146', '55', 'CET-4', '');
INSERT INTO `systemdictionaryitem` VALUES ('147', '55', 'CET-6', '');
INSERT INTO `systemdictionaryitem` VALUES ('148', '55', 'CET-8', '');
INSERT INTO `systemdictionaryitem` VALUES ('149', '54', '应届生', '');
INSERT INTO `systemdictionaryitem` VALUES ('150', '54', '一年', '');
INSERT INTO `systemdictionaryitem` VALUES ('151', '54', '两年以上', '');
INSERT INTO `systemdictionaryitem` VALUES ('152', '53', 'JAVA', '');
INSERT INTO `systemdictionaryitem` VALUES ('153', '53', 'UI', '');
INSERT INTO `systemdictionaryitem` VALUES ('154', '53', 'C++', '');
INSERT INTO `systemdictionaryitem` VALUES ('155', '53', 'H5', '');
INSERT INTO `systemdictionaryitem` VALUES ('156', '53', 'IOS', '');
INSERT INTO `systemdictionaryitem` VALUES ('157', '52', '是', '');
INSERT INTO `systemdictionaryitem` VALUES ('158', '52', '否', '');
INSERT INTO `systemdictionaryitem` VALUES ('159', '51', '学校学习', '');
INSERT INTO `systemdictionaryitem` VALUES ('160', '51', '实习中', '');
INSERT INTO `systemdictionaryitem` VALUES ('161', '51', '找工作', '');
INSERT INTO `systemdictionaryitem` VALUES ('162', '51', '在家待业', '');
INSERT INTO `systemdictionaryitem` VALUES ('163', '51', '在职', '');
INSERT INTO `systemdictionaryitem` VALUES ('164', '51', '其他', '');
INSERT INTO `systemdictionaryitem` VALUES ('165', '50', '个人客户', '');
INSERT INTO `systemdictionaryitem` VALUES ('166', '50', '学校客户', '');
INSERT INTO `systemdictionaryitem` VALUES ('167', '50', '合作公司客户', '');
INSERT INTO `systemdictionaryitem` VALUES ('168', '49', '简单看看', '');
INSERT INTO `systemdictionaryitem` VALUES ('169', '49', '有点兴趣', '');
INSERT INTO `systemdictionaryitem` VALUES ('170', '49', '想深入了解', '');
INSERT INTO `systemdictionaryitem` VALUES ('171', '49', '愿意去学校考察', '');
INSERT INTO `systemdictionaryitem` VALUES ('172', '49', '愿意入学', '');
INSERT INTO `systemdictionaryitem` VALUES ('173', '48', '西北地区', '');
INSERT INTO `systemdictionaryitem` VALUES ('174', '48', '西南地区', '');
INSERT INTO `systemdictionaryitem` VALUES ('175', '48', '东北地区', '');
INSERT INTO `systemdictionaryitem` VALUES ('176', '48', '华南地区', '');
INSERT INTO `systemdictionaryitem` VALUES ('177', '48', '华北地区', '');
INSERT INTO `systemdictionaryitem` VALUES ('178', '48', '华中地区', '');
INSERT INTO `systemdictionaryitem` VALUES ('179', '47', '小学', '');
INSERT INTO `systemdictionaryitem` VALUES ('180', '47', '中学', '');
INSERT INTO `systemdictionaryitem` VALUES ('181', '47', '本科', '');
INSERT INTO `systemdictionaryitem` VALUES ('182', '47', '硕士', '');
INSERT INTO `systemdictionaryitem` VALUES ('183', '47', '博士', '');
INSERT INTO `systemdictionaryitem` VALUES ('184', '47', '其他', '');
INSERT INTO `systemdictionaryitem` VALUES ('185', '46', '男', '');
INSERT INTO `systemdictionaryitem` VALUES ('186', '46', '女', '');
INSERT INTO `systemdictionaryitem` VALUES ('187', '45', '老学员推荐', '');
INSERT INTO `systemdictionaryitem` VALUES ('188', '45', '网络抓取', '');
INSERT INTO `systemdictionaryitem` VALUES ('189', '45', '官网链接', '');
INSERT INTO `systemdictionaryitem` VALUES ('190', '45', '学校推荐', '');
INSERT INTO `systemdictionaryitem` VALUES ('191', '45', '主动咨询', '');
INSERT INTO `systemdictionaryitem` VALUES ('192', '45', '其他', '');
INSERT INTO `systemdictionaryitem` VALUES ('193', '59', '广州校区', '');
INSERT INTO `systemdictionaryitem` VALUES ('194', '59', '北京校区', '');
INSERT INTO `systemdictionaryitem` VALUES ('195', '59', '深圳校区', '');
INSERT INTO `systemdictionaryitem` VALUES ('196', '59', '上海校区', '');
INSERT INTO `systemdictionaryitem` VALUES ('197', '36', 'java学科', '从入门到入土');
INSERT INTO `systemdictionaryitem` VALUES ('198', '36', 'ui学科', '');
INSERT INTO `systemdictionaryitem` VALUES ('199', '36', 'H5学科', '');
INSERT INTO `systemdictionaryitem` VALUES ('200', '36', '计算机科学', '');

-- ----------------------------
-- Table structure for systemmenu
-- ----------------------------
DROP TABLE IF EXISTS `systemmenu`;
CREATE TABLE `systemmenu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` varchar(20) DEFAULT NULL,
  `iconCls` varchar(20) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_parent` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemmenu
-- ----------------------------
INSERT INTO `systemmenu` VALUES ('3', '系统管理', 'icon-system', '', null);
INSERT INTO `systemmenu` VALUES ('29', '员工管理', 'icon-person', '/employee', '3');
INSERT INTO `systemmenu` VALUES ('30', '部门管理', 'icon-department', '/department', '3');
INSERT INTO `systemmenu` VALUES ('31', '角色管理', 'icon-role', '/role', '3');
INSERT INTO `systemmenu` VALUES ('32', '数据字典', 'icon-dictionaries', '/systemDictionary', '3');
INSERT INTO `systemmenu` VALUES ('33', '合同管理', 'icon-test', '/contractManage', '67');
INSERT INTO `systemmenu` VALUES ('34', '订单管理', 'icon-teacherMag', '/orderBill', '67');
INSERT INTO `systemmenu` VALUES ('36', '权限管理', 'icon-permission', '/permission', '3');
INSERT INTO `systemmenu` VALUES ('37', '菜单管理', 'icon-menu', '/systemMenu', '3');
INSERT INTO `systemmenu` VALUES ('39', '学员售前管理', 'icon-preSales', '', null);
INSERT INTO `systemmenu` VALUES ('40', '潜在学员管理', 'icon-role', '/potentialCustom', '39');
INSERT INTO `systemmenu` VALUES ('41', '学员跟踪管理', 'icon-follow', '/trackStudent', '39');
INSERT INTO `systemmenu` VALUES ('42', '移交历史管理', 'icon-turnOver', '/history', '39');
INSERT INTO `systemmenu` VALUES ('43', '大客户(学校)管理', 'icon-bigClient', '/bigClient', '39');
INSERT INTO `systemmenu` VALUES ('44', '学校联系人管理', 'icon-linkman', '/linkman', '39');
INSERT INTO `systemmenu` VALUES ('45', '潜在客户池', 'icon-role', '/potentialCustomPool', '39');
INSERT INTO `systemmenu` VALUES ('46', '考试管理', 'icon-test', '/examManage', '39');
INSERT INTO `systemmenu` VALUES ('47', '考勤管理', 'icon-attendance', '', null);
INSERT INTO `systemmenu` VALUES ('48', '考勤', 'icon-sign', '/attendancesheet', '47');
INSERT INTO `systemmenu` VALUES ('49', '考勤导出', 'icon-out', '/attendanceExport', '47');
INSERT INTO `systemmenu` VALUES ('50', '工资和任务管理', 'icon-salary', '', null);
INSERT INTO `systemmenu` VALUES ('51', '工资表', 'icon-payroll', '/saleChart', '50');
INSERT INTO `systemmenu` VALUES ('52', '学员售后管理', 'icon-sale', '', null);
INSERT INTO `systemmenu` VALUES ('53', '正式学员管理', 'icon-student', '/formalStudent', '52');
INSERT INTO `systemmenu` VALUES ('54', '学员升班留级', 'icon-student', '/upOrDownClass', '52');
INSERT INTO `systemmenu` VALUES ('55', '学员流失', 'icon-student', '/lossStudent', '52');
INSERT INTO `systemmenu` VALUES ('56', '支出管理', 'icon-payroll', '/pay', '52');
INSERT INTO `systemmenu` VALUES ('57', '收款管理', 'icon-payroll', '/charge', '52');
INSERT INTO `systemmenu` VALUES ('58', '教务管理', 'icon-teacherMag', '', null);
INSERT INTO `systemmenu` VALUES ('59', '班级管理', 'icon-role', '/classroom', '58');
INSERT INTO `systemmenu` VALUES ('60', '课程表', 'icon-teacherMag', '/classCourseManageItem', '58');
INSERT INTO `systemmenu` VALUES ('61', '学院', 'icon-department', '/institute', '58');
INSERT INTO `systemmenu` VALUES ('62', '教室情况', 'icon-classroom', '/classRoomManage', '58');
INSERT INTO `systemmenu` VALUES ('63', '报表管理', 'icon-chart', '', null);
INSERT INTO `systemmenu` VALUES ('64', '支付报表', 'icon-bigClient', '/payChart', '63');
INSERT INTO `systemmenu` VALUES ('65', '收费报表', 'icon-payroll', '/chargeChart', '63');
INSERT INTO `systemmenu` VALUES ('66', '潜在客户报表', 'icon-role', '/customChart', '63');
INSERT INTO `systemmenu` VALUES ('67', '订单合同管理', 'icon-orderbill', '', null);
INSERT INTO `systemmenu` VALUES ('68', '当日任务安排', 'icon-mission', '/dayMission', '50');
INSERT INTO `systemmenu` VALUES ('69', '企业网盘', 'icon-netDisc', '/netDisc', null);

-- ----------------------------
-- Table structure for trackstudent
-- ----------------------------
DROP TABLE IF EXISTS `trackstudent`;
CREATE TABLE `trackstudent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL COMMENT '潜在学员/关联了潜在学员',
  `nextvisittime` datetime DEFAULT NULL COMMENT '下次访问时间',
  `trackaim` varchar(255) DEFAULT NULL COMMENT '跟踪目的',
  `consulttype_id` bigint(20) DEFAULT NULL COMMENT '咨询方式/从数据字典来',
  `summary` varchar(255) DEFAULT NULL COMMENT '摘要',
  `talktype_id` bigint(20) DEFAULT NULL COMMENT '交流方式/从数据字典来',
  `consulttime` bigint(20) DEFAULT NULL COMMENT '咨询时长',
  `fileaddress` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `talkcontent` varchar(255) DEFAULT NULL COMMENT '交流内容',
  `school_id` bigint(20) DEFAULT NULL COMMENT '所属学校/从学校表来',
  `schoollinkman_id` bigint(20) DEFAULT NULL COMMENT '学校联系人/从学校联系人表来',
  `tracktime` datetime DEFAULT NULL,
  `consultperson_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trackstudent
-- ----------------------------
INSERT INTO `trackstudent` VALUES ('2', '82', '2017-03-07 00:00:00', '2017-03-08', '145', '', null, null, '', '', '2', null, '2017-03-06 00:00:00', '3');
INSERT INTO `trackstudent` VALUES ('17', '82', '2017-10-13 00:00:00', '555', '162', '88', null, '60', '', '60', '2', null, '2017-10-05 00:00:00', '1');
INSERT INTO `trackstudent` VALUES ('20', '89', '2017-10-19 00:00:00', 'xxoo', '164', '111', null, '70', '', '000', '2', null, '2017-10-18 00:00:00', '1');
INSERT INTO `trackstudent` VALUES ('26', '94', '2017-10-16 00:00:00', '泡她', '128', '你好啊', null, '60', '', '是是是', '2', null, '2017-10-11 00:00:00', '1');

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `traindate` date DEFAULT NULL,
  `traininfo` varchar(255) DEFAULT NULL,
  `trainaddress` varchar(255) DEFAULT NULL,
  `trainresult` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `bigclient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('1', '2017-10-12', '888', '9788', '878', '12544', '1');
INSERT INTO `train` VALUES ('2', '2017-10-12', '88', '66', '88', '88', '1');
INSERT INTO `train` VALUES ('3', '2017-10-12', '66', '66', '99', '99', '1');
INSERT INTO `train` VALUES ('5', '2017-10-12', '88', '88', '88', '8', '2');
INSERT INTO `train` VALUES ('6', '2017-10-15', '95856256', '5644', '74964', '95555', '2');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suffix` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `typename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', null, 'icon-folder', '文件夹');
INSERT INTO `type` VALUES ('2', 'jpg', 'icon-pic', '图片');
INSERT INTO `type` VALUES ('3', 'xls', 'icon-xls', 'Excel');
INSERT INTO `type` VALUES ('4', 'doc', 'icon-word', 'word');
INSERT INTO `type` VALUES ('5', 'txt', 'icon-txt', '文本');
INSERT INTO `type` VALUES ('6', 'mp3', 'icon-music', '音乐');
INSERT INTO `type` VALUES ('7', 'avi', 'icon-video', '视频');
INSERT INTO `type` VALUES ('8', 'pdf', null, 'pdf');
INSERT INTO `type` VALUES ('9', null, 'icon-unknown', '其它');
