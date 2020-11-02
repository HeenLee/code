"""
鼠标右键：通过ActionChains模块可以操作鼠标 context_click()是右击
"""
import time

import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

element = chrome_driver.find_element_by_xpath('//*[@id="lg"]/img')
ActionChains(chrome_driver).context_click().perform()



