"""
窗口尺寸设置：打开浏览器处于最大化或者某一特定尺寸的大小
"""
import time
from selenium import webdriver

chrome_driver = webdriver.Chrome()


# 定义一个方法获取窗口的大小
def get_size(driver):
    driver = chrome_driver  # 将当前创建的浏览器传入参数
    size = driver.get_window_size()  # 获取窗口尺寸
    print(size)
    time.sleep(3)


chrome_driver.get("http://www.baidu.com")
get_size(chrome_driver)  # 设置前先获取默认的大小    {'height': 1020, 'width': 945}

chrome_driver.set_window_size(800, 600)  # 设置窗口尺寸800 * 600
get_size(chrome_driver)  # 获取一次尺寸            {'height': 600, 'width': 800}

chrome_driver.minimize_window()  # 最小化窗口
get_size(chrome_driver)  # 最小化后获取尺寸       {'height': 600, 'width': 800}

chrome_driver.maximize_window()  # 最大化窗口
get_size(chrome_driver)  # 最大化后获取尺寸           {'height': 1056, 'width': 1936}

chrome_driver.quit()
