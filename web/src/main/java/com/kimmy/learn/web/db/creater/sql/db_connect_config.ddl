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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='数据库链接配置'