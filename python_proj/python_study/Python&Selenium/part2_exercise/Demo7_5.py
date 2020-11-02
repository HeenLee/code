import time
from selenium import webdriver

driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
print(driver.title)

try:
    # assert driver.title == "百度一下，你就知道"
    assert (driver.title == "百度一下，你就知道")
    print("pass")
except:
    print("标题错误")
time.sleep(5)
