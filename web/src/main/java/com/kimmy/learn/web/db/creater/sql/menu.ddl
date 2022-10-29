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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(1, '菜单', '01', '', 1, -1, 1, '2022-10-13 17:11:35', '2022-10-25 16:07:40');
INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(2, '数据库', '02', '', 2, -1, 1, '2022-10-14 17:57:27', '2022-10-20 16:47:41');
INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(3, '数据库列表', '02', '/db/index', 3, 2, 1, '2022-10-14 17:57:27', '2022-10-25 16:04:51');
INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(4, '数据库配置', '03', '/db/dbConfig', 4, 2, 1, '2022-10-14 17:57:27', '2022-10-20 11:32:27');
INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(11, '表生成结构', 'tableToJava', '/tableToJava/index', 0, -1, 1, '2022-10-20 18:36:36', '2022-10-25 16:04:51');
INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(12, '菜单配置', '01', '/menu/index', 4, 1, 1, '2022-10-25 16:07:40', '2022-10-25 16:07:40');
INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(13, '项目', '2', '', 0, -1, 1, '2022-10-25 16:42:31', '2022-10-25 16:42:31');
INSERT INTO datadeal.menu
(id, menu_name, menu_code, `path`, sort, parent_id, status, create_time, update_time)
VALUES(14, '项目配置', '2', '/project/index', 0, 13, 1, '2022-10-25 16:43:07', '2022-10-25 16:43:07');
