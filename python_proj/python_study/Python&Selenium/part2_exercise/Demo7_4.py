"""
下拉框或弹框
"""
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.select import Select

driver = webdriver.Chrome()
driver.get("http://www.baidu.com")

driver.find_element_by_xpath('//*[@id="u1"]/a[8]').click()
driver.find_element_by_xpath('//*[@id="wrapper"]/div[6]/a[1]').click()
# driver.find_element(By.LINK_TEXT,"搜索设置").click()
time.sleep(2)
#定位下拉框
select = driver.find_element(By.XPATH,'//*[@id="nr"]')
#下拉框选项
Select(select).select_by_value("50")
driver.find_element(By.XPATH,'//*[@id="gxszButton"]/a[1]').click()
time.sleep(2)

#弹框处理
driver.switch_to.alert.accept()
time.sleep(2)