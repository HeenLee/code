'''
基础页面，比如打开 最大化 关闭的操作
'''
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class BasePage(object):
    '''
    基础页面，提供给其他页面继承
    '''
    def __init__(self,driver,base_url,title):
        self.driver = driver
        self.base_url = base_url
        self.title = title

    def _open(self,url):
        '''
        私有方法，打开url
        并检查打开页面是否正确
        :param url:
        :return:
        '''
        self.driver.get(url)
        WebDriverWait(self.driver,10).until(EC.title_is(self.title))

    def open(self):
        '''
        公有方法，调用私有方法_open()方法
        :return:
        '''
        self._open(self.base_url)

    def find_element(self,*loc):
        '''
        显示等待元素，超过10s后未找到则抛出异常（TimeoutException)
        presence_of_element_located 不关系元素是否可见，只关心元素是否存在页面中
        visibility_of_element_located 不仅找到元素，并且元素必须可见
        :param loc:
        :return:
        '''
        WebDriverWait(self.driver,15).until(EC.visibility_of_element_located(loc))
        return self.driver.find_element(*loc)

if __name__ == "__main__":
    driver = webdriver.Chrome()
    driver.maximize_window()
    page = BasePage(driver,'https://www.baidu.com','百度一下，你就知道')
    page.open()
    driver.quit()

