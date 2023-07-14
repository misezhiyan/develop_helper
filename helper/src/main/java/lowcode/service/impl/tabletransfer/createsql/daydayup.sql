/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师关联',
  `schedule_date` date DEFAULT NULL COMMENT '日期',
  `start` varchar(100) DEFAULT NULL COMMENT '开始时间',
  `end` varchar(100) DEFAULT NULL COMMENT '结束时间',
  `status` varchar(100) DEFAULT '0' COMMENT '状态 0：正常',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='排课表';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `schedule` VALUES (28,1,'2023-07-13','15:57','15:58','0','2023-07-12 15:58:14');
INSERT INTO `schedule` VALUES (29,1,'2023-07-13','13:13','13:14','0','2023-07-13 13:13:45');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `schedule_id` int(11) DEFAULT NULL COMMENT '课程ID',
  `student_id` int(11) NOT NULL COMMENT '学生ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='课程预约';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `schedule_order` VALUES (10,29,1,'2023-07-13 17:43:29');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `no` varchar(100) DEFAULT NULL COMMENT '学号',
  `status` varchar(100) NOT NULL DEFAULT '0' COMMENT '状态 0:正常 -1:退学 1:毕业',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `student` VALUES (1,'1','1',NULL,'0','2023-07-06 17:49:24');
INSERT INTO `student` VALUES (2,'2','2',NULL,'0','2023-07-06 17:52:34');
INSERT INTO `student` VALUES (3,'2','3',NULL,'0','2023-07-06 17:53:08');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `no` varchar(100) DEFAULT NULL COMMENT '教师编号',
  `status` varchar(100) NOT NULL DEFAULT '0' COMMENT '状态 0：正常 1：不能到岗 -1：离职',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='师资';
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `teacher` VALUES (1,'1',NULL,NULL,'0','2023-07-07 10:46:06');
