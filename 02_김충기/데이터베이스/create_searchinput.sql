create table searchinput (
    sequenceid number,
    category varchar2(256),
    keyword varchar2(256),
    address varchar2(256)
);

drop table searchinput;
drop sequence searchinput_seq;

CREATE SEQUENCE searchinput_seq
  START WITH 1          -- ������ 1����
  INCREMENT BY 1        -- 1�� ����
  NOMAXVALUE            -- �ִ밪 ���� ����
  NOCYCLE;    
  select * from placeinfo;
select * from searchinput;
select * from searchresult;
select * from placeinfo where ���� like '%3S%';
insert into searchinput(sequenceid, category, keyword, address)
values(searchinput_seq.nextval, '����', '����', '����');
insert into searchinput(sequenceid, category, keyword, address)
values(searchinput_seq.nextval, '����', '', '�߱�');
commit;