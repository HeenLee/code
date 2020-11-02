"""
通过webdriver方法获取浏览器的版本，如何使用webdriver方法获取当前测试页面的URL、
如何获取当前页面的title、如何打开浏览器的一个新建页面、如何操作单选按钮等等

"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
class Demo3(unittest.TestCase):

    #获取浏览器版本
    def test_get_browser_version(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.implicitly_wait(6)
        chrome_driver.get("http://www.baidu.com")
        print(chrome_driver.capabilities["version"])

    #获取当前页面的url
    def test_get_url(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.implicitly_wait(6)
        chrome_driver.get("http://www.baidu.com")
        time.sleep(1)

        chrome_driver.find_element_by_link_text("新闻").click()
        time.sleep(1)

        print(chrome_driver.current_url)  #current_url获取当前页面url
        chrome_driver.quit()

    #获取当前页面的title
    def test_get_title(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.implicitly_wait(6)
        chrome_driver.get("http://www.baidu.com")
        time.sleep(1)

        chrome_driver.find_element_by_link_text("新闻").click()
        time.sleep(1)
        print(chrome_driver.title)

    #打开一个新的tab
    #按住 ctrl+ t 就可以新打开一个tab。所以我们学习如何利用webdriver中send_key 的方法去触发ctrl+t的效果
    #主要是调用了keys模块下相关方法，可以通过这个方法，输入任何一个键盘上支持的字符或者快捷键
    def test_open_new_tab(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.implicitly_wait(6)
        chrome_driver.get("http://www.baidu.com")
        #通过key模块的Keys模拟输入
        chrome_driver.find_element_by_tag_name("body").send_keys(Keys.SHIFT + 't')
        time.sleep(1)

    #点击单选按钮
    def test_handle_radio(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.implicitly_wait(6)
        chrome_driver.get("http://www.baidu.com")
        chrome_driver.find_element_by_link_text("设置").click()
        for i in chrome_driver.find_elements_by_xpath('//*[@id="se-settting-1"]/input[@type="radio"]'):
            print(i)

        time.sleep(4)


if __name__ == "__main__":
    unittest.main()