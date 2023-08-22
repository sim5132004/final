from algorithm import recommend_distance, data_recommend
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import linear_kernel
import cx_Oracle
import pandas as pd
import math
import time

def check_cdc_changes():
    with connection.cursor() as cursor:
        cursor.execute("SELECT SEQUENCEID, CATEGORY, KEYWORD, ADDRESS  FROM ASDF")
        result = cursor.fetchall()
        return result


while True:
    # DB 데이터 쿼리를 날려 LIST로 가져온다
    new_changes = check_cdc_changes()
    old = new_changes
    # 일정 시간 동안 대기 (예: 5초)
    time.sleep(5)
    new_changes = check_cdc_changes()
    if old!=new_changes:
        print("새로운 값이 들어왔습니다")
        new_db_data = new_changes[len(new_changes)-1]
        # 새로운 값 처리 로직 추가
        # 특정 카테고리와 키워드, 주소를 기반으로 제목(장소) 추천 및 거리 계산 실행
        추천카테고리 = new_db_data[1]  # None으로 두면 카테고리를 사용하지 않음
        추천키워드 = new_db_data[2]  # None으로 두면 키워드를 사용하지 않음
        추천주소 = new_db_data[3]  # None으로 두면 주소를 사용하지 않음
        top_n = 3
        recommended_distance = recommend_distance(data_recommend, 추천카테고리, 추천키워드, 추천주소, top_n)
    else:
        print("새로운 값이 없습니다.")
