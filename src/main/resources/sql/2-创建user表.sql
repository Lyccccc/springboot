create table t_user(
`t_id` int auto_increment,
`t_name` varchar(20) not null default '',
`t_age` int not null default 0,
`t_address` varchar(100) not null default '',
primary key (t_id)
)engine=InnoDB, charset = utf8, auto_increment = 1001;

-- 测试数据
insert into t_user(t_name, t_age, t_address) values ('coderchen', 26, '中国');
insert into t_user(t_name, t_age, t_address) values ('zhangsan', 24, '美国');