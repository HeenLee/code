"""
元素定位：
webdriver提供了八种元素定位方法id/name/class name/tag name
                                link text/partial link text/xpath/css selector
对应的方法也是find_element_by_xx()

也可以导入selenium.webdriver.common.by import By 调用find_element(By.ID,xx)
"""
import time
import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By


class Demo2(unittest.TestCase):
    # 通过id  class_name定位
    def test_id_class_name(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("https://www.baidu.com/")
        chrome_driver.find_element_by_class_name("s_ipt").send_keys("hello")
        chrome_driver.find_element_by_id("su").click()
        # chrome_driver.find_element(By.ID, "su").click()

    #通过xpath定位
    def test_xpath(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("https://www.baidu.com/")
        chrome_driver.find_element_by_xpath('//*[@id="kw"]').send_keys("python")
        chrome_driver.find_element_by_xpath('//*[@id="su"]').click()
        time.sleep(3)
        chrome_driver.quit()

    #通过css_selector定位
    def test_css_selector(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("https://www.baidu.com/")
        chrome_driver.find_element_by_css_selector("#kw").send_keys("java")
        chrome_driver.find_element_by_css_selector("#su").click()
        time.sleep(3)
        chrome_driver.quit()


if __name__ == "__main__":
    unittest.main()
