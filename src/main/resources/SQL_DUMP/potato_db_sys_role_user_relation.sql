create table sys_role_user_relation
(
    id          int         null,
    app_id      int         null,
    role_id     varchar(32) null,
    user_id     varchar(32) null,
    deleted     tinyint     null,
    create_time datetime    null,
    update_time datetime    null
);

INSERT INTO potato_db.sys_role_user_relation (id, app_id, role_id, user_id, deleted, create_time, update_time) VALUES (14, 2, 'c62978abda145a2158a65c1cdc235ec6', '534108dfc57f507e7e3bbd5e1b86b93e', 0, '2022-04-04 23:48:02', '2022-04-04 23:48:02');
INSERT INTO potato_db.sys_role_user_relation (id, app_id, role_id, user_id, deleted, create_time, update_time) VALUES (15, 2, '6e6556bdb3bf7a735d56fe4e8e6ae2ef', '44f752bd29d0f95f3f41cf93c9296c07', 0, '2022-04-04 23:48:29', '2022-04-04 23:48:29');
INSERT INTO potato_db.sys_role_user_relation (id, app_id, role_id, user_id, deleted, create_time, update_time) VALUES (16, 2, '6644897d12320a16a3123161617f9945', '44f752bd29d0f95f3f41cf93c9296c07', 0, '2022-04-04 23:48:29', '2022-04-04 23:48:29');
INSERT INTO potato_db.sys_role_user_relation (id, app_id, role_id, user_id, deleted, create_time, update_time) VALUES (18, 2, '3fd396ee47cc3da1b9b3c86851de940d', '534108dfc57f507e7e3bbd5e1b86b93e', 0, '2022-04-06 15:06:39', '2022-04-06 15:06:39');
INSERT INTO potato_db.sys_role_user_relation (id, app_id, role_id, user_id, deleted, create_time, update_time) VALUES (20, 1, '136beaf414d9d023dee528cd17c0e5de', '7f485fb4323e62dfbe947578e335d97e', 0, '2022-04-06 15:17:09', '2022-04-06 15:17:09');
INSERT INTO potato_db.sys_role_user_relation (id, app_id, role_id, user_id, deleted, create_time, update_time) VALUES (22, 1, 'c02fab47bfc678c6512c00c22d58431f', '7f485fb4323e62dfbe947578e335d97e', 0, '2022-04-06 16:09:54', '2022-04-06 16:09:54');
