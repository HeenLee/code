"""
点击单选按钮
"""
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains

chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")
link = chrome_driver.find_element_by_link_text("设置")
ActionChains(chrome_driver).move_to_element(link).perform()
chrome_driver.find_element_by_link_text("搜索设置").click()
for i in chrome_driver.find_elements_by_xpath('.//td[@id="se-settting-1"]/input[@type="radio"]'):
    chrome_driver.implicitly_wait(20)  # 智能等待；超时设置
    print(i.is_displayed())