create table sys_user
(
    id          int          null,
    user_id     varchar(32)  null,
    app_id      int          null,
    name        varchar(255) null,
    remark      varchar(255) null,
    disabled    tinyint      null,
    deleted     tinyint      null,
    create_time datetime     null,
    update_time datetime     null
);

INSERT INTO potato_db.sys_user (id, user_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (1, 'dae0385e1196f0967e8eac93fa3500a2', 1, 'test333', 'remark test1', 1, 0, '2022-04-01 15:40:46', '2022-04-01 15:40:46');
INSERT INTO potato_db.sys_user (id, user_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (2, 'd0939e9c73d6f8fad164e2362291967d', 1, 'test333', 'remark test1', 0, 0, '2022-04-01 15:51:49', '2022-04-03 23:10:52');
INSERT INTO potato_db.sys_user (id, user_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (5, '7e4d927ae81959772619013a399e9eb2', 1, '用户2', '233', 1, 0, '2022-04-03 23:11:37', '2022-04-03 23:11:37');
INSERT INTO potato_db.sys_user (id, user_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (6, '7f485fb4323e62dfbe947578e335d97e', 1, '应用2用户', '禁用', 1, 0, '2022-04-03 23:21:40', '2022-04-03 23:21:40');
INSERT INTO potato_db.sys_user (id, user_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (7, '534108dfc57f507e7e3bbd5e1b86b93e', 2, '应用2用户3', '', 0, 0, '2022-04-03 23:25:32', '2022-04-03 23:25:32');
INSERT INTO potato_db.sys_user (id, user_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (8, '44f752bd29d0f95f3f41cf93c9296c07', 2, '张三', '', 0, 0, '2022-04-04 23:48:18', '2022-04-04 23:48:18');
INSERT INTO potato_db.sys_user (id, user_id, app_id, name, remark, disabled, deleted, create_time, update_time) VALUES (9, '2c90e9d48712285708e7f71f07e990c3', 1, '2', '', 0, 0, '2022-12-09 14:18:31', '2022-12-09 14:19:57');
