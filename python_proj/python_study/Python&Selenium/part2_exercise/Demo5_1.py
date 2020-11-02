"""

获取页面元素大小
"""
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

search_btn = chrome_driver.find_element_by_id("su")
print(search_btn.size)