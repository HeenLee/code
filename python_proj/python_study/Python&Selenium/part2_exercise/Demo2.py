#coding = utf-8
"""
通过link text    partial text   name
"""
from selenium import webdriver
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")
try:
    chrome_driver.find_element_by_link_text("新闻")
    print("test pass")
except Exception as e:
    print("not found",format(e))