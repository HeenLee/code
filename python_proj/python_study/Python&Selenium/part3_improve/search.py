import time
from selenium import webdriver


class BaiduSearch(object):
    chrome_driver = webdriver.Chrome()
    chrome_driver.maximize_window()
    chrome_driver.implicitly_wait(10)

    def open_baidu(self):
        self.chrome_driver.get("http://www.baidu.com")
        time.sleep(1)

    def test_search(self):
        self.chrome_driver.find_element_by_id("kw").send_keys("selenium")
        time.sleep(1)
        print(self.chrome_driver.title)

        try:
            assert "selenium" in self.chrome_driver.title
            print("test pass")
        except Exception as e:
            print("test fail")


baidu = BaiduSearch()
baidu.open_baidu()
baidu.test_search()
