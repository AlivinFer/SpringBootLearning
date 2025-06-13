-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tlias
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `tlias` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tlias`;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clazz` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(30) NOT NULL COMMENT '班级名称',
  `room` varchar(20) DEFAULT NULL COMMENT '班级教室',
  `begin_date` date NOT NULL COMMENT '开课时间',
  `end_date` date NOT NULL COMMENT '结课时间',
  `master_id` int unsigned DEFAULT NULL COMMENT '班主任ID, 关联员工表ID',
  `subject` tinyint unsigned NOT NULL COMMENT '学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6: 嵌入式',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'JavaEE就业163期','212','2023-04-30','2023-06-29',10,1,'2023-06-01 17:08:23','2023-06-01 17:39:58'),(4,'前端就业90期','210','2023-07-10','2024-01-20',3,2,'2023-06-01 17:45:12','2023-06-01 17:45:12'),(5,'JavaEE就业165期','108','2023-06-15','2023-12-25',6,1,'2023-06-01 17:45:40','2023-06-01 17:45:40'),(6,'JavaEE就业166期','105','2023-07-20','2024-02-20',20,1,'2023-06-01 17:46:10','2023-06-01 17:46:10'),(7,'大数据就业58期','209','2023-08-01','2024-02-15',7,3,'2023-06-01 17:51:21','2023-06-01 17:51:21'),(8,'JavaEE就业167期','325','2023-11-20','2024-05-10',36,1,'2023-11-15 11:35:46','2023-12-13 14:31:24'),(9,'JavaEE就业168期','215','2024-08-20','2025-01-01',47,1,'2024-08-17 22:54:09','2024-08-19 14:36:28'),(11,'JavaEE就业169期','213','2024-08-01','2025-01-10',27,1,'2024-08-20 09:51:45','2024-08-20 09:52:23'),(12,'JavaEE就业422','214','2024-08-21','2025-01-10',47,1,'2024-08-21 15:07:20','2024-08-21 15:07:20'),(13,'江苏花果山','水帘洞','2024-08-08','2050-08-08',47,1,'2024-08-23 09:50:31','2024-08-25 19:53:34');
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (1,'学工部','2023-09-25 09:47:40','2024-08-24 16:54:35'),(2,'教研部','2023-09-25 09:47:40','2024-08-09 15:17:04'),(3,'咨询部','2023-09-25 09:47:40','2024-07-30 21:26:24'),(16,'人事部','2024-08-20 09:50:42','2024-08-20 09:50:42'),(32,'财务部','2024-08-25 16:38:38','2024-08-25 16:38:38');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint unsigned NOT NULL COMMENT '性别, 1:男, 2:女',
  `phone` char(11) NOT NULL COMMENT '手机号',
  `job` tinyint unsigned DEFAULT NULL COMMENT '职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师',
  `salary` int unsigned DEFAULT NULL COMMENT '薪资',
  `image` varchar(300) DEFAULT NULL COMMENT '头像',
  `entry_date` date DEFAULT NULL COMMENT '入职日期',
  `dept_id` int unsigned DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'shinaian','123456','施耐庵',1,'13309090001',4,NULL,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2000-01-01',2,'2023-10-20 16:35:33','2023-11-16 16:11:26'),(2,'songjiang','123456','宋江',1,'13309090002',2,8600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:37'),(3,'lujunyi','123456','卢俊义',1,'13309090003',2,8900,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2008-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:39'),(4,'wuyong','123456','吴用',1,'13309090004',2,9200,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2007-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:41'),(5,'gongsunsheng','123456','公孙胜',1,'13309090005',2,9500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2012-12-05',2,'2023-10-20 16:35:33','2023-10-20 16:35:43'),(6,'huosanniang','123456','扈三娘',2,'13309090006',3,6500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:45'),(7,'chaijin','123456','柴进',1,'13309090007',1,4700,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2005-08-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:47'),(8,'likui','123456','李逵',1,'13309090008',1,4800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2014-11-09',1,'2023-10-20 16:35:33','2023-10-20 16:35:49'),(9,'wusong','123456','武松',1,'13309090009',1,4900,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2011-03-11',1,'2023-10-20 16:35:33','2023-10-20 16:35:51'),(10,'linchong','123456','林冲',1,'13309090010',1,5000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:53'),(11,'huyanzhuo','123456','呼延灼',1,'13309090011',2,9700,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2007-02-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:55'),(12,'xiaoliguang','123456','小李广',1,'13309090012',2,10000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2008-08-18',2,'2023-10-20 16:35:33','2023-10-20 16:35:57'),(13,'yangzhi','123456','杨志',1,'13309090013',1,5300,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2012-11-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:59'),(14,'shijin','123456','史进',1,'13309090014',2,10600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2002-08-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:01'),(15,'sunerniang','123456','孙二娘',2,'13309090015',2,10900,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2011-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:03'),(16,'luzhishen','123456','鲁智深',1,'13309090016',2,9600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2010-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:05'),(17,'liying','12345678','李应',1,'13309090017',1,5800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-03-21',1,'2023-10-20 16:35:33','2023-10-20 16:36:07'),(18,'shiqian','123456','时迁',1,'13309090018',2,10200,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:09'),(19,'gudasao','123456','顾大嫂',2,'13309090019',2,10500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2008-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:11'),(20,'ruanxiaoer','123456','阮小二',1,'13309090020',2,10800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2018-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:13'),(21,'ruanxiaowu','123456','阮小五',1,'13309090021',5,5200,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:15'),(22,'ruanxiaoqi','123456','阮小七',1,'13309090022',5,5500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2016-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:17'),(23,'ruanji','123456','阮籍',1,'13309090023',5,5800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2012-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:19'),(24,'tongwei','123456','童威',1,'13309090024',5,5000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2006-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:21'),(25,'tongmeng','123456','童猛',1,'13309090025',5,4800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2002-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:23'),(26,'yanshun','123456','燕顺',1,'13309090026',5,5400,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2011-01-01',3,'2023-10-20 16:35:33','2023-11-08 22:12:46'),(27,'lijun','123456','李俊',1,'13309090027',2,6600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2004-01-01',2,'2023-10-20 16:35:33','2023-11-16 17:56:59'),(28,'lizhong','123456','李忠',1,'13309090028',5,5000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2007-01-01',3,'2023-10-20 16:35:33','2023-11-17 16:34:22'),(30,'liyun','123456','李云',1,'13309090030',1,2800,'https://java422-web-ai.oss-cn-beijing.aliyuncs.com/2024/08/32a82999-f0b3-4c2c-9480-f668a3ce7ae8.png','2020-03-01',32,'2023-10-20 16:35:33','2024-08-28 21:26:16'),(47,'gaoyuanyuan6','1234567','高圆圆6',2,'13309090089',6,10000,'https://java422-web-ai.oss-cn-beijing.aliyuncs.com/2024/08/0f740b17-84c6-416b-98ad-6bf9d462ab48.png','2024-08-19',16,'2024-08-17 16:46:13','2024-08-28 21:26:12');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_expr`
--

DROP TABLE IF EXISTS `emp_expr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_expr` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `emp_id` int unsigned DEFAULT NULL COMMENT '员工ID',
  `begin` date DEFAULT NULL COMMENT '开始时间',
  `end` date DEFAULT NULL COMMENT '结束时间',
  `company` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `job` varchar(50) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工作经历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_expr`
