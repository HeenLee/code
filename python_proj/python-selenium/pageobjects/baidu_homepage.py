# -*- coding:utf-8 -*-

# 1.先设置编码，utf-8可支持中英文，如上，一般放在第一行

# 2.注释：包括记录创建时间，创建人，项目名称。
'''
Created on 2019-12-20
@author: 北京-宏哥   QQ交流群：705269076
Project: 《《一头扎进》系列之Python+Selenium框架设计篇4- 价值好几K的框架，不看别后悔，过时不候
'''
# 3.导入模块

from framework.base_page import BasePage

class HomePage(BasePage):
    input_box = "id=>kw"
    search_submit_btn = "xpath=>//*[@id='su']"

    #百度新闻入口
    #news_link = "xpath=>//*[@id='u1']/a[@name='tj_trnews']"
    news_link = "xpath=>//*[@id='u1']/a[@name='tj_trnews']"

    def type_search(self, text):
        self.type(self.input_box, text)

    def send_submit_btn(self):
        self.click(self.search_submit_btn)

    def click_news(self,):
        self.click(self.news_link)
        self.sleep(2)