create table boardEx(
	boardNo number primary key
	, boardName varchar2(30) not null
	, boardPassword varchar2(50) not null
	, boardContent varchar2(2000) not null
	, boardDate date default SYSDATE
	)
	
create sequence boardEx_seq;