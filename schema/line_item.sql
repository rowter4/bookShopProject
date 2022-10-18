

create table line_item (
    item_id int,
    title varchar(512) ,
    quantity int ,
    price float(5,2) ,
    ord_id char(8) not null, 
    username varchar(32),

    primary key(item_id),
    
    constraint fk_username
		foreign key(username)
        references admin_users(username)
);