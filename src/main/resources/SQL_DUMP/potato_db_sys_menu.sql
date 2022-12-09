create table sys_menu
(
    id          int          null,
    menu_id     varchar(32)  null,
    parent_id   varchar(32)  null,
    app_id      int          null,
    icon        varchar(255) null,
    url         varchar(255) null,
    name        varchar(255) null,
    remark      varchar(255) null,
    disabled    tinyint      null,
    deleted     tinyint      null,
    create_time datetime     null,
    update_time datetime     null
);

INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (2, '05db00fdbe1ec386ab42b132d62f6a3c', null, 0, null, 'url', 'test5', 'remark test1', 0, 1, '2022-04-01 15:42:04', '2022-04-01 16:15:40');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (5, '6f6fd84190d9233869ca057c64deb8e4', null, 0, null, 'url', 'test5', 'remark test1', 0, 0, '2022-04-01 15:52:26', '2022-04-01 15:52:26');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (8, 'e2d74a3af0625a76a61c61f300941d20', null, 0, null, 'remark test1', 'name233', 'remark233', 0, 0, '2022-04-01 15:52:29', '2022-04-01 15:59:23');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (9, 'e640773f129431046d1a90436ba5e215', null, 0, null, 'url', 'test5', 'remark test1', 0, 0, '2022-04-01 15:52:30', '2022-04-01 15:52:30');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (10, '2bbcf5a2f0b346220cba33c8abfa58bb', '', 1, 'icon', 'http://localhost:8081/menu', '菜单1', '123', 0, 0, '2022-04-03 16:26:32', '2022-04-06 11:34:17');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (11, 'dcae07ce34096e3c0e421758eba4037b', null, 1, 'icon', 'url', '菜单2', '123', 0, 1, '2022-04-03 16:27:28', '2022-04-03 22:54:36');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (12, '859c2092953b51f71efd1e3a782cad74', null, 1, 'icon12', 'url2', '菜单33', '123', 0, 1, '2022-04-03 16:28:55', '2022-04-03 22:54:32');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (13, '60a778137f1e89280f56c51e466203fc', null, 2, 'icon', 'url', '菜单2编辑', '123', 0, 1, '2022-04-03 17:52:33', '2022-04-03 22:54:28');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (14, '611928b609395a9595bce2b18b21d544', null, 2, '1', '1', '应用2菜单', '禁用', 1, 0, '2022-04-03 23:21:20', '2022-04-03 23:21:20');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (15, '312f0ce9190e3b02eadff0822ec9c051', null, 2, '1', '1', '菜单2', '', 0, 0, '2022-04-05 10:36:25', '2022-04-05 10:36:25');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (16, '4fdf9c86608f39b4807969175cb91e1d', '2bbcf5a2f0b346220cba33c8abfa58bb', 1, '1', '1', '子级菜单', '', 0, 0, '2022-04-05 11:29:49', '2022-04-05 11:29:49');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (17, 'af0b6811a259a8ab445ea72fe6d0db7b', '', 1, '1', '1', '三级菜单', '', 0, 0, '2022-04-05 11:36:18', '2022-04-06 11:34:37');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (18, '34604c5b671ce1f924db0ad413765b45', 'af0b6811a259a8ab445ea72fe6d0db7b', 1, '1', '1', '四级菜单', '', 0, 0, '2022-04-05 11:37:05', '2022-04-06 11:34:42');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (19, '56bd1c24bf8efbe04f90e51cc100d00d', '2bbcf5a2f0b346220cba33c8abfa58bb', 1, '1', '1', '菜单1子菜单2', '', 0, 0, '2022-04-06 14:17:05', '2022-04-06 14:17:05');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (20, '2f1673745c813553c7c9bdf1c55e508a', 'af0b6811a259a8ab445ea72fe6d0db7b', 1, 'plus', 'menu', '三级菜单子菜单1', '', 0, 0, '2022-12-08 13:02:31', '2022-12-08 13:02:31');
INSERT INTO potato_db.sys_menu (id, menu_id, parent_id, app_id, icon, url, name, remark, disabled, deleted, create_time, update_time) VALUES (21, 'fafd482ab2d141cd116f0476d484367c', '', 0, '', '', '', '', 0, 0, '2022-12-08 19:57:18', '2022-12-08 19:57:18');
