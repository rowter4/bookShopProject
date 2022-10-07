use admin_db;


create table book_details (

    book_id int auto_increment,
    added_by int,
    description text,
    format varchar(64),
    authors varchar(512) not null,
    edition varchar(64) default '',
    title varchar(512) not null,
    genres varchar(512),
    pages int default 0,
	rating float(3, 2) default 1.0,
    price float(5, 2) default 1.0,
	pic mediumblob,

	primary key(book_id)

);


   
    
    
    
 
   

    