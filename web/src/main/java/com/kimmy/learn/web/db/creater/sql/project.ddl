CREATE TABLE `project` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `project_name` varchar(100) NOT NULL COMMENT '项目名称',
                           `base_url` varchar(100) DEFAULT NULL COMMENT '项目基本地址',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8