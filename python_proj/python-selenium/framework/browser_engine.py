import configparser
import os.path
from selenium import webdriver
from framework.logger import Logger

logger = Logger(logger="BrowserEngine").getlog()

class BrowserEngine(object):
    dir = os.path.dirname(os.path.abspath(".")) #获取根目录
    chrome_driver = dir + '/tools/chromedriver.exe'

    def __init__(self,driver):
        self.driver = driver

    #读取浏览器类型
    def open_browser(self,driver):
        config = configparser.ConfigParser()
        file_path = self.dir + "/conf/config.ini"
        config.read(file_path)

        browser = config.get("browserType","browserName")  #获取浏览器类型、名称
        logger.info("你选则 %s 浏览器" % browser)

        url = config.get("testServer","URL")
        logger.info("你的url %s" % url)

        #判断选择的浏览器
        if browser == "Chrome":
            self.driver = webdriver.Chrome(self.chrome_driver)
            logger.info("starting chrome browser")
        self.driver.get(url)

        logger.info("open url:%s" %url)
        self.driver.maximize_window() #最大化
        logger.info("maximize the current window")

        self.driver.implicitly_wait(10)
        logger.info("set implicitly wait 10 senconds")
        print(self.driver)
        return self.driver

    def quit_browser(self):
        logger.info("now,close and quit the browser")
        self.driver.quit()