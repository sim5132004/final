from selenium import webdriver
from selenium.webdriver.common.by import By
from PIL import Image
import time
import pandas as pd
from time import sleep

from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
import cx_Oracle
import urllib.request
from io import BytesIO

column_list=['index',	'f_name',	'place',	'open_date',	'close_date',	'info',	'host_or',	'PHONE_NUMBER',	'ADRESS',	'LATITUDE',	'HARDNESS',	'x',	'y',	'go']

xp1='//*[@id="_pcmap_list_scroll_container"]/ul/li[9]/div[1]/a[1]/div/div/span[1]'
xp1_2='//*[@id="_pcmap_list_scroll_container"]/ul/li[2]/div[1]/a[1]'
xp2='//*[@id="app-root"]/div/div/div/div[5]/div/div/div/div/a[2]/span'
driver = webdriver.Chrome()  # 드라이버 경로
p1 = '//*[@id="_pcmap_list_scroll_container"]/ul/li[3]/div[1]/a[1]/div/div/span'
p2 = '//*[@id="_pcmap_list_scroll_container"]/ul/li[3]/div[1]/div/div/span[2]'
p3 = '//*[@id="_pcmap_list_scroll_container"]/ul/li[3]/div[1]/div/div/span[3]'
p4 = '//*[@id="_pcmap_list_scroll_container"]/ul/li[3]/div[1]/div/div/span[4]'
p5 = '//*[@id="_pcmap_list_scroll_container"]/ul/li[3]/div[3]/div/div/div/div[1]/div/a/div/span'
testp='//*[@id="app-root"]/div/div/div/div[5]/div/div/div/div'
url1 = 'https://map.naver.com/v5/'


driver.get(url1)
sleep(3)

num='강원도 '


row_co=[]

pp2 = '#container > shrinkable-layout > div > app-base > search-input-box > div > div.search_box'

x = driver.find_element(By.CSS_SELECTOR, pp2)
y = x.find_element(By.TAG_NAME, 'input')
y.clear()
y.send_keys(num+' 맛집')
y.send_keys(Keys.ENTER)
print(num+' 맛집', ' 검색 완료')

