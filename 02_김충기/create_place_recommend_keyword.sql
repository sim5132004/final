create table placerecommend (
    sequenceid number primary key,
    ī�װ� varchar2(128),
    ���� varchar2(512),
    �������� varchar2(512),
    �Ÿ� varchar2(128),
    id number,
    FOREIGN KEY (id) REFERENCES placeinfo(id)
    );
    
CREATE SEQUENCE placerecommend_seq
  START WITH 1          -- ������ 1����
  INCREMENT BY 1        -- 1�� ����
  NOMAXVALUE            -- �ִ밪 ���� ����
  NOCYCLE;
    
    
    