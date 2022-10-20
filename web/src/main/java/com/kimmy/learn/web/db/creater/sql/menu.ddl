CREATE TABLE `menu` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
                        `menu_code` varchar(100) NOT NULL COMMENT '菜单码',
                        `sort` int(11) NOT NULL COMMENT '排序',
                        `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态 1：启用  -1禁用',
                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8