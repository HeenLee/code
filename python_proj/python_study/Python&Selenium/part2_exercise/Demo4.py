"""
如何使用webdriver方法获取操作复选框-CheckBox、
测试不同的分辨率(set_window_size()、
"""
import  time
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")
chrome_driver.find_element_by_xpath('//*[@id="u1"]/a[7]').click()
time.sleep(2)
chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__footerULoginBtn"]').click()
time.sleep(2)
chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__memberPass"]').click()
# time.sleep(2)
# chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__memberPass"]').click()


