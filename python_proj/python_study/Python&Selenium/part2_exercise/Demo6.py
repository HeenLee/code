from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

chrome_driver.find_element_by_id("kw").send_keys("selenium")
chrome_driver.find_element_by_id("kw").send_keys(Keys.BACKSPACE)
chrome_driver.find_element_by_id("kw").send_keys(Keys.SPACE)
chrome_driver.find_element_by_id("kw").send_keys("学习")
chrome_driver.find_element_by_id("kw").send_keys(Keys.ENTER)