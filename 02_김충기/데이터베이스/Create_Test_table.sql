CREATE table test(
    id number,
    test_string varchar2(50),
    test_number number,
    primary key (id)
);

CREATE SEQUENCE test_seq
  START WITH 1          -- ������ 1����
  INCREMENT BY 1        -- 1�� ����
  NOMAXVALUE            -- �ִ밪 ���� ����
  NOCYCLE;              -- ����Ŭ ����
  
insert into test (id, test_string, test_number)
values (test_seq.nextval, 'tester', 1234);

select * from test;
commit;