"""
三种等待方式：
当有元素定位不到时，比如下拉框，弹出框等各种定位不到时；
一般是两种问题：1 、有frame ；2、没有加等待
1.强制等待 sleep（xx） 是在程序运行过程中使用time模块中的sleep进行代码的休眠进行强制等待，是显式等待中的一种极端情况
2.隐性等待 implicitly_wait(xx) 这种方法是设置一个最长的等待时间，如果在规定时间内网页全部元素加载完成，则执行下一步，
         否则一直等待时间截止才执行下一步。比强制性等待智能些！隐性等待对整个driver的周期都起作用，所以只要设置一次即可
3.显示等待 WebDriverWait
WebDriverWait配合该类的until()和until_not()方法，根据条件灵活的等待
程序每隔xx秒看一眼，如果条件成立了，则执行下一步，否则继续等待，直到超过设置的最长时间，然后抛出TimeoutException。
显式等待是你在代码中定义等待一定条件发生后再进一步执行你的代码。
A. 使用前，先引用相关库
B. 确定元素的定位表达式
C.  使用expected_conditions对应的方法来生成判断条件
    WebDriverWait(driver,10,1).until(EC.visibility_of_element_located((By.ID,ele_locator)))
    WebDriverWait(driver,10,1).until(EC.visibility_of_element_located((By.XPATH,ele_locator)))
D.  调用WebDriverWait类设置等待总时长、轮询周期
"""
import time
from selenium import webdriver

driver = webdriver.Chrome()
driver.get('https://www.baidu.com/')
time.sleep(3)#强制性等待3s再执行以下代码
print(driver.current_url)
driver.quit()#退出驱动，关闭所有窗口

