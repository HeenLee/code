#coding = utf-8
'''
selenium需要安装浏览器驱动，
比如chromedricer.exe/geckodriver.exe/IEDriverServer.exe放到python/Scripts目录下
包含三个组件：seleniumIDE  seleniumRC seleniumGrid
'''

from selenium import webdriver   #导入模块
'''
打开关闭浏览器操作
'''
chrome_driver = webdriver.Chrome()        #打开浏览器
chrome_driver.maximize_window()             #最大化窗口
chrome_driver.get("http://www.baidu.com")   #打开网页
chrome_driver.quit()                        #关闭浏览器