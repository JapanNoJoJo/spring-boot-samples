drop table if exists t_person;
create table t_person (
  id bigserial primary key,
  username varchar(16) not null,
  age int4
);

insert into public.t_person (username,age)
values ('Jack','18');
insert into public.t_person (username,age)
values ('Smith','24');
insert into public.t_person (username,age)
values ('Tom','41');
