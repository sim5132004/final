from selenium import webdriver
from selenium.webdriver.common.by import By
from PIL import Image
import time
import pandas as pd
from time import sleep
import json

from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
import cx_Oracle
import urllib.request
from io import BytesIO
data=pd.read_csv('row_data.csv')
data.drop('Unnamed: 0',axis=1,inplace=True)
t=data['0'].values.tolist()
driver = webdriver.Chrome()  # 드라이버 경로
se2='#post-view222482771948 > div'
tstroy_main_se='#content > div > div:nth-child(1)'

all_data = {}
count = 0
# json_string = first_list[0]
# json.loads(json_string)
for name_list in t[:100]:
    count2 = 0
    names = json.loads(name_list)

    for name in names['items']:
        print(name['link'])
        url = name['link']
        print(url)
        driver.get(url)
        sleep(1)

        #     find_elements(By.CSS_SELECTOR)

        if url.find('naver') == -1:
            x = driver.find_elements(By.CSS_SELECTOR, tstroy_main_se)
            contents = [element.text for element in x]
        else:
            test_url = url.split('/')
            naver_main_se = f'#post-view{test_url[4]} > div'
            driver.switch_to.frame('mainFrame')
            x = driver.find_elements(By.CSS_SELECTOR, naver_main_se)
            contents = [element.text for element in x]
            driver.switch_to.parent_frame()

        sleep(1)
        all_data[f'{[count]}{count2}'] = contents

        print(contents)
        count2 += 1
    count += 1

with open('data.csv', 'w',encoding='utf-8') as f:
    f.write(str(all_data))

# df=pd.DataFrame(all_data)

# df.to_csv("test")
