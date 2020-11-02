"""
如何断言title
"""
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

#方法一
try:
    assert "百度一下，你就知道" in chrome_driver.title
    print("pass")
except Exception as e:
    print("fail",format(e))

#方法二
if "百度一下，你就知道" == chrome_driver.title:
    print("pass")
else:
    print("fail")