use admin_db;

describe line_item;

create table order_summary (
	ord_id char(8) not null,
    username varchar(256) not null,
    total float(5,2) default 1.00,
    
	primary key(ord_id),
    
    constraint fk_username_2
		foreign key(username)
        references admin_users(username)
);