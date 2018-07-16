-- 회원 정보 테이블
create table blogMember (
	id			varchar2(20) primary key,	--고객 아이디
	password	varchar2(20) not null,		--비밀번호
	name		varchar2(30) not null,		--고객 이름
	gender		varchar2(30),				--고객 성별
	email		varchar2(30) not null,		--이메일
	phone		varchar2(20) 			 	--전화번호
);

-- 게시판 본문 글
create table blogBoard (
	boardnum		number	primary key,		--글번호
	id				varchar2(20) not null,		--작성자 ID
	title			varchar2(100) not null,		--글제목
	content			varchar2(2000) not null,	--글내용
	inputdate		date	default sysdate,	--작성날짜,시간
	hits			number 	default 0,			--조회수
	originalfile	varchar2(200),				--첨부파일명 (원래 이름)
	savedfile		varchar2(100)				--첨부파일명 (실제 저장된 이름)
);

-- 게시판 일련번호에 사용할 시퀀스 
create sequence blogBoard_seq start with 1 increment by 1;

-- 리플 내용
create table blogReply (
	replynum		number	primary key,		--리플번호
	boardnum		number not null,			--본문 글번호
	id				varchar2(20) not null,		--작성자 ID
	text			varchar2(300) not null,		--리플내용
	inputdate		date 	default sysdate,	--작성날짜
	constraint blogReply_fk foreign key(boardnum) 
		references blogBoard(boardnum) on delete cascade
);

-- 리플에 사용할 시퀀스
create sequence blogReply_seq start with 1 increment by 1;










