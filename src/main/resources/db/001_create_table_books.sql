 create table book (
 id  bigserial not null,
 amount int4 not null,
 author varchar(255),
  created timestamp,
   title varchar(255),
    updated timestamp,
     category_id int8 not null,
      primary key (id))
