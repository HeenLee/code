"""
模拟键盘输入
"""
import time
from selenium.webdriver.common.keys import Keys
from selenium import webdriver


chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")
# # 通过key模块的Keys模拟输入
# chrome_driver.find_element_by_tag_name("body").send_keys(Keys.CONTROL + "t")
# chrome_driver.find_element_by_id('kw').send_keys("abcd")  #输入Control+v模拟粘贴

chrome_driver.find_element_by_id('kw').send_keys(Keys.SHIFT, 'a')  #输入Control+a模拟全选
# chrome_driver.find_element_by_id('kw').send_keys(Keys.CONTROL, 'c')  #输入Control+a模拟全选
# chrome_driver.find_element_by_id('kw').send_keys(Keys.CONTROL, 'v')  #输入Control+a模拟全选
time.sleep(3)
