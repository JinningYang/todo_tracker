-- create table todo (
--                       id bigint not null,
--                       description varchar(255),
--                       is_done boolean not null,
--                       target_date timestamp,
--                       username varchar(255),
--                       primary key (id));

insert into todo(id, username,description,target_date,is_done)
values(10001, 'JennieYang', 'Learn JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10002, 'JennieYang', 'Learn Data JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10003, 'JennieYang', 'Learn Microservices', sysdate(), false);