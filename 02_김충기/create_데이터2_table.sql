  CREATE TABLE PLACEinfo(
    ID NUMBER NOT NULL ENABLE, 
    카테고리 VARCHAR2(128 BYTE), 
	소분류 VARCHAR2(128 BYTE), 
	제목 VARCHAR2(256 BYTE) NOT NULL ENABLE, 
	주소 VARCHAR2(512 BYTE), 
	전화번호 VARCHAR2(128 BYTE), 
	위도 NUMBER, 
	경도 NUMBER, 
	애완동물동반가능정보 VARCHAR2(256 BYTE), 
	주차시설 VARCHAR2(256 BYTE), 
	쉬는날 VARCHAR2(256 BYTE), 
	영업시간 VARCHAR2(256 BYTE), 
	이용요금 VARCHAR2(512 BYTE), 
	화장실설명 VARCHAR2(256 BYTE), 
	외국어안내서비스 VARCHAR2(256 BYTE), 
	사고보험가입여부 VARCHAR2(128 BYTE), 
	판매품목 VARCHAR2(256 BYTE), 
	편의시설 VARCHAR2(512 BYTE), 
	대표메뉴 VARCHAR2(256 BYTE), 
	포장가능여부 VARCHAR2(128 BYTE), 
	입실시간 VARCHAR2(128 BYTE), 
	퇴실시간 VARCHAR2(128 BYTE), 
	부대시설 VARCHAR2(512 BYTE), 
	키워드리스트 VARCHAR2(2048 BYTE), 
	이미지주소1 VARCHAR2(1024 BYTE), 
	이미지주소2 VARCHAR2(1024 BYTE), 
    primary key (id)
    );
    
CREATE SEQUENCE place_seq
  START WITH 1          -- 시작을 1부터
  INCREMENT BY 1        -- 1씩 증가
  NOMAXVALUE            -- 최대값 제한 없음
  NOCYCLE;              -- 사이클 없음    
  
COMMIT;

select * from placeinfo;

drop table place_backup;
drop sequence place_seq;

select unique(카테고리) from placeinfo;

select 카테고리 as category, 소분류 as smallcategory, 제목 as title,
주소 as address, 전화번호 as tel, 위도 as latitude, 경도 as longitude,
애완동물동반가능정보 as petInfo, 주차시설 as parkingInfo, 쉬는날 as restDayInfo,
영업시간 as runTimeInfo, 이용요금 as feeInfo, 화장실설명 as toiletInfo,
외국어안내서비스 as languageInfo, 사고보험가입여부 as insuranceInfo,
판매품목 as salesItemInfo, 편의시설 as amenityInfo, 대표메뉴 as menuInfo,
포장가능여부 as wrapInfo, 입실시간 as checkinInfo, 퇴실시간 as checkoutInfo,
부대시설 as otherAmenityInfo, 키워드리스트 as keyword,
이미지주소1 as imageAdd1, 이미지주소2 as imageAdd2
        from placeinfo
        where 제목 like '%강화도%'
