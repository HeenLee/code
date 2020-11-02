"""
在某一个网页上有些字段或者关键字等信息是我们感兴趣的，我们希望将其摘取出来，进行其他操作
思路:1. 首先，需要得到当前页面的source内容，就像，打开一个页面，右键-查看页面源代码。
2. 找出规律，通过正则表达式去摘取匹配的字段，存储到一个字典或者列表。
3. 循环打印字典或列表中内容，Python中用 for 语句实现。
技术角度实现相关方法:1. 查看页面的源代码，在Selenium中有driver.page_source 这个方法得到
2. Python中利用正则，需要导入re模块
3. 将字段通过下列代码打印出来
Python中字符串前面加上 r 表示原生字符串，用\w表示匹配字母数字及下划线。re模块下findall方法返回的是一个匹配子字符串的列表
"""
import  re
from selenium import webdriver
chrome_driver = webdriver.Chrome()
chrome_driver.implicitly_wait(6)
chrome_driver.get("https://home.baidu.com/contact.html")

source = chrome_driver.page_source  #得到页面源代码
emails = re.findall(r'[\w]+@[\w\.-]+',source)   #利用正则，找出xxx@xxx.xxx字段，保存到emails列表


for email in emails:
    print(email)

