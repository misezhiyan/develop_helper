CREATE TABLE `db_connect_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `db_type` int(11) NOT NULL COMMENT '数据库类型',
  `ip` varchar(25) NOT NULL COMMENT '连接库IP',
  `port` int(11) NOT NULL COMMENT '数据库连接端口',
  `dbname` varchar(100) NOT NULL COMMENT '连接库名',
  `driver-class-name` varchar(100) NOT NULL COMMENT '驱动类名',
  `name` varchar(100) NOT NULL COMMENT '登录用户名',
  `password` varchar(100) NOT NULL COMMENT '登录用户密码',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态 0:禁用 1:正常',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据库链接配置'