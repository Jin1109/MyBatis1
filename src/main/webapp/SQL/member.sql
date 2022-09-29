create table member22(
	id		 varchar2(10) primary key,
	password varchar2(10)
);

create table member22_copy 
as
select * from member22;

delete member22;

select * from member22
where id = ?

select *
from member22
where id = #{inputid}