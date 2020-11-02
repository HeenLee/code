"""
网页截图操作
"""
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.get("http://www.baidu.com")

chrome_driver.get_screenshot_as_file("./screenshot.png")

chrome_driver.quit()