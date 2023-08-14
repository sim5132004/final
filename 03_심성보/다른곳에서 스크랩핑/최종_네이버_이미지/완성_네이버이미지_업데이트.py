
import requests
import os
import sys
import urllib.request
import json
import pandas as pd
import cx_Oracle


id ='PlarbZV3yEXbIyboynxp'
pw='3az9LS7plV'

# 검색할 리스트
with open('search_list.txt', 'r') as f:
    search_list = f.read()
    f.close()
search_list_s=search_list.split('\n')

def update_image_from_oracle(target_url,list_name,count):
    con = cx_Oracle.connect('party/party@192.168.30.240:1521/xe')
    cur = con.cursor()
    if count ==1:
        sql = "update 데이터2 set 이미지주소1  = :1  WHERE 제목 =:2"
        cur.execute(sql, ( target_url, list_name))
    else:
        sql = "update 데이터2 set 이미지주소2  = :1  WHERE 제목 =:2"
        cur.execute(sql, (target_url, list_name))
    # sql = "update 데이터2 set :1  = :2  WHERE 제목 =:3"
    # cur.execute(sql,(txt,target_url,list_name))
    #

    con.commit()
    cur.close()
    con.close()



count=0
search_list_s=['돈비어천가','동암아구해물탕','등나무가든','마포소금구이']
for go in search_list_s:

    try:
        encText = urllib.parse.quote(go)
        urlI='https://openapi.naver.com/v1/search/image?display=2&query='+ encText
        request = urllib.request.Request(urlI)
        # print(type(request))
        request.add_header("X-Naver-Client-Id",id)
        request.add_header("X-Naver-Client-Secret",pw)
        response = urllib.request.urlopen(request)
        rescode = response.getcode()

        if (rescode == 200):
            response_body = response.read()
            print()
            print('=======================')
            # print(response_body)
            result = json.loads(response_body)
            # print(result)
            img_list = result['items']

            for i, img_list in enumerate(img_list, 1):
                # 이미지링크 확인
                print(f"{img_list['link']} {i}")
                print(search_list_s[count])
                update_image_from_oracle(img_list['link'],search_list_s[count],i)

                # 저장 파일명 및 경로
                # FileName = f"{savePath}{go}_{i}.jpg"
                # os.path.join(savePath, savePath + go+"_"str(i) + '.jpg')

                # 파일명 출력
                # print('full name : {}'.format(FileName))

                # 이미지 다운로드 URL 요청
                # 이 부분에 데이터베이스에 url을 저장하는 코드 생성
                # urllib.request.urlretrieve(img_list['link'], FileName)

            # 다운로드 완료 시 출력
            # print("--------download succeeded--------")

        else:
            print("Error Code:" + rescode)
        count += 1
    except:
        print()
        count+=1
        continue






