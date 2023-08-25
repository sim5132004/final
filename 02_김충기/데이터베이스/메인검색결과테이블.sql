select * from searchresult;
select * from main_result;
commit;

-- 관광 카테고리 검색결과
insert into main_result (sequenceid, result)
values(main_result_seq.nextval, '강화 석수문,강화산성 북장대,강화 홍릉/강화 전등사/애관극장,영화공간주안,2층 다복집/강화 화문석마을,화문석문화관/강화 광성보,강화 초지진,강화 덕진진/쇠뿔고개길,배다리 헌책방 골목');

-- 전시 카테고리 검색결과
insert into main_result (sequenceid, result)
values(main_result_seq.nextval, '국제성서박물관,송암미술관,인천상륙작전기념관/집현전,인천국악회관,부평공원/배미꾸미조각공원,섬사랑굴사랑/인천관동갤러리,금강산추어탕,청관 (淸館)/인천상륙작전기념관,인천도시역사관,인천광역시립박물관/송도 초콜릿문화박물관,호텔빈');

-- 자연 카테고리 검색결과
insert into main_result (sequenceid, result)
values(main_result_seq.nextval, '석모도 칠면초 군락지,석모도,어류정항/계양꽃마루,계양산,부평공원/모도 배미꾸미 해변,시도 수기해변,신도·시도·모도 해안누리길(인천 삼형제섬길)/드림파크 야생화공원,청라생태공원,국립생물자원관/영종도 백운산,인천대교/백령도 사곶해변,백령도 용트림바위,백령도 콩돌해변');

-- 레저 카테고리 검색결과
insert into main_result (sequenceid, result)
values(main_result_seq.nextval, '함허동천(야영장),노을빛바다애글램핑,바다로글램핑/강화나들길/무의바다누리길,무의도 하나개해수욕장/어류정항,석모도 칠면초 군락지,석모도 민머루해변/삼산저수지,어류정항/선재도 트리캠핑장,선재오토캠핑장');