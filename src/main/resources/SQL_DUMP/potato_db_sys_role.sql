create table sys_role
(
    id          int          null,
    role_id     varchar(32)  null,
    app_id      int          null,
    name        varchar(255) null,
    remark      varchar(255) null,
    disabled    tinyint      null,
    deleted     tinyint      null,
    create_time datetime     null,
    update_time datetime     null
);

INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (1, 'f3235fb00726e0b8c720c715e42487d4', 0, 'test5', 'remark test1', 0, 0, '2022-04-01 16:54:13', '2022-04-01 16:54:13');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (2, '5ba6d7eecd229e6c1d1d6b4e637b7de5', 0, 'test5', 'remark test1', 0, 0, '2022-04-01 16:54:21', '2022-04-01 16:54:21');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (3, '6185c227d716288b95b237e15052a418', 0, 'name233', 'remark233', 0, 0, '2022-04-01 16:54:22', '2022-04-01 16:55:41');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (4, '78fa4949768ece8b69839bbbb2e9f01a', 0, 'test5', 'remark test1', 0, 1, '2022-04-01 16:54:28', '2022-04-01 16:57:25');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (5, 'b87a70c70e26dc2db3009430882565a5', 0, 'test5', 'remark test1', 0, 1, '2022-04-01 16:54:29', '2022-04-03 23:14:55');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (6, '7eb2ec3159b394f3504fb72554c0531b', 2, '角色1编辑', '不禁用', 0, 0, '2022-04-03 23:20:35', '2022-04-03 23:23:25');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (7, '6e6556bdb3bf7a735d56fe4e8e6ae2ef', 2, '管理员', '', 0, 0, '2022-04-04 23:44:38', '2022-04-04 23:44:38');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (8, '6644897d12320a16a3123161617f9945', 2, '超级管理员', '', 0, 0, '2022-04-04 23:44:47', '2022-04-04 23:44:47');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (9, 'c62978abda145a2158a65c1cdc235ec6', 2, '二级管理员', '', 0, 0, '2022-04-04 23:44:56', '2022-04-04 23:44:56');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (10, '9e59d3925381b2119a3341bf5d7ddec8', 2, '一级管理员', '', 0, 0, '2022-04-04 23:59:21', '2022-04-04 23:59:21');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (11, 'c02fab47bfc678c6512c00c22d58431f', 1, '分区管理员', '', 0, 0, '2022-04-04 23:59:30', '2022-04-04 23:59:30');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (12, '3105850e41319e18ab0eebf2c7346bdf', 2, '区域管理员', '', 0, 0, '2022-04-05 00:00:03', '2022-04-05 00:00:03');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (13, '3fd396ee47cc3da1b9b3c86851de940d', 2, '分组管理员', '', 0, 0, '2022-04-05 00:00:27', '2022-04-05 00:00:27');
INSERT INTO potato_db.sys_role (id, role_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (14, '136beaf414d9d023dee528cd17c0e5de', 1, '应用1管理员', '', 0, 0, '2022-04-06 15:16:49', '2022-04-06 15:16:49');
