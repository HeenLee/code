"""
组合键-退格键删除文字
"""
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

element = chrome_driver.find_element_by_id("kw")
element.send_keys("selenium automation")

time.sleep(6)
element.send_keys(Keys.CONTROL + "a")

time.sleep(4)
element.send_keys(Keys.BACKSPACE)