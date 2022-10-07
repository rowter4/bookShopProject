use admin_db;

create table admin_users (
    username varchar(32) ,
    password varchar(256) ,
    primary key(username)
);

select * from admin_users;

delete from admin_users where username = 'test1';
insert into admin_users (username, password) values ('8658', sha1('Alpha@001')), ('93238', sha1('ImaanRowter@001'));

drop table admin_users;