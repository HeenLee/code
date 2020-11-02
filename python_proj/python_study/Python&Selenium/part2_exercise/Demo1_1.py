"""
利用ID定位元素
"""
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

#try except语句块来进行测试断言，这个在实际自动化测试脚本开发中，经常要用到处理异常
try:
    chrome_driver.find_element_by_id("kw")
    print("test pass")
except:
    print("not found")