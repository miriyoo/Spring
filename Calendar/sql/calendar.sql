drop table calendar;

create table calendar(
	calendarno number primary key
	,day		varchar2(30)
	,title	varchar2(100)
	,address	varchar2(100)
	,detail		varchar2(500)
	,setTime    varchar2(30)
);

create sequence calendarno_seq start with 1 increment by 1;