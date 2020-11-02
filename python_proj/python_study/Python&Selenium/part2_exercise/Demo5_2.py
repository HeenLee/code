"""
组合键-全选
"""

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

element = chrome_driver.find_element_by_tag_name("body")
element.send_keys(Keys.CONTROL + "a")