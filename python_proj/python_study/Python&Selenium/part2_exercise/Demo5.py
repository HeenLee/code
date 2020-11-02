"""
验证控件是否被选中
"""
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("http://www.baidu.com")

chrome_driver.find_element_by_xpath('//*[@id="u1"]/a[7]').click()
chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__footerULoginBtn"]').click()
try:
    print(chrome_driver.find_element_by_xpath('//*[@id="TANGRAM__PSP_10__memberPass"]').is_selected())
    print("test pass")
except Exception as e:
    print("test fail",format(e))