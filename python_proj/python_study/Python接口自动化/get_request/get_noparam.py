# coding=utf-8🔥

# 1.先设置编码，utf-8可支持中英文，如上，一般放在第一行

# 2.注释：包括记录创建时间，创建人，项目名称。
'''
Created on 2019-12-09
@author: 北京-宏哥   QQ交流群：705269076
Project: python+ selenium自动化测试练习篇8
'''

# 3.导入模块
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.maximize_window()

# 登录腾讯课堂页面
driver.get('https://ke.qq.com/course/list')

# 点击首页登录
WebDriverWait(driver,20).until(EC.visibility_of_element_located((By.XPATH,'//a[@id="js_login"]')))
driver.find_element_by_id("js_login").click()

# 登录弹窗点击QQ登录
WebDriverWait(driver,20).until(EC.visibility_of_element_located((By.XPATH,'//a[contains(@class,"btns-enter-qq")]')))
driver.find_element_by_xpath('//a[contains(@class,"btns-enter-qq")]').click()

# iframe切换
# driver.switch_to.frame('login_frame_qq') #通过name
driver.switch_to.frame(driver.find_element_by_xpath('//iframe[@name="login_frame_qq"]')) #通过webelement

# 弹窗点击账户密码登录switcher_plogin
#WebDriverWait(driver,20).until(EC.visibility_of_element_located((By.XPATH,'//a[@id="switcher_plogin"]')))
time.sleep(10)
driver.find_element_by_xpath('//a[@id="switcher_plogin"]').click()