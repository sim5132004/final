  CREATE TABLE Client(
    sequenceID NUMBER NOT NULL ENABLE, 
    clientID VARCHAR2(128 BYTE) NOT NULL unique, 
	password VARCHAR2(128 BYTE) not null, 
    clientEmail VARCHAR2(512 BYTE) not null unique, 
    keyword VARCHAR2(2056 byte),
    primary key(sequenceid)
    );
    
CREATE SEQUENCE client_seq
  START WITH 1          -- ������ 1����
  INCREMENT BY 1        -- 1�� ����
  NOMAXVALUE            -- �ִ밪 ���� ����
  NOCYCLE;              -- ����Ŭ ����

drop table client;
drop sequence client_seq;

insert into client(sequenceid, clientid, password, clientemail, keyword)
values(client_seq.nextval, 'tester', 'test', 'test@test.com', '');

select * from client;
commit;