"""
如何获取某一个元素的text属性值
注意：chrome_driver.find_element_by_id("kw").get_attribute("value")  是获取文本框的值。与上面获取控件的内容文本不一样
"""
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

chrome_driver.find_element_by_xpath('//*[@id="u1"]/a[7]').click()
chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__footerULoginBtn"]').click()
chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__submit"]').click()

error_text = chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__error"]').text
print(error_text)

#这个是获取属性的值,text