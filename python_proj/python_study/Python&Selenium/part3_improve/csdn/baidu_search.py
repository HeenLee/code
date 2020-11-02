import time
from selenium import webdriver
from test1.base_page import BasePage

class BaiduSearch(object):
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.implicitly_wait(3)

    basepage = BasePage(driver)

    def open_baidu(self):
        self.basepage.open_url("http://www.baidu.com")
        time.sleep(1)

    def test_search(self):
        self.driver.find_element_by_id("kw").send_keys("selenium")
        time.sleep(1)
        self.basepage.back()
        time.sleep(2)
        self.basepage.forward()
        time.sleep(3)
        self.basepage.quit_browser()

baidu = BaiduSearch()
baidu.open_baidu()
baidu.test_search()