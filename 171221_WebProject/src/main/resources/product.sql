create table productTable(
    productNo number primary key
    , productName varchar2(100) not null
    , productPrice number not null
    , productImgPath varchar2(100) not null
    )
    
create sequence product_seq;