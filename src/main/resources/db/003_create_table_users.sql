create table users (
id  bigserial not null,
 created timestamp,
  email varchar(255),
   login varchar(255),
    password varchar(255),
     updated timestamp,
     primary key (id)
     )