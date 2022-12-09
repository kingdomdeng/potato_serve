-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: potato_db
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sys_menu` (
  `id` int(11) DEFAULT NULL,
  `menu_id` varchar(32) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `app_id` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `disabled` tinyint(4) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (2,'05db00fdbe1ec386ab42b132d62f6a3c',NULL,0,NULL,'url','test5','remark test1',0,1,'2022-04-01 15:42:04','2022-04-01 16:15:40'),(5,'6f6fd84190d9233869ca057c64deb8e4',NULL,0,NULL,'url','test5','remark test1',0,0,'2022-04-01 15:52:26','2022-04-01 15:52:26'),(8,'e2d74a3af0625a76a61c61f300941d20',NULL,0,NULL,'remark test1','name233','remark233',0,0,'2022-04-01 15:52:29','2022-04-01 15:59:23'),(9,'e640773f129431046d1a90436ba5e215',NULL,0,NULL,'url','test5','remark test1',0,0,'2022-04-01 15:52:30','2022-04-01 15:52:30'),(10,'2bbcf5a2f0b346220cba33c8abfa58bb','',1,'icon','http://localhost:8081/menu','菜单1','123',0,0,'2022-04-03 16:26:32','2022-04-06 11:34:17'),(11,'dcae07ce34096e3c0e421758eba4037b',NULL,1,'icon','url','菜单2','123',0,1,'2022-04-03 16:27:28','2022-04-03 22:54:36'),(12,'859c2092953b51f71efd1e3a782cad74',NULL,1,'icon12','url2','菜单33','123',0,1,'2022-04-03 16:28:55','2022-04-03 22:54:32'),(13,'60a778137f1e89280f56c51e466203fc',NULL,2,'icon','url','菜单2编辑','123',0,1,'2022-04-03 17:52:33','2022-04-03 22:54:28'),(14,'611928b609395a9595bce2b18b21d544',NULL,2,'1','1','应用2菜单','禁用',1,0,'2022-04-03 23:21:20','2022-04-03 23:21:20'),(15,'312f0ce9190e3b02eadff0822ec9c051',NULL,2,'1','1','菜单2','',0,0,'2022-04-05 10:36:25','2022-04-05 10:36:25'),(16,'4fdf9c86608f39b4807969175cb91e1d','2bbcf5a2f0b346220cba33c8abfa58bb',1,'1','1','子级菜单','',0,0,'2022-04-05 11:29:49','2022-04-05 11:29:49'),(17,'af0b6811a259a8ab445ea72fe6d0db7b','',1,'1','1','三级菜单','',0,0,'2022-04-05 11:36:18','2022-04-06 11:34:37'),(18,'34604c5b671ce1f924db0ad413765b45','af0b6811a259a8ab445ea72fe6d0db7b',1,'1','1','四级菜单','',0,0,'2022-04-05 11:37:05','2022-04-06 11:34:42'),(19,'56bd1c24bf8efbe04f90e51cc100d00d','2bbcf5a2f0b346220cba33c8abfa58bb',1,'1','1','菜单1子菜单2','',0,0,'2022-04-06 14:17:05','2022-04-06 14:17:05'),(20,'2f1673745c813553c7c9bdf1c55e508a','af0b6811a259a8ab445ea72fe6d0db7b',1,'plus','menu','三级菜单子菜单1','',0,0,'2022-12-08 13:02:31','2022-12-08 13:02:31'),(21,'fafd482ab2d141cd116f0476d484367c','',0,'','','','',0,0,'2022-12-08 19:57:18','2022-12-08 19:57:18');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sys_role` (
  `id` int(11) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `app_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `disabled` tinyint(4) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'f3235fb00726e0b8c720c715e42487d4',0,'test5','remark test1',0,0,'2022-04-01 16:54:13','2022-04-01 16:54:13'),(2,'5ba6d7eecd229e6c1d1d6b4e637b7de5',0,'test5','remark test1',0,0,'2022-04-01 16:54:21','2022-04-01 16:54:21'),(3,'6185c227d716288b95b237e15052a418',0,'name233','remark233',0,0,'2022-04-01 16:54:22','2022-04-01 16:55:41'),(4,'78fa4949768ece8b69839bbbb2e9f01a',0,'test5','remark test1',0,1,'2022-04-01 16:54:28','2022-04-01 16:57:25'),(5,'b87a70c70e26dc2db3009430882565a5',0,'test5','remark test1',0,1,'2022-04-01 16:54:29','2022-04-03 23:14:55'),(6,'7eb2ec3159b394f3504fb72554c0531b',2,'角色1编辑','不禁用',0,0,'2022-04-03 23:20:35','2022-04-03 23:23:25'),(7,'6e6556bdb3bf7a735d56fe4e8e6ae2ef',2,'管理员','',0,0,'2022-04-04 23:44:38','2022-04-04 23:44:38'),(8,'6644897d12320a16a3123161617f9945',2,'超级管理员','',0,0,'2022-04-04 23:44:47','2022-04-04 23:44:47'),(9,'c62978abda145a2158a65c1cdc235ec6',2,'二级管理员','',0,0,'2022-04-04 23:44:56','2022-04-04 23:44:56'),(10,'9e59d3925381b2119a3341bf5d7ddec8',2,'一级管理员','',0,0,'2022-04-04 23:59:21','2022-04-04 23:59:21'),(11,'c02fab47bfc678c6512c00c22d58431f',1,'分区管理员','',0,0,'2022-04-04 23:59:30','2022-04-04 23:59:30'),(12,'3105850e41319e18ab0eebf2c7346bdf',2,'区域管理员','',0,0,'2022-04-05 00:00:03','2022-04-05 00:00:03'),(13,'3fd396ee47cc3da1b9b3c86851de940d',2,'分组管理员','',0,0,'2022-04-05 00:00:27','2022-04-05 00:00:27'),(14,'136beaf414d9d023dee528cd17c0e5de',1,'应用1管理员','',0,0,'2022-04-06 15:16:49','2022-04-06 15:16:49');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu_relation`
--

DROP TABLE IF EXISTS `sys_role_menu_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sys_role_menu_relation` (
  `id` int(11) DEFAULT NULL,
  `app_id` int(11) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `menu_id` varchar(32) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu_relation`
--

LOCK TABLES `sys_role_menu_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_menu_relation` DISABLE KEYS */;
INSERT INTO `sys_role_menu_relation` VALUES (30,1,'2','05db00fdbe1ec386ab42b132d62f6a3c',0,'2022-04-02 17:21:32','2022-04-02 20:15:29'),(33,1,'2','6f6fd84190d9233869ca057c64deb8e4',0,'2022-04-02 17:21:53','2022-04-02 20:15:33'),(34,1,'2','666',0,'2022-04-02 17:25:35','2022-04-02 17:25:35'),(35,1,'2','7767',0,'2022-04-02 17:25:35','2022-04-02 17:25:35'),(36,1,'3','123',0,'2022-04-02 17:25:49','2022-04-02 17:25:49'),(38,1,'3','666',0,'2022-04-02 17:25:49','2022-04-02 17:25:49'),(40,2,'3','123',0,'2022-04-02 17:56:04','2022-04-02 17:56:04'),(41,2,'3','666',0,'2022-04-02 17:56:04','2022-04-02 17:56:04'),(44,2,'3fd396ee47cc3da1b9b3c86851de940d','611928b609395a9595bce2b18b21d544',0,'2022-04-05 11:00:02','2022-04-05 11:00:02'),(45,2,'3105850e41319e18ab0eebf2c7346bdf','312f0ce9190e3b02eadff0822ec9c051',0,'2022-04-05 11:00:09','2022-04-05 11:00:09'),(48,1,'c02fab47bfc678c6512c00c22d58431f','af0b6811a259a8ab445ea72fe6d0db7b',0,'2022-04-06 14:22:39','2022-04-06 14:22:39'),(49,1,'c02fab47bfc678c6512c00c22d58431f','34604c5b671ce1f924db0ad413765b45',0,'2022-04-06 14:22:39','2022-04-06 14:22:39'),(50,1,'c02fab47bfc678c6512c00c22d58431f','4fdf9c86608f39b4807969175cb91e1d',0,'2022-04-06 14:26:06','2022-04-06 14:26:06'),(51,1,'136beaf414d9d023dee528cd17c0e5de','56bd1c24bf8efbe04f90e51cc100d00d',0,'2022-04-06 15:17:05','2022-04-06 15:17:05');
/*!40000 ALTER TABLE `sys_role_menu_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_user_relation`
--

DROP TABLE IF EXISTS `sys_role_user_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sys_role_user_relation` (
  `id` int(11) DEFAULT NULL,
  `app_id` int(11) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user_relation`
--

LOCK TABLES `sys_role_user_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_user_relation` DISABLE KEYS */;
INSERT INTO `sys_role_user_relation` VALUES (14,2,'c62978abda145a2158a65c1cdc235ec6','534108dfc57f507e7e3bbd5e1b86b93e',0,'2022-04-04 23:48:02','2022-04-04 23:48:02'),(15,2,'6e6556bdb3bf7a735d56fe4e8e6ae2ef','44f752bd29d0f95f3f41cf93c9296c07',0,'2022-04-04 23:48:29','2022-04-04 23:48:29'),(16,2,'6644897d12320a16a3123161617f9945','44f752bd29d0f95f3f41cf93c9296c07',0,'2022-04-04 23:48:29','2022-04-04 23:48:29'),(18,2,'3fd396ee47cc3da1b9b3c86851de940d','534108dfc57f507e7e3bbd5e1b86b93e',0,'2022-04-06 15:06:39','2022-04-06 15:06:39'),(20,1,'136beaf414d9d023dee528cd17c0e5de','7f485fb4323e62dfbe947578e335d97e',0,'2022-04-06 15:17:09','2022-04-06 15:17:09'),(22,1,'c02fab47bfc678c6512c00c22d58431f','7f485fb4323e62dfbe947578e335d97e',0,'2022-04-06 16:09:54','2022-04-06 16:09:54');
/*!40000 ALTER TABLE `sys_role_user_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sys_user` (
  `id` int(11) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `app_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `disabled` tinyint(4) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'dae0385e1196f0967e8eac93fa3500a2',1,'test333','remark test1',1,0,'2022-04-01 15:40:46','2022-04-01 15:40:46'),(2,'d0939e9c73d6f8fad164e2362291967d',1,'test333','remark test1',0,0,'2022-04-01 15:51:49','2022-04-03 23:10:52'),(5,'7e4d927ae81959772619013a399e9eb2',1,'用户2','233',1,0,'2022-04-03 23:11:37','2022-04-03 23:11:37'),(6,'7f485fb4323e62dfbe947578e335d97e',1,'应用2用户','禁用',1,0,'2022-04-03 23:21:40','2022-04-03 23:21:40'),(7,'534108dfc57f507e7e3bbd5e1b86b93e',2,'应用2用户3','',0,0,'2022-04-03 23:25:32','2022-04-03 23:25:32'),(8,'44f752bd29d0f95f3f41cf93c9296c07',2,'张三','',0,0,'2022-04-04 23:48:18','2022-04-04 23:48:18'),(9,'2c90e9d48712285708e7f71f07e990c3',1,'2','',0,0,'2022-12-09 14:18:31','2022-12-09 14:19:57');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-09 16:40:06
