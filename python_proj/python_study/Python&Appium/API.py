import time

from appium import webdriver
from selenium.webdriver.support.ui import WebDriverWait

desired_caps = {}
desired_caps["platformName"] = "Android"
desired_caps["platformVersion"] = "5"
desired_caps["deviceName"] = "127.0.0.1:62001"
desired_caps["appPackage"] = "com.taobao.taobao"
desired_caps["appActivity"] = "com.taobao.tao.welcome.Welcome"
driver = webdriver.Remote("http://127.0.0.1:4723/wd/hub",desired_caps)
try:

    time.sleep(5)  #强制等待
    driver.find_element_by_id("com.taobao.taobao:id/yes").click()
    driver.implicitly_wait(15)  #隐示等待
    driver.find_element_by_id("com.taobao.taobao:id/home_searchedit").click()
    time.sleep(10)
    driver.find_element_by_id("com.taobao.taobao:id/searchEdit").clear()
    time.sleep(30)
    #显示等待
    element = WebDriverWait(driver,10).until(lambda driver:driver.find_element_by_id("com.taobao.taobao:id/searchEdit"))
    element.send_keys("琵琶")
    time.sleep(20)
    driver.find_element_by_id("com.taobao.taobao:id/searchbtn").click()
except Exception as e:
    print(e)
finally:
    driver.quit()



