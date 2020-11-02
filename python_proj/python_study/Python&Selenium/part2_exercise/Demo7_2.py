"""
显示等待
"""
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
driver.find_element_by_xpath('//div[@id="u1"]//a[@name="tj_login"]').click()  #定位登录按钮
#定位用户名登录按钮
ele_locator = "TANGRAM__PSP_10__footerULoginBtn"

# C.  使用expected_conditions对应的方法来生成判断条件
# EC.方法名(定位方式,定位表达式)
# EC.visibility_of_element_located(By.ID,ele_locator)#元素可见

# D.  调用WebDriverWait类设置等待总时长、轮询周期
# WebDriverWait(driver, 超时时长, 调用频率（默认0.5s）).until(可执行方法, 超时时返回的信息)
# 等待10秒钟，每隔1秒去查看对应的元素是否可见；如果可见，继续下一步操作；如果不可见，则继续等待，直到10s结束，
# 如果元素还是不可见，则抛出超时异常

WebDriverWait(driver,10,1).until(EC.visibility_of_element_located((By.ID,ele_locator)))

driver.find_element_by_id("TANGRAM__PSP_10__footerULoginBtn").click()

