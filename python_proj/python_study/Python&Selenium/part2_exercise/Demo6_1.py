import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://news.baidu.com")

# chrome_driver.execute_script("window.alert('这是一个弹框')")
# time.sleep(2)
# chrome_driver.switch_to_alert().accept()
for image in chrome_driver.find_elements_by_tag_name("img"):
    print(image.text)
    print(image.size)
    print(image.tag_name)