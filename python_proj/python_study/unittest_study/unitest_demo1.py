import unittest
from selenium import webdriver
import time

class BaiduSearch(unittest.TestCase):
    def setUp(self):
        '''
        测试固件的setUp()的代码，主要是测试的前提准备工作
        :return:
        '''
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()
        self.driver.implicitly_wait(8)
        self.driver.get('http://www.baidu.com')

    def tearDown(self):
        '''
        测试结束后的操作，基本上都是关闭浏览器
        :return:
        '''
        self.driver.implicitly_wait(8)
        self.driver.quit()

    def test_baidu_search(self):
        self.driver.find_element_by_id('kw').send_keys('selenium')
        time.sleep(1)
        self.driver.find_element_by_id('su').click()
        time.sleep(3)
        try:
            assert 'selenium' in self.driver.title
            print('Test Pass')
        except Exception as e:
            print('Test Fail',format(e))
if __name__ == '__main__':
    if __name__ == '__main__':
        unittest.main()
