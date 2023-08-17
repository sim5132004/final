create table totalkeyword (
    index_id number primary key,
    category varchar2(512),
    keywords varchar2(2054)    
);

create sequence keyword_seq 
  START WITH 1          -- ������ 1����
  INCREMENT BY 1        -- 1�� ����
  NOMAXVALUE            -- �ִ밪 ���� ����
  NOCYCLE; 

select * from totalkeyword;
drop table totalkeyword;
drop sequence keyword_seq;