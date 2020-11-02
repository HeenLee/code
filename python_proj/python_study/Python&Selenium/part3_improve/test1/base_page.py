'''
二次封装：python中默认规则，包名和文件名都是小写，类名称单词首字母大写，函数名称小写，多个字母下划线隔开
'''
class BasePage(object):
    """
    主要是把常用的几个selenium方法封装到BasePage类中
    back()
    forward()
    get()
    quit()
    """
    def __init__(self,driver):
        self.driver = driver

    def back(self):
        self.driver.back()

    def forward(self):
        self.driver.forward()

    def open_url(self,url):
        self.driver.get(url)

    def quit_browser(self):
        self.driver.quit()

    