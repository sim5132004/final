  CREATE TABLE PLACEinfo(
    ID NUMBER NOT NULL ENABLE, 
    ī�װ� VARCHAR2(128 BYTE), 
	�Һз� VARCHAR2(128 BYTE), 
	���� VARCHAR2(256 BYTE) NOT NULL ENABLE, 
	�ּ� VARCHAR2(512 BYTE), 
	��ȭ��ȣ VARCHAR2(128 BYTE), 
	���� NUMBER, 
	�浵 NUMBER, 
	�ֿϵ������ݰ������� VARCHAR2(256 BYTE), 
	�����ü� VARCHAR2(256 BYTE), 
	���³� VARCHAR2(256 BYTE), 
	�����ð� VARCHAR2(256 BYTE), 
	�̿��� VARCHAR2(512 BYTE), 
	ȭ��Ǽ��� VARCHAR2(256 BYTE), 
	�ܱ���ȳ����� VARCHAR2(256 BYTE), 
	����谡�Կ��� VARCHAR2(128 BYTE), 
	�Ǹ�ǰ�� VARCHAR2(256 BYTE), 
	���ǽü� VARCHAR2(512 BYTE), 
	��ǥ�޴� VARCHAR2(256 BYTE), 
	���尡�ɿ��� VARCHAR2(128 BYTE), 
	�Խǽð� VARCHAR2(128 BYTE), 
	��ǽð� VARCHAR2(128 BYTE), 
	�δ�ü� VARCHAR2(512 BYTE), 
	Ű���帮��Ʈ VARCHAR2(2048 BYTE), 
	�̹����ּ�1 VARCHAR2(1024 BYTE), 
	�̹����ּ�2 VARCHAR2(1024 BYTE), 
    primary key (id)
    );
    
CREATE SEQUENCE place_seq
  START WITH 1          -- ������ 1����
  INCREMENT BY 1        -- 1�� ����
  NOMAXVALUE            -- �ִ밪 ���� ����
  NOCYCLE;              -- ����Ŭ ����    
  
COMMIT;

select * from placeinfo;

drop table placeinfo;
drop sequence place_seq;

