/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_connect_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `db_type` varchar(100) NOT NULL COMMENT '数据库类型',
  `nick_name` varchar(100) NOT NULL COMMENT '数据库昵称',
  `db_ip` varchar(25) NOT NULL COMMENT '连接库IP',
  `db_port` int(11) NOT NULL COMMENT '数据库连接端口',
  `default_connect_db` varchar(100) DEFAULT NULL COMMENT '默认链接库',
  `driver_class_name` varchar(100) NOT NULL COMMENT '驱动类名',
  `db_user` varchar(100) NOT NULL COMMENT '登录用户名',
  `db_pwd` varchar(100) NOT NULL COMMENT '登录用户密码',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态 0:禁用 1:正常',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='数据库链接配置';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `db_connect_config` VALUES (5,'mysql','本地','127.0.0.1',3306,'test','com.mysql.cj.jdbc.Driver','root','root',1,'2022-10-10 11:44:18','2022-10-10 11:44:18');
INSERT INTO `db_connect_config` VALUES (17,'mysql','数字信用测试环境','172.16.19.9',3306,'vls_dc_credit','com.mysql.jdbc.Driver','yct','qdchyct0828',1,'2022-10-20 19:00:44','2022-10-20 19:00:44');
INSERT INTO `db_connect_config` VALUES (18,'mysql','本地','127.0.0.1',3306,'datadeal','com.mysql.cj.jdbc.Driver','root','root',1,'2022-12-28 14:40:02','2022-12-28 14:40:02');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generate_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `component_code` varchar(100) NOT NULL COMMENT '组件编码',
  `policy_name` varchar(100) NOT NULL COMMENT '策略名称',
  `policy_code` varchar(100) NOT NULL COMMENT '策略编码',
  `policy_type` varchar(100) NOT NULL COMMENT '策略类型',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `menu_code` varchar(100) NOT NULL COMMENT '菜单码',
  `path` varchar(100) DEFAULT NULL COMMENT '跳转路径',
  `sort` int(11) NOT NULL COMMENT '排序',
  `parent_id` int(11) NOT NULL DEFAULT '-1' COMMENT '父级ID -1为顶级菜单',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态 1：启用  -1禁用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `menu` VALUES (1,'菜单','01','',1,-1,1,'2022-10-13 17:11:35','2022-10-25 16:07:40');
INSERT INTO `menu` VALUES (2,'数据库','02','',2,-1,1,'2022-10-14 17:57:27','2022-10-20 16:47:41');
INSERT INTO `menu` VALUES (3,'数据库列表','02','/db/index',3,2,1,'2022-10-14 17:57:27','2022-10-25 16:04:51');
INSERT INTO `menu` VALUES (4,'数据库配置','03','/db/dbConfig',4,2,1,'2022-10-14 17:57:27','2022-10-20 11:32:27');
INSERT INTO `menu` VALUES (11,'表生成结构','tableToJava','/tableToJava/index',0,-1,1,'2022-10-20 18:36:36','2022-10-25 16:04:51');
INSERT INTO `menu` VALUES (12,'菜单配置','01','/menu/index',4,1,1,'2022-10-25 16:07:40','2022-10-25 16:07:40');
INSERT INTO `menu` VALUES (13,'项目','2','',0,-1,1,'2022-10-25 16:42:31','2022-10-25 16:42:31');
INSERT INTO `menu` VALUES (14,'项目配置','2','/project/index',0,13,1,'2022-10-25 16:43:07','2022-10-25 16:43:07');
INSERT INTO `menu` VALUES (15,'模板','04','',0,-1,1,'2022-11-13 16:16:16','2022-11-13 16:18:45');
INSERT INTO `menu` VALUES (16,'模板维护','55','/template/index',0,15,1,'2022-11-13 16:19:30','2022-11-13 16:19:30');
INSERT INTO `menu` VALUES (18,'数据库代码生成','dbcreate','/project/dbcreate',0,13,1,'2022-12-14 10:23:41','2023-01-09 11:59:21');
INSERT INTO `menu` VALUES (19,'数据库代码生成策略','dbcreatestrategy','/project/dbcreatestrategy',0,13,1,'2022-12-15 15:08:51','2023-01-09 11:59:32');
INSERT INTO `menu` VALUES (20,'图像识别','picrecognize','',0,-1,1,'2023-04-09 22:19:08','2023-04-11 13:10:29');
INSERT INTO `menu` VALUES (22,'图像识别记录','picrecognize','/picrecognize/index',0,20,1,'2023-04-09 22:20:00','2023-04-11 13:07:41');
INSERT INTO `menu` VALUES (23,'图像特征匹配','','/picrecognize/feature',0,20,1,'2023-04-12 10:39:38','2023-04-12 10:39:38');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pic_recognize_feature_char` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `feature` varchar(900) NOT NULL COMMENT '特征点队列，最大30*30阵列',
  `charac` varchar(100) NOT NULL COMMENT '字符',
  `feature_size` int(11) NOT NULL COMMENT '特征点点阵边长，最大30',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pic_recognize_feature_char_un` (`feature`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='图片识别，特征点与字符对应';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `pic_recognize_feature_char` VALUES (1,'000000000000000000000000000000000000000000000000000011100000111100000000000000000011110000011110000000000000000011111000011110000000000000000011111100011110000000000000000011111100011110000000000000000011111110011110000000000000000011111110011110000001100000000000111111011110000001110000000000011111011110000011110000000000001111011110000111111000000000001111011110000111111000000000001111011110001111111000000000001111011110011111111000000000001111011110011111111000000000001111011110111111111000000000001111011111111111111000000000001111011111111111111000000000001111011111111111111100000000001111011111111100111100000000011111011111111100111110000000111111011111111000111111000011111111011111110000111111111111111110011111110000011111111111111110011111100000011111111111111110011111000000001111111111111100011111000000001111111111111000011110000000000111111111110000011100000000000011111111100000','3',810000,'2023-04-12 11:33:08','2023-04-12 11:33:08');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pic_recognize_feature_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `feature` varchar(900) NOT NULL COMMENT '特征点队列，最大30*30阵列',
  `feature_size` int(11) NOT NULL COMMENT '特征点点阵边长，最大30',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pic_recognize_feature_char_un` (`feature`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片识别，特征点与字符对应';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pic_recognize_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pic_url` varchar(500) NOT NULL COMMENT '上传图片所在地址',
  `pic_name` varchar(100) NOT NULL COMMENT '上传图片名称',
  `pic_recog` tinyint(1) NOT NULL DEFAULT '0' COMMENT '图片文字是否全匹配 0:否 1:是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='图片识别记录';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `pic_recognize_log` VALUES (29,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/source/切割.jpg','切割.jpg',0,'2023-04-12 11:55:38','2023-04-12 11:55:38');
