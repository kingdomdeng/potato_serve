CREATE TABLE `sys_user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `app_id` int(11) NOT NULL DEFAULT 1,
    `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `disabled` tinyint(1) NOT NULL DEFAULT 0,
    `deleted` tinyint(1) NOT NULL DEFAULT 0,
    `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
)

CREATE TABLE `sys_menu` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `menu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `app_id` int(11) NOT NULL DEFAULT 1,
    `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `disabled` tinyint(1) NOT NULL DEFAULT 0,
    `deleted` tinyint(1) NOT NULL DEFAULT 0,
    `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
)

CREATE TABLE `sys_role` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `app_id` int(11) NOT NULL DEFAULT 1,
    `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `disabled` tinyint(1) NOT NULL DEFAULT 0,
    `deleted` tinyint(1) NOT NULL DEFAULT 0,
    `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
)

CREATE TABLE `sys_role_user_relation` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `app_id` int(11) NOT NULL DEFAULT 1,
    `role_id` varchar(32) NOT NULL,
    `user_id` varchar(32) NOT NULL,
    `deleted` tinyint(1) NOT NULL DEFAULT 0,
    `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
)

CREATE TABLE `sys_role_menu_relation` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `app_id` int(11) NOT NULL DEFAULT 1,
    `role_id` varchar(32) NOT NULL,
    `menu_id` varchar(32) NOT NULL,
    `deleted` tinyint(1) NOT NULL DEFAULT 0,
    `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
)