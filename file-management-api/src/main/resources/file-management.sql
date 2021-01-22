create database if not exists file_management default character set utf8 default collate utf8_general_ci;

/* delete table column */
alter table file_management.um_user drop user_type ;

/* add table column*/
alter table file_management.um_user add user_type int(2) comment '用户类型';

/* modify table column data type*/
alter table file_management.um_user modify column phone int(11);

/* delete exists table*/
drop table if exists file_management.um_user;

/*==============================================================*/
/* Table: um_user                                           */
/*==============================================================*/
create table file_management.um_user
(
    user_id int(11) not null auto_increment comment '主键id' primary key,
    user_name varchar(10) comment '用户名',
    password varchar(64) not null comment '密码',
    salt     varchar(5) not null  comment '盐',
    user_code varchar(20) not null comment '用户编号',
    phone varchar(11) comment '手机号',
    email      varchar(100)  comment '邮箱',
    status int(1) not null default 1  comment '状态，（-2：禁用；-1：锁定；0：未激活；1：正常）',
    last_login_time      datetime  comment '最近登录时间',
    create_time          timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
    create_user          varchar(20)  comment '创建人',
    update_time          timestamp  comment '更新时间',
    update_user          varchar(10)  comment '更新人'
);

alter table file_management.um_user comment '用户表';

drop table if exists file_management.um_company;

/*==============================================================*/
/* Table: um_company                                           */
/*==============================================================*/
create table file_management.um_company
(
    company_id           int(11)  not null auto_increment  comment '主键ID' primary key ,
    company_name         varchar(20) not null  comment '公司名称',
    description          varchar(1000)  comment '公司描述',
    status               int(1)  comment '合作状态  0 永久合作  1 不合作 ',
    source_type          int(2) not null default 0  comment '0:手动录入，1:客户资料，2:导入',
    source_id            varchar(20)  comment '数据来源ID',
    create_time          timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
    create_user          varchar(20)  comment '创建人',
    update_time          timestamp  comment '更新时间',
    update_user          varchar(10)  comment '更新人'
);
alter table file_management.um_company comment '公司表';

/*==============================================================*/
/* Table: um_company_user                                      */
/*==============================================================*/
create table file_management.um_company_user
(
    id                   int(11) not null auto_increment comment '主键ID' primary key ,
    company_id           int(11) not null  comment '公司ID',
    user_id              int(11) not null  comment '用户ID'
);

alter table file_management.um_company_user comment '公司用户关系表';

/*==============================================================*/
/* Index: INDEX_COMPANY_USER
/*==============================================================*/
create unique index INDEX_COMPANY_USER on file_management.um_company_user
    (
     company_id,
     user_id
        );

drop table if exists file_management.um_role;

/*==============================================================*/
/* Table: um_role                                              */
/*==============================================================*/
create table file_management.um_role
(
    role_id              int(11) not null auto_increment  comment '主键ID' primary key ,
    role_name            national varchar(50) not null  comment '角色名称',
    role_node            national varchar(200)  comment '角色描述',
    status               int(1)  comment '角色状态 -1 禁用 0 正常',
    is_admin             tinyint(1) not null default 1  comment '是否超级管理员角色 0 管理员 1 普通用户',
    seq                  int(2) not null  comment '排序',
    data_scope           int(1)  comment '1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限',
    is_delete            int(1) not null default 1 comment '是否删除 -1 删除 0 正常',
    create_time          timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
    create_user          varchar(20)  comment '创建人',
    update_time          timestamp  comment '更新时间',
    update_user          varchar(10)  comment '更新人'
);

alter table file_management.um_role comment '角色表';

drop table if exists file_management.um_role_user;

/*==============================================================*/
/* Table: um_role_user                      */
/*==============================================================*/
create table file_management.um_role_user
(
    id                   int(11) not null  auto_increment comment '主键ID' primary key,
    role_id              int(11) not null  comment '角色ID',
    user_id              int(11) not null  comment '用户ID'
);

alter table file_management.um_role_user comment '用户角色表关联表（N -1）';

/*==============================================================*/
/* Index: INDEX_ROLE_USER                                       */
/*==============================================================*/
create unique index INDEX_ROLE_USER on file_management.um_role_user
    (
     role_id,
     user_id
        );

drop table if exists file_management.um_menu;

/*==============================================================*/
/* Table: um_menu                                              */
/*==============================================================*/
create table file_management.um_menu
(
    menu_id              int(11) not null auto_increment  comment '菜单id' primary key ,
    menu_name            varchar(30) not null comment '菜单名称',
    parent_id            int(11) not null default 0 comment '父菜单ID',
    seq                  int(4)  comment '显示顺序',
    url                  varchar(50)  comment '请求地址',
    menu_type            char(1)  comment '菜单类型（M目录 C菜单 F按钮）',
    status               int(1) not null default 0 comment '菜单状态（0显示 -1隐藏）',
    perms                varchar(100)  comment '权限标识',
    icon                 varchar(100)  comment '菜单图标',
    is_delete            int(1) not null default 0 comment '删除标志 0 正常 -1删除(禁用)',
    remark               varchar(200)  comment '备注',
    create_time          timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
    create_user          varchar(20)  comment '创建人',
    update_time          timestamp  comment '更新时间',
    update_user          varchar(10)  comment '更新人'
);

alter table file_management.um_menu comment '菜单权限';

drop table if exists file_management.um_role_menu;

/*==============================================================*/
/* Table: um_role_menu                                         */
/*==============================================================*/
create table file_management.um_role_menu
(
    id                   int(11) not null auto_increment  comment '主键ID' primary key ,
    role_id              int(11) not null  comment '角色ID',
    menu_id              int(11) not null  comment '用户ID'
);

alter table file_management.um_role_menu comment '角色和菜单关联表（1-N）';

/*==============================================================*/
/* Index: INDEX_ROLE_USER                                         */
/*==============================================================*/
create unique index INDEX_ROLE_USER on file_management.um_role_menu
    (
     role_id,
     menu_id
        );


drop table if exists file_management.um_dept;

/*==============================================================*/
/* Table: um_dept                                              */
/*==============================================================*/
create table file_management.um_dept
(
    dept_id              int(11) not null auto_increment  comment '部门id' primary key ,
    parent_id            int(11) not null  comment '父部门id',
    ancestors            varchar(50)  comment '祖父列表',
    dept_name            varchar(30)  comment '部门名称',
    seq                  int(4) not null  comment '显示顺序',
    leader               varchar(20)  comment '负责人',
    phone                varchar(12)  comment '联系电话',
    email                varchar(50)  comment '邮箱',
    status               int(1) not null  comment '部门状态 0 正常 -1停用',
    is_delete            int(1) not null  comment '删除标志 0 正常 -1删除',
    create_time          timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
    create_user          varchar(20)  comment '创建人',
    update_time          timestamp  comment '更新时间',
    update_user          varchar(10)  comment '更新人'
);

alter table file_management.um_dept comment '部门表';


/*==============================================================*/
/* Table: um_role_dept                                         */
/*==============================================================*/
create table file_management.um_role_dept
(
    id                   int(11) not null auto_increment  comment '主键ID' primary key ,
    role_id              int(11) not null  comment '角色ID',
    dept_id              int(11) not null  comment '用户ID'
);

alter table file_management.um_role_dept comment '角色和部门关联表  (1-N)';

/*==============================================================*/
/* Index: INDEX_ROLE_USER                                       */
/*==============================================================*/
create unique index INDEX_ROLE_USER on file_management.um_role_dept
    (
     role_id,
     dept_id
        );