INSERT INTO `pic_recognize_log` VALUES (30,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/source/切割.jpg','切割.jpg',0,'2023-04-12 12:01:32','2023-04-12 12:01:32');
INSERT INTO `pic_recognize_log` VALUES (31,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/source/切割.jpg','切割.jpg',0,'2023-04-12 12:05:18','2023-04-12 12:05:18');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pic_recognize_step` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pic_recognize_log_id` int(11) NOT NULL COMMENT '图片识别记录ID',
  `step_name` varchar(100) NOT NULL COMMENT '步骤名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `pic_recognize_step` VALUES (105,29,'灰度','2023-04-12 11:55:38','2023-04-12 11:55:38');
INSERT INTO `pic_recognize_step` VALUES (106,29,'去噪','2023-04-12 11:55:39','2023-04-12 11:55:39');
INSERT INTO `pic_recognize_step` VALUES (107,29,'二值化','2023-04-12 11:55:39','2023-04-12 11:55:39');
INSERT INTO `pic_recognize_step` VALUES (108,29,'取盘','2023-04-12 11:56:32','2023-04-12 11:56:32');
INSERT INTO `pic_recognize_step` VALUES (109,29,'切割','2023-04-12 11:56:37','2023-04-12 11:56:37');
INSERT INTO `pic_recognize_step` VALUES (110,29,'缩放','2023-04-12 11:56:37','2023-04-12 11:56:37');
INSERT INTO `pic_recognize_step` VALUES (111,30,'灰度','2023-04-12 12:01:32','2023-04-12 12:01:32');
INSERT INTO `pic_recognize_step` VALUES (112,30,'去噪','2023-04-12 12:01:32','2023-04-12 12:01:32');
INSERT INTO `pic_recognize_step` VALUES (113,30,'二值化','2023-04-12 12:01:32','2023-04-12 12:01:32');
INSERT INTO `pic_recognize_step` VALUES (114,30,'取盘','2023-04-12 12:02:02','2023-04-12 12:02:02');
INSERT INTO `pic_recognize_step` VALUES (115,30,'切割','2023-04-12 12:02:02','2023-04-12 12:02:02');
INSERT INTO `pic_recognize_step` VALUES (116,30,'缩放','2023-04-12 12:02:29','2023-04-12 12:02:29');
INSERT INTO `pic_recognize_step` VALUES (117,31,'灰度','2023-04-12 12:05:18','2023-04-12 12:05:18');
INSERT INTO `pic_recognize_step` VALUES (118,31,'去噪','2023-04-12 12:05:22','2023-04-12 12:05:22');
INSERT INTO `pic_recognize_step` VALUES (119,31,'二值化','2023-04-12 12:05:22','2023-04-12 12:05:22');
INSERT INTO `pic_recognize_step` VALUES (120,31,'取盘','2023-04-12 12:05:50','2023-04-12 12:05:50');
INSERT INTO `pic_recognize_step` VALUES (121,31,'切割','2023-04-12 12:05:50','2023-04-12 12:05:50');
INSERT INTO `pic_recognize_step` VALUES (122,31,'缩放','2023-04-12 12:06:35','2023-04-12 12:06:35');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pic_recognize_step_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pic_recognize_step_id` int(11) NOT NULL COMMENT '识别过程ID',
  `pic_url` varchar(500) NOT NULL COMMENT '过程图片地址',
  `pic_recog` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否识别 0:否 1:是',
  `recognize_result` varchar(1) DEFAULT NULL COMMENT '识别结果',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `pic_recognize_step_pic` VALUES (103,105,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/gray/切割0.jpg',0,NULL,'2023-04-12 11:55:38','2023-04-12 11:55:38');
INSERT INTO `pic_recognize_step_pic` VALUES (104,106,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/disnoize/切割0.jpg',0,NULL,'2023-04-12 11:55:39','2023-04-12 11:55:39');
INSERT INTO `pic_recognize_step_pic` VALUES (105,107,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/BW/切割0.jpg',0,NULL,'2023-04-12 11:55:39','2023-04-12 11:55:39');
INSERT INTO `pic_recognize_step_pic` VALUES (106,108,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/deal/切割0.jpg',0,NULL,'2023-04-12 11:56:32','2023-04-12 11:56:32');
INSERT INTO `pic_recognize_step_pic` VALUES (107,109,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/cut/切割0.jpg',0,NULL,'2023-04-12 11:56:37','2023-04-12 11:56:37');
INSERT INTO `pic_recognize_step_pic` VALUES (108,110,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/zoom/切割0.jpg',0,NULL,'2023-04-12 11:56:38','2023-04-12 11:56:38');
INSERT INTO `pic_recognize_step_pic` VALUES (109,111,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/gray/切割0.jpg',0,NULL,'2023-04-12 12:01:32','2023-04-12 12:01:32');
INSERT INTO `pic_recognize_step_pic` VALUES (110,112,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/disnoize/切割0.jpg',0,NULL,'2023-04-12 12:01:32','2023-04-12 12:01:32');
INSERT INTO `pic_recognize_step_pic` VALUES (111,113,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/BW/切割0.jpg',0,NULL,'2023-04-12 12:01:32','2023-04-12 12:01:32');
INSERT INTO `pic_recognize_step_pic` VALUES (112,114,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/deal/切割0.jpg',0,NULL,'2023-04-12 12:02:02','2023-04-12 12:02:02');
INSERT INTO `pic_recognize_step_pic` VALUES (113,115,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/cut/切割0.jpg',0,NULL,'2023-04-12 12:02:02','2023-04-12 12:02:02');
INSERT INTO `pic_recognize_step_pic` VALUES (114,116,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/zoom/切割0.jpg',0,NULL,'2023-04-12 12:03:27','2023-04-12 12:03:27');
INSERT INTO `pic_recognize_step_pic` VALUES (115,117,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/gray/切割0.jpg',0,NULL,'2023-04-12 12:05:22','2023-04-12 12:05:22');
INSERT INTO `pic_recognize_step_pic` VALUES (116,118,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/disnoize/切割0.jpg',0,NULL,'2023-04-12 12:05:22','2023-04-12 12:05:22');
INSERT INTO `pic_recognize_step_pic` VALUES (117,119,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/BW/切割0.jpg',0,NULL,'2023-04-12 12:05:22','2023-04-12 12:05:22');
INSERT INTO `pic_recognize_step_pic` VALUES (118,120,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/deal/切割0.jpg',0,NULL,'2023-04-12 12:05:50','2023-04-12 12:05:50');
INSERT INTO `pic_recognize_step_pic` VALUES (119,121,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/cut/切割0.jpg',0,NULL,'2023-04-12 12:05:50','2023-04-12 12:05:50');
INSERT INTO `pic_recognize_step_pic` VALUES (120,122,'D:/workspaces/workspace_spring/develop_helper/helper/src/main/resources/static/picrecognize/zoom/切割0.jpg',0,NULL,'2023-04-12 12:06:35','2023-04-12 12:06:35');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_code` varchar(100) NOT NULL COMMENT '产品编码',
  `project_name` varchar(100) NOT NULL COMMENT '项目名称',
  `base_url` varchar(100) DEFAULT NULL COMMENT '项目基本地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `project` VALUES (2,'PROJ0000000001','web','D:\\workspaces\\workspace_spring\\develop_helper\\web','2022-12-14 15:09:40',NULL);
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_code` varchar(100) NOT NULL COMMENT '项目编码',
  `module_name` varchar(100) NOT NULL COMMENT '模块名称',
  `module_code` varchar(100) NOT NULL COMMENT '模块编码',
  `module_path` varchar(100) DEFAULT NULL COMMENT '模块地址',
  `java_package` varchar(100) DEFAULT NULL COMMENT 'java代码地址',
  `resource_package` varchar(100) DEFAULT NULL COMMENT '配置文件代码地址',
  `front_package` varchar(100) DEFAULT NULL COMMENT '前端代码地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='项目模块';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `project_module` VALUES (3,'PROJ0000000001','单体工程','MODULE0000000003','','src\\main\\java','src\\main\\resources','','2023-02-07 10:10:05');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_module_component` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `module_code` varchar(100) NOT NULL COMMENT '模块编码',
  `component_name` varchar(100) NOT NULL COMMENT '组件名称',
  `component_code` varchar(100) NOT NULL COMMENT '组件编码',
  `component_flag` varchar(100) NOT NULL COMMENT '组件标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='项目组件';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `project_module_component` VALUES (5,'MODULE0000000003','表实体','COMPONENT0000000001','ENTITY','2023-02-07 13:58:55');
INSERT INTO `project_module_component` VALUES (7,'MODULE0000000003','mapper.java','COMPONENT0000000002','MAPPERJAVA','2023-02-07 14:22:11');
INSERT INTO `project_module_component` VALUES (8,'MODULE0000000003','mapper.xml','COMPONENT0000000003','MAPPERXML','2023-02-07 16:40:00');
INSERT INTO `project_module_component` VALUES (9,'MODULE0000000003','service接口','COMPONENT0000000004','SERVICEINTERFACE','2023-02-07 16:47:41');
INSERT INTO `project_module_component` VALUES (10,'MODULE0000000003','service实现','COMPONENT0000000005','SERVICEIMPL','2023-02-07 16:48:59');
INSERT INTO `project_module_component` VALUES (11,'MODULE0000000003','controller','COMPONENT0000000006','CONTROLLER','2023-02-08 12:00:44');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_module_component_rely` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `component_code` varchar(100) NOT NULL COMMENT '组件编码',
  `rely_component_code` varchar(100) NOT NULL COMMENT '依赖组件编码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='项目组件依赖关系';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `project_module_component_rely` VALUES (1,'COMPONENT0000000002','COMPONENT0000000001','2023-02-21 16:16:55');
INSERT INTO `project_module_component_rely` VALUES (2,'COMPONENT0000000003','COMPONENT0000000002','2023-02-21 16:17:12');
INSERT INTO `project_module_component_rely` VALUES (3,'COMPONENT0000000005','COMPONENT0000000002','2023-02-21 16:17:27');
INSERT INTO `project_module_component_rely` VALUES (4,'COMPONENT0000000006','COMPONENT0000000005','2023-02-21 16:17:46');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template` (
  `template_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模板主键',
  `template_name` varchar(100) NOT NULL COMMENT '模板名称',
  `template_content` longtext NOT NULL COMMENT '模板内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `template` VALUES (1,'mapper.xml','<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n<!DOCTYPE mapper\r\n        PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\r\n        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n<mapper namespace=\"${table.mapperPonintPath}.${table.className}Mapper\">\r\n\r\n    <resultMap id=\"BaseResultMap\" type=\"${table.className}\">\r\n		<#list table.columnList as column>\r\n			<#if column.primary>\r\n        <id column=\"${column.columnName}\" property=\"${column.className}\" jdbcType=\"${column.jdbcType}\"/>\r\n			<#else>\r\n        <result column=\"${column.columnName}\" property=\"${column.className}\" jdbcType=\"${column.jdbcType}\"/>\r\n			</#if>\r\n		</#list>\r\n    </resultMap>\r\n\r\n    <sql id=\"BaseColumns\">\r\n		<#list table.columnList as column>\r\n        ${column.columnName}<#if column_has_next>,</#if>\r\n		</#list>\r\n    </sql>\r\n\r\n</mapper>','2022-11-29 21:33:23');
INSERT INTO `template` VALUES (2,'mapper.class','${package};\n\n${import}\nimport org.apache.ibatis.annotations.Mapper;\n\n@Mapper\npublic class ${table.className}Mapper {\n\n	\n	<#list table.columnList as column>\n    private ${column.classType} ${column.className};\n	</#list>\n	\n	<#list table.columnList as column>\n    public ${column.classType} get${column.className}() {\n        return ${column.className};\n    }\n\n    public void set${column.className}(${column.classType} ${column.className}) {\n        this.${column.className} = ${column.className};\n    }\n	\n	</#list>\n\n}\n','2022-11-29 21:34:20');
INSERT INTO `template` VALUES (3,'entity','${package};\n\n${import}\nimport org.apache.ibatis.annotations.Mapper;\n\n@Mapper\npublic class ${table.className}Entity {\n	\n	<#list table.columnList as column>\n    private ${column.classType} ${column.className};\n	</#list>\n	\n	<#list table.columnList as column>\n    public ${column.classType} get${column.className}() {\n        return ${column.className};\n    }\n\n    public void set${column.className}(${column.classType} ${column.className}) {\n        this.${column.className} = ${column.className};\n    }\n	\n	</#list>\n\n}\n','2022-11-30 10:34:01');
