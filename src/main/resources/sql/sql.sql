/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.27 : Database - tombstone
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tombstone` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tombstone`;

/*Table structure for table `apply_maintain` */

DROP TABLE IF EXISTS `apply_maintain`;

CREATE TABLE `apply_maintain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_number` char(10) NOT NULL COMMENT '订单号',
  `name` varchar(255) DEFAULT NULL COMMENT '申请人',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `content` varchar(255) DEFAULT NULL COMMENT '维修内容',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '性别 0：女 1：男',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工id',
  `status` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '状态 0：提单 1：派单 2：接单 3：取消订单 4：完成',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `end_date` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`,`order_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `apply_maintain` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `figure_id` varchar(40) NOT NULL COMMENT '人物id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `content` varchar(1000) DEFAULT NULL COMMENT '留言内容',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '0：正常 1：禁止  2：删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `comment` */

insert  into `comment`(`id`,`figure_id`,`name`,`content`,`create_date`,`status`) values ('7dbacad5b2434348ba527cf4397b05bf','e20b4536d2be472881132bfafa6a15b5','dd','ddd','2019-12-24 09:06:06',0),('9a108af4e7fc436e9c557ef8157c4f66','04c8a0bb34d342a6a5fa7c841864ed8b','不好吧','见见你','2019-12-17 09:46:20',0),('bc6d7216bb6342af8d51846a8a9d8737','5e16fafcf14349bf9606ae468b523047','jjjj','kkkk','2019-12-17 15:16:30',0);

/*Table structure for table `deeds` */

DROP TABLE IF EXISTS `deeds`;

CREATE TABLE `deeds` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `figure_id` varchar(40) NOT NULL COMMENT '人物id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `deeds_date` datetime DEFAULT NULL COMMENT '事件时间',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '0：正常 1：禁止  2：删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `deeds` */

insert  into `deeds`(`id`,`figure_id`,`title`,`content`,`deeds_date`,`create_date`,`status`) values ('2c90e6549a384294ac89abe60925c2c9','5e16fafcf14349bf9606ae468b523047','订单','大胆地','2019-12-19 00:00:00','2019-12-19 16:29:56',0),('db5e985a397c45009d75b2673226c1fe','e20b4536d2be472881132bfafa6a15b5','111','吞吞吐吐','2019-12-05 00:00:00','2019-12-24 23:07:58',0),('e39c98244f20403bbbed0f40dea1bd0f','5e16fafcf14349bf9606ae468b523047','911','轰炸美国五角大楼','2019-12-19 00:00:00','2019-12-19 16:29:56',0);

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `work_number` char(6) NOT NULL COMMENT '工号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `head_image` varchar(255) DEFAULT NULL COMMENT '头像',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` char(11) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '状态',
  `level` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '等级 0：普通员工 1：管理员',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `employees` */

/*Table structure for table `figure` */

DROP TABLE IF EXISTS `figure`;

CREATE TABLE `figure` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `title` varchar(255) DEFAULT NULL COMMENT '墓志铭',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `image` varchar(255) DEFAULT NULL COMMENT '主图',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `death_date` datetime DEFAULT NULL COMMENT '死亡日期',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '0：正常 1：禁止  2：删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `figure` */

insert  into `figure`(`id`,`name`,`title`,`content`,`image`,`birth_date`,`death_date`,`create_date`,`status`) values ('04c8a0bb34d342a6a5fa7c841864ed8b','帮帮帮帮帮','帮帮帮帮帮','回家就能','b6937e75ff094d4e8a6fad5a17537a13.jpeg','2019-12-17 00:00:00','2019-12-17 00:00:00','2019-12-17 09:46:49',2),('091f8292b4b44abb863c770bf84adb34','1',NULL,NULL,NULL,NULL,NULL,'2019-12-17 09:46:59',2),('2722966703e04ea4bbecf6898f5579ae','bggg','ggg','gggg','c9e342e3190d44239ebca927d7d4f242.jpeg','2019-12-17 00:00:00','2019-12-17 00:00:00','2019-12-17 09:47:02',2),('309466a0c559413999ba2cd85a822ee3','ddd',NULL,'dddd',NULL,NULL,NULL,'2019-12-17 09:47:05',2),('4d52a14030284acbb88c7932525cf5b0','55555',NULL,NULL,NULL,NULL,NULL,'2019-12-17 09:47:08',2),('5e16fafcf14349bf9606ae468b523047','哈哈哈',NULL,'你看我','a23a9eb30f1948e1b528d531d4ed2330.gif',NULL,NULL,'2019-12-17 17:55:25',0),('674badf56d1d4ceaaeb824be26fcb722','1',NULL,'1','98a33a7ed9624388a6414de80f578ec4.jpeg',NULL,NULL,'2019-12-17 09:46:53',2),('778fb31525e5485d99cd96f906667277','444',NULL,NULL,NULL,NULL,NULL,'2019-12-17 09:47:10',2),('79697b82b52a41feb6dcce63446c5366','444','444',NULL,NULL,NULL,NULL,'2019-12-17 09:47:14',2),('9695341e1fe145bd888608d2b2876dfd','1',NULL,NULL,NULL,NULL,NULL,'2019-12-17 09:46:55',2),('c6f888f9713e434db94558032fa17982','dd','dd',NULL,NULL,'2019-12-17 00:00:00','2019-12-17 00:00:00','2019-12-17 09:47:17',2),('e20b4536d2be472881132bfafa6a15b5','111',NULL,NULL,'9d65f2445b8244b2bc97c62c8148d035.gif',NULL,NULL,'2019-12-22 21:43:32',0),('f4d1bed76a304ed3bf30d277ca73491d','444','444','4444',NULL,'2019-12-17 00:00:00','2019-12-17 00:00:00','2019-12-17 09:47:31',2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `head_image` varchar(255) DEFAULT NULL COMMENT '头像',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `sex` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '性别 0：女 1：男',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