--

LOCK TABLES `emp_expr` WRITE;
/*!40000 ALTER TABLE `emp_expr` DISABLE KEYS */;
INSERT INTO `emp_expr` VALUES (46,47,'2024-08-01','2024-08-03','百度','java开发'),(47,47,'2024-08-05','2024-08-10','字节跳动','架构师'),(48,47,'2024-07-01','2024-07-31','黑马','程序员鼓励师'),(49,30,'2024-08-02','2024-08-17','111','222');
/*!40000 ALTER TABLE `emp_expr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_log`
--

DROP TABLE IF EXISTS `emp_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `info` varchar(2000) DEFAULT NULL COMMENT '日志信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_log`
--

LOCK TABLES `emp_log` WRITE;
/*!40000 ALTER TABLE `emp_log` DISABLE KEYS */;
INSERT INTO `emp_log` VALUES (1,'2024-08-17 16:46:13','新增员工: Emp(id=47, username=gaoyuanyuan, password=, name=高圆圆, gender=2, phone=15509091111, job=5, salary=8000, image=, entryDate=2024-08-19, deptId=8, createTime=2024-08-17T16:46:12.753600800, updateTime=2024-08-17T16:46:12.753600800, deptName=null, exprList=[EmpExpr(id=null, empId=47, begin=2024-08-01, end=2024-08-03, company=啊啊啊啊, job=java), EmpExpr(id=null, empId=47, begin=2024-08-09, end=2024-08-17, company=点点滴滴, job=java)])'),(3,'2024-08-17 16:53:48','新增员工: Emp(id=49, username=mayun, password=, name=马云, gender=1, phone=18888888888, job=2, salary=100, image=, entryDate=2024-08-01, deptId=8, createTime=2024-08-17T16:53:47.853667300, updateTime=2024-08-17T16:53:47.853667300, deptName=null, exprList=[EmpExpr(id=null, empId=null, begin=2024-08-01, end=2024-08-03, company=收拾收拾, job=是是是), EmpExpr(id=null, empId=null, begin=2024-08-09, end=2024-08-17, company=防守打法, job=对对对)])');
/*!40000 ALTER TABLE `emp_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_login_log`
--

DROP TABLE IF EXISTS `emp_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_login_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `is_success` tinyint unsigned DEFAULT NULL COMMENT '是否成功, 1:成功, 0:失败',
  `jwt` varchar(1000) DEFAULT NULL COMMENT 'JWT令牌',
  `cost_time` bigint unsigned DEFAULT NULL COMMENT '耗时, 单位:ms',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登录日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_login_log`
--

LOCK TABLES `emp_login_log` WRITE;
/*!40000 ALTER TABLE `emp_login_log` DISABLE KEYS */;
INSERT INTO `emp_login_log` VALUES (1,'songjiang','123456','2024-08-26 08:37:38',1,'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE3MjQ2NzU4NTl9.957hnUiENe0Tih-s_JRsx-G3HPZ2O7fxtOfxOIm01RE',745),(2,'songjiang','123','2024-08-26 08:48:17',0,NULL,4753),(3,'songjiang','1235','2024-08-26 08:49:37',0,NULL,6606),(4,'songjiang','123456','2024-08-26 08:50:29',1,'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE3MjQ2NzY2Mjh9.DQSsAw8OcwWwjoYYpGZohxUNgqtd9pMn9wu-8leFQ6I',43),(5,'likui','123456','2024-08-26 16:40:11',1,'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6OCwidXNlcm5hbWUiOiJsaWt1aSIsImV4cCI6MTcyNDcwNDgxMX0.NOjsCFeiEisXuwGecCyyc95WCWPP6zwKH3dgU3mloh4',15),(6,'songjiang','123456','2024-08-27 08:18:51',1,'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE3MjQ3NjExMzJ9.ty0HmpMB_Dh5Bh48WJ5HsD8ghrSG9Z_chidGwh0F1gk',991);
/*!40000 ALTER TABLE `emp_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operate_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_emp_id` int unsigned DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(1000) DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) DEFAULT NULL COMMENT '返回值, 存储json格式',
  `cost_time` int DEFAULT NULL COMMENT '方法执行耗时, 单位:ms',
  `operate_emp_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作者名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operate_log`
--

LOCK TABLES `operate_log` WRITE;
/*!40000 ALTER TABLE `operate_log` DISABLE KEYS */;
INSERT INTO `operate_log` VALUES (1,1,'2024-08-24 15:33:04','com.itheima.controller.DeptController','delete','[20]','Result(code=1, msg=success, data=null)',41278,NULL),(2,1,'2024-08-24 15:32:22','com.itheima.controller.DeptController','delete','[20]','Result(code=1, msg=success, data=null)',10046,NULL),(3,1,'2024-08-24 15:33:37','com.itheima.controller.DeptController','add','[Dept(id=null, name=456, createTime=2024-08-24T15:33:37.472459700, updateTime=2024-08-24T15:33:37.472459700)]','Result(code=1, msg=success, data=null)',2596,NULL),(4,1,'2024-08-24 15:33:43','com.itheima.controller.DeptController','update','[Dept(id=21, name=45678, createTime=2024-08-24T15:33:37, updateTime=2024-08-24T15:33:43.221725500)]','Result(code=1, msg=success, data=null)',5,NULL),(5,1,'2024-08-24 15:33:45','com.itheima.controller.DeptController','delete','[21]','Result(code=1, msg=success, data=null)',10,NULL),(6,1,'2024-08-24 16:30:45','com.itheima.controller.DeptController','update','[Dept(id=22, name=1234567, createTime=2024-08-24T16:26:59, updateTime=2024-08-24T16:30:45.168029900)]','Result(code=1, msg=success, data=null)',12,NULL),(7,1,'2024-08-24 16:30:48','com.itheima.controller.DeptController','delete','[22]','Result(code=1, msg=success, data=null)',8,NULL),(8,1,'2024-08-24 16:30:50','com.itheima.controller.DeptController','add','[Dept(id=null, name=111, createTime=2024-08-24T16:30:50.269770700, updateTime=2024-08-24T16:30:50.269770700)]','Result(code=1, msg=success, data=null)',4,NULL),(9,1,'2024-08-24 16:30:52','com.itheima.controller.DeptController','delete','[23]','Result(code=1, msg=success, data=null)',7,NULL),(10,1,'2024-08-24 16:47:03','com.itheima.controller.DeptController','add','[Dept(id=null, name=财务2部, createTime=2024-08-24T16:47:03.299816200, updateTime=2024-08-24T16:47:03.299816200)]','Result(code=1, msg=success, data=null)',4,NULL),(11,1,'2024-08-24 16:47:14','com.itheima.controller.DeptController','delete','[24]','Result(code=1, msg=success, data=null)',5,NULL),(12,1,'2024-08-24 16:54:35','com.itheima.controller.DeptController','update','[Dept(id=1, name=学工部, createTime=2023-09-25T09:47:40, updateTime=2024-08-24T16:54:34.890667500)]','Result(code=1, msg=success, data=null)',523,NULL),(13,2,'2024-08-24 17:20:23','com.itheima.controller.DeptController','add','[Dept(id=null, name=123, createTime=2024-08-24T17:19:56.070887200, updateTime=2024-08-24T17:19:56.070887200)]','Result(code=1, msg=success, data=null)',40,NULL),(14,8,'2024-08-24 17:21:12','com.itheima.controller.DeptController','delete','[25]','Result(code=1, msg=success, data=null)',6,NULL),(15,8,'2024-08-25 19:54:33','com.itheima.controller.DeptController','update','[Dept(id=31, name=研发部, createTime=2024-08-25T16:36:01, updateTime=2024-08-25T19:54:33.478193)]','Result(code=1, msg=success, data=null)',6,NULL),(16,8,'2024-08-25 19:54:40','com.itheima.controller.DeptController','update','[Dept(id=29, name=后勤部, createTime=2024-08-25T16:34:37, updateTime=2024-08-25T19:54:40.151405900)]','Result(code=1, msg=success, data=null)',4,NULL),(17,8,'2024-08-25 19:54:46','com.itheima.controller.DeptController','delete','[26]','Result(code=1, msg=success, data=null)',5,NULL),(18,2,'2024-08-26 16:38:57','com.itheima.controller.EmpController','update','[Emp(id=30, username=liyun, password=null, name=李云, gender=1, phone=13309090030, job=1, salary=2800, image=https://java422-web-ai.oss-cn-beijing.aliyuncs.com/2024/08/c0054a00-b8be-4006-81ff-71286de48cc7.JPG, entryDate=2020-03-01, deptId=16, createTime=2023-10-20T16:35:33, updateTime=2024-08-26T16:38:57.138751200, deptName=null, exprList=[])]','Result(code=1, msg=success, data=null)',45,NULL),(19,8,'2024-08-26 16:41:25','com.itheima.controller.EmpController','save','[Emp(id=52, username=dengdengdengdcneg, password=, name=老邓, gender=2, phone=18888888888, job=1, salary=2, image=https://java422-web-ai.oss-cn-beijing.aliyuncs.com/2024/08/f6cee736-c316-4f50-b40d-6f9043b193a7.png, entryDate=2024-08-26, deptId=3, createTime=2024-08-26T16:41:25.238940900, updateTime=2024-08-26T16:41:25.239940300, deptName=null, exprList=[EmpExpr(id=null, empId=52, begin=2024-08-24, end=2024-08-25, company=白马, job=驮唐僧)])]','Result(code=1, msg=success, data=null)',12,NULL);
/*!40000 ALTER TABLE `operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `no` char(10) NOT NULL COMMENT '学号',
  `gender` tinyint unsigned NOT NULL COMMENT '性别, 1: 男, 2: 女',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `id_card` char(18) NOT NULL COMMENT '身份证号',
  `is_college` tinyint unsigned NOT NULL COMMENT '是否来自于院校, 1:是, 0:否',
  `address` varchar(100) DEFAULT NULL COMMENT '联系地址',
  `degree` tinyint unsigned DEFAULT NULL COMMENT '最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士',
  `graduation_date` date DEFAULT NULL COMMENT '毕业时间',
  `clazz_id` int unsigned NOT NULL COMMENT '班级ID, 关联班级表ID',
  `violation_count` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '违纪次数',
  `violation_score` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '违纪扣分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'段誉','2022000001',1,'18800000001','110120000300200001',1,'北京市昌平区建材城西路1号',1,'2021-07-01',11,2,8,'2023-11-14 21:22:19','2024-08-20 09:52:34'),(2,'萧峰','2022000002',1,'18800210003','110120000300200002',1,'北京市昌平区建材城西路2号',2,'2022-07-01',1,0,0,'2023-11-14 21:22:19','2023-11-14 21:22:19'),(3,'虚竹','2022000003',1,'18800013001','110120000300200003',1,'北京市昌平区建材城西路3号',2,'2023-07-01',1,0,0,'2023-11-14 21:22:19','2023-11-14 21:22:19'),(4,'萧远山','2022000004',1,'18800003211','110120000300200004',1,'北京市昌平区建材城西路4号',3,'2024-07-01',1,0,0,'2023-11-14 21:22:19','2023-11-14 21:22:19'),(5,'阿朱','2022000005',2,'18800160002','110120000300200005',1,'北京市昌平区建材城西路5号',4,'2020-07-01',1,0,0,'2023-11-14 21:22:19','2023-11-14 21:22:19'),(6,'阿紫','2022000006',2,'18800000034','110120000300200006',1,'北京市昌平区建材城西路6号',4,'2021-07-01',11,0,0,'2023-11-14 21:22:19','2024-08-20 09:52:46'),(7,'游坦之','2022000007',1,'18800000067','110120000300200007',1,'北京市昌平区建材城西路7号',4,'2022-07-01',11,0,0,'2023-11-14 21:22:19','2024-08-20 09:52:50'),(8,'康敏','2022000008',2,'18800000077','110120000300200008',1,'北京市昌平区建材城西路8号',5,'2023-07-01',11,0,0,'2023-11-14 21:22:19','2024-08-20 09:52:54'),(11,'钟万仇','2022000011',1,'18800000391','110120000300200011',1,'北京市昌平区建材城西路11号',4,'2021-07-01',1,0,0,'2023-11-14 21:22:19','2023-11-15 16:21:24'),(12,'崔百泉','2022000012',1,'18800000781','110120000300200018',1,'北京市昌平区建材城西路12号',4,'2022-07-05',8,6,17,'2023-11-14 21:22:19','2023-12-13 14:33:58'),(13,'耶律洪基','2022000013',1,'18800008901','110120000300200013',1,'北京市昌平区建材城西路13号',4,'2023-07-01',11,0,0,'2023-11-14 21:22:19','2024-08-20 09:52:09'),(14,'天山童姥','2022000014',2,'18800009201','110120000300200014',1,'北京市昌平区建材城西路14号',4,'2024-07-01',1,0,0,'2023-11-14 21:22:19','2023-11-15 16:21:17'),(15,'刘竹庄','2022000015',1,'18800009401','110120000300200015',1,'北京市昌平区建材城西路15号',3,'2020-07-01',4,0,0,'2023-11-14 21:22:19','2023-11-14 21:22:19'),(16,'李春来','2022000016',1,'18800008501','110120000300200016',1,'北京市昌平区建材城西路16号',4,'2021-07-01',4,0,0,'2023-11-14 21:22:19','2023-11-14 21:22:19'),(17,'王语嫣','2022000017',2,'18800007601','110120000300200017',1,'北京市昌平区建材城西路17号',2,'2022-07-01',4,0,0,'2023-11-14 21:22:19','2023-11-14 21:22:19'),(18,'郑成功','2023001101',1,'13309092345','110110110110110110',0,'北京市昌平区回龙观街道88号',5,'2021-07-01',8,2,7,'2023-11-15 16:26:18','2023-11-15 16:40:10'),(37,'段誉','2024062801',1,'15800000001','510120000300200001',1,'北京市昌平区建材城西路1号',4,'2021-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(38,'萧峰','2024062802',1,'15800210002','510120000300200002',0,'北京市昌平区建材城西路2号',4,'2022-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(39,'虚竹','2024062803',1,'15800210003','510120000300200003',0,'北京市昌平区建材城西路3号',4,'2023-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(40,'萧远山','2024062804',1,'15800350004','510120000300200004',0,'北京市昌平区建材城西路4号',4,'2024-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(41,'阿朱','2024062805',2,'15800455005','510120000300200005',0,'北京市昌平区建材城西路5号',3,'2020-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(42,'阿紫','2024062806',2,'15800560006','510120000300200006',0,'北京市昌平区建材城西路6号',4,'2021-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(43,'游坦之','2024062807',1,'15800665007','510120000300200007',0,'北京市昌平区建材城西路7号',4,'2022-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(44,'康敏','2024062808',2,'15800770008','510120000300200008',0,'北京市昌平区建材城西路8号',4,'2023-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(45,'徐长老','2024062809',1,'15800875009','510120000300200009',0,'北京市昌平区建材城西路9号',4,'2024-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(46,'云中鹤','2024062810',1,'15800980010','510120000300200010',1,'北京市昌平区建材城西路10号',5,'2020-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(47,'钟万仇','2024062811',1,'15801085011','510120000300200011',0,'北京市昌平区建材城西路11号',6,'2021-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(48,'崔百泉','2024062812',1,'15801190012','510120000300200012',0,'北京市昌平区建材城西路12号',3,'2022-07-05',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(49,'耶律洪基','2024062813',1,'15801295013','510120000300200013',0,'北京市昌平区建材城西路13号',4,'2023-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(50,'天山童姥','2024062814',2,'15801400014','510120000300200014',0,'北京市昌平区建材城西路14号',4,'2024-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(51,'刘竹庄','2024062815',1,'15801505015','510120000300200015',0,'北京市昌平区建材城西路15号',4,'2020-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(52,'李春来','2024062816',1,'15801610016','510120000300200016',0,'北京市昌平区建材城西路16号',3,'2021-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(53,'王语嫣','2024062817',2,'15801715017','510120000300200017',1,'北京市昌平区建材城西路17号',4,'2022-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(54,'郑成功','2024062818',1,'15801820018','510120000300200018',0,'北京市昌平区回龙观街道88号',4,'2021-07-01',12,0,0,'2024-08-21 15:13:01','2024-08-21 15:13:01'),(55,'黑吗喽','2024082010',1,'18888888888','188888888888888888',1,'花果山',1,'2024-08-28',13,1,255,'2024-08-23 08:47:28','2024-08-23 09:50:40'),(56,'今年18岁','5201314520',2,'13899777666','138778333399992222',0,'',NULL,NULL,11,0,0,'2024-08-24 08:32:06','2024-08-24 08:32:06');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tlias'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-13 15:47:53
