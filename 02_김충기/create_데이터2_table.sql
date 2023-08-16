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

drop table place_backup;
drop sequence place_seq;

select unique(ī�װ�) from placeinfo;

select ī�װ� as category, �Һз� as smallcategory, ���� as title,
�ּ� as address, ��ȭ��ȣ as tel, ���� as latitude, �浵 as longitude,
�ֿϵ������ݰ������� as petInfo, �����ü� as parkingInfo, ���³� as restDayInfo,
�����ð� as runTimeInfo, �̿��� as feeInfo, ȭ��Ǽ��� as toiletInfo,
�ܱ���ȳ����� as languageInfo, ����谡�Կ��� as insuranceInfo,
�Ǹ�ǰ�� as salesItemInfo, ���ǽü� as amenityInfo, ��ǥ�޴� as menuInfo,
���尡�ɿ��� as wrapInfo, �Խǽð� as checkinInfo, ��ǽð� as checkoutInfo,
�δ�ü� as otherAmenityInfo, Ű���帮��Ʈ as keyword,
�̹����ּ�1 as imageAdd1, �̹����ּ�2 as imageAdd2
        from placeinfo
        where ���� like '%��ȭ��%'
