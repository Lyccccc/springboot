alter table t_user add column t_pwd varchar(100);

-- 设置密码
update t_user set t_pwd = '123456' where t_name = 'coderchen';