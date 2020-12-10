create database if not exists long_blog;

use long_blog;

-- ----------------------------
-- 用户表
-- ----------------------------
drop table if exists `user`;
create table `user` (
  `user_id` bigint(20) not null auto_increment comment '用户Id',
  `username` varchar(100) character set utf8 collate utf8_general_ci null default null comment '用户名',
  `password` varchar(100) character set utf8 collate utf8_general_ci null default null comment '用户密码',
  `nickname` varchar(100) character set utf8 collate utf8_general_ci null default null comment '昵称',
  `avatar` varchar(200) character set utf8 collate utf8_general_ci null default null comment '头像',
  `gender` tinyint(4) not null default 1 comment '性别，0-男，1-女',
  `birth` date default null comment '生日，格式为: yyyy-MM-dd',
  `email` varchar(50) character set utf8 collate utf8_general_ci null default null comment '邮箱',
  `signature` varchar(255) character set utf8 collate utf8_general_ci null default null comment '个性签名',
  `school` varchar(50) character set utf8 collate utf8_general_ci null default null comment '学校',
  `professional` varchar(50) character set utf8 collate utf8_general_ci null default null comment '专业',
  `graduation_time` date default null comment '毕业时间，格式为: yyyy-MM-dd',
  `work` varchar(100) character set utf8 collate utf8_general_ci null default null comment '工作',
  `position` varchar(50) character set utf8 collate utf8_general_ci null default null comment '职位',
  `work_time` date default null comment '工作时间，格式为: yyyy-MM-dd',
  `skills` varchar(255) character set utf8 collate utf8_general_ci null default null comment '擅长技能',
  `user_status` tinyint(4) unsigned not null default 1 comment '用户状态，0-禁用(锁定)，1-正常',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `finally_login_time` datetime(0) null default null comment '最后登录时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`user_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '用户表';


-- ----------------------------
-- 角色表
-- ----------------------------
drop table if exists `role`;
create table `role` (
  `role_id` bigint(20) not null auto_increment comment '角色Id',
  `role_name` varchar(100) character set utf8 collate utf8_general_ci null default null comment '角色名称',
  `user_count` int(11) not null DEFAULT 0 comment '用户数量',
  `role_status` tinyint(4) unsigned not null default 1 comment '角色状态，0-未启用，1-已启用',
  `create_user` bigint(20) not null default -1 comment '创建角色用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`role_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '角色表';


-- ----------------------------
-- 用户-角色表
-- ----------------------------
drop table if exists `user_role`;
create table `user_role` (
  `id` bigint(20) not null auto_increment comment '自增Id',
  `user_id` bigint(20) not null default -1 comment '用户Id',
  `role_id` bigint(20) not null default -1 comment '角色Id',
  `operate_user` bigint(20) not null default -1 comment '操作用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '用户-角色表';


-- ----------------------------
-- 博客表
-- ----------------------------
drop table if exists `blog`;
create table `blog` (
  `blog_id` bigint(20) not null auto_increment comment '博客Id',
  `blog_title` varchar(100) character set utf8 collate utf8_general_ci null default null unique comment '博客标题',
  `creation_type` tinyint(4) not null default 0 comment '创作类型，0-原创，1-转载，2-翻译，3-随笔',
  `type_id` bigint(20) not null default -1 comment '类型Id，表示博客所属类型',
  `first_picture` varchar(200) character set utf8 collate utf8_general_ci null default null comment '博客首图',
  `blog_content` text character set utf8 collate utf8_general_ci null default null comment '博客内容',
  `blog_description` varchar(500) character set utf8 collate utf8_general_ci null default null comment '博客描述',
  `label` varchar(100) character set utf8 collate utf8_general_ci null default null comment '标签',
  `is_published` tinyint(4) unsigned not null default 0 comment '是否发布，0-不发布，1-已发布',
  `is_commendable` tinyint(4) unsigned not null default 0 comment '是否开启赞赏，0-不开启赞赏，1-开启赞赏',
  `is_recommend` tinyint(4) unsigned not null default 0 comment '是否推荐，0-不推荐，1-推荐',
  `views_count` int(11) not null default 0 comment '浏览数量',
  `comment_count` int(11) not null default 0 comment '评论数量',
  `collect_count` int(11) not null default 0 comment '收藏数量',
  `commendable_count` int(11) not null default 0 comment '赞赏数量',
  `create_user` bigint(20) not null default -1 comment '创建博客用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`blog_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '博客表';


-- ----------------------------
-- 博客类型表
-- ----------------------------
drop table if exists `blog_type`;
create table `blog_type` (
  `type_id` bigint(20) not null auto_increment comment '博客类型Id',
  `type_name` varchar(100) character set utf8 collate utf8_general_ci null default null comment '类型名称',
  `blog_count` int(11) not null default 0 comment '博客数量',
  `file_count` int(11) not null default 0 comment '文件数量',
  `type_status` tinyint(4) unsigned not null default 1 comment '博客类型状态，0-未启用，1-已启用',
  `create_user` bigint(20) not null default -1 comment '创建博客类型用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`type_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '博客类型表';


-- ----------------------------
-- 博客评论表
-- ----------------------------
drop table if exists `comment`;
create table `comment` (
  `comment_id` bigint(20) not null auto_increment comment '评论Id',
  `blog_id` bigint(20) not null default -1 comment '所属博客Id',
  `create_user` bigint(20) not null default -1 comment '创建评论用户Id',
  `comment_content` varchar(500) character set utf8 collate utf8_general_ci null default null comment '评论内容',
  `parent_comment_id` bigint(20) not null default -1 comment '父评论Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`comment_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '博客评论表';


-- ----------------------------
-- 友链表
-- ----------------------------
drop table if exists `friend_link`;
create table `friend_link` (
  `friend_link_id` bigint(20) not null auto_increment comment '友链Id',
  `blog_address` varchar(200) character set utf8 collate utf8_general_ci null default null unique comment '博客地址(url)',
  `blog_name` varchar(100) character set utf8 collate utf8_general_ci null default null comment '博客名称',
  `picture_address` varchar(200) character set utf8 collate utf8_general_ci not null default '' comment '图片链接',
  `friend_status` tinyint(4) unsigned not null default 0 comment '友链状态，0-未开启，1-已开启',
  `create_user` bigint(20) not null default -1 comment '创建友链用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`friend_link_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '友链表';


-- ----------------------------
-- 留言表
-- ----------------------------
drop table if exists `message`;
create table `message`  (
  `message_id` bigint(20) not null auto_increment comment '留言Id',
  `create_user` bigint(20) not null default -1 comment '新增留言用户Id',
  `target_user` bigint(20) not null default -1 comment '目标用户Id',
  `message_content` varchar(1000) character set utf8 collate utf8_general_ci null default null comment '留言内容',
  `parent_message_id` bigint(20) not null default -1 comment '父留言Id',
  `message_status` tinyint(4) unsigned not null default 0 comment '是否回复，0-未回复，1-已回复',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`message_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '留言表';

-- ----------------------------
-- 图库表
-- ----------------------------
drop table if exists `gallery`;
create table `gallery`  (
  `picture_id` bigint(20) not null auto_increment comment '图片Id',
  `picture_address` varchar(200) character set utf8 collate utf8_general_ci null default null comment '图片地址',
  `picture_name` varchar(100) character set utf8 collate utf8_general_ci null default null unique comment '图片名称',
  `picture_description` varchar(200) character set utf8 collate utf8_general_ci null default null comment '图片描述',
  `picture_type` tinyint(4) not null default 0 comment '图片类型，0-相册，1-博客，2-背景，3-头像，4-友链',
  `use_count` int(11) not null default 0 comment '被使用数量',
  `create_user` bigint(20) not null default -1 comment '新增图片用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`picture_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '图库表';


-- ----------------------------
-- 备忘录表
-- ----------------------------
drop table if exists `memo`;
create table `memo` (
  `memo_id` bigint(20) not null auto_increment comment '备忘录Id',
  `memo_title` varchar(100) character set utf8 collate utf8_general_ci null default null unique comment '备忘录标题',
  `memo_content` varchar(1000) character set utf8 collate utf8_general_ci null default null comment '备忘录内容',
  `memo_status` tinyint(4) unsigned not null default 0 comment '备忘录状态，0-未完成，1-已完成',
  `create_user` bigint(20) not null default -1 comment '创建备忘录用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`memo_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '备忘录表';

-- ----------------------------
-- 待办表
-- ----------------------------
drop table if exists `todo`;
create table `todo` (
  `todo_id` bigint(20) not null auto_increment comment '待办事项Id',
  `todo_title` varchar(100) character set utf8 collate utf8_general_ci null default null unique comment '待办事项标题',
  `todo_description` varchar(200) character set utf8 collate utf8_general_ci null default null comment '待办事项描述',
  `todo_status` tinyint(4) unsigned not null default 0 comment '待办事项状态，0-未完成，1-已完成，2-超时',
  `deadline` datetime(0) null default null comment '截止时间',
  `create_user` bigint(20) not null default -1 comment '创建待办事项用户Id',
  `gmt_create` datetime(0) default current_timestamp comment '创建时间',
  `gmt_modified` datetime(0) default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` tinyint(4) unsigned not null default 0 comment '是否删除，0-不删除，1-删除',
  primary key (`todo_id`) using btree
) engine = InnoDB character set = utf8 collate = utf8_general_ci comment '待办表';
