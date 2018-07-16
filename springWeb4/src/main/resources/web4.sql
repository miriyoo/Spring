-- springWeb4 예제의 방명록 글 저장 테이블

create table web4board (
	boardnum		number	primary key,		--글번호
	name			varchar2(20) not null,		--작성자 이름
	password		varchar2(20) not null,		--삭제시 사용할 비밀번호
	content			varchar2(2000) not null,	--글내용
	inputdate		date	default sysdate		--작성날짜,시간
);

-- 글일련번호에 사용할 시퀀스 
create sequence web4board_seq start with 1 increment by 1;

-- 글 저장 예
insert into web4board (boardnum, name, password, content) 
values (web4board_seq.nextval, '홍길동', '111', '글내용');
