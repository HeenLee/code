"""
刷新、前进和后退操作
"""
import time
from selenium import webdriver

#打开两个网页进行前进、后退
chrome_driver = webdriver.Chrome()
chrome_driver.get("http://www.baidu.com")
time.sleep(3)

chrome_driver.get("http://www.taobao.com")
time.sleep(3)

chrome_driver.back()  #后退
time.sleep(3)

chrome_driver.forward()  #前进
time.sleep(3)

chrome_driver.refresh()  #刷新

#还可以进行输入字段搜索前进、后退.需要用到后面的元素定位
chrome_driver.quit()
