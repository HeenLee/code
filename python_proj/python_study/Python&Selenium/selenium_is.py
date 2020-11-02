
import time
import unittest

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class TestSelenium(unittest.TestCase):
    """
    判断弹框是否存在
    """
    def test_alert_is_present(self):
        driver = webdriver.Chrome()
        driver.get("https://www.baidu.com/")
        mouse = WebDriverWait(driver, 10).until(lambda x: x.find_element("link text", "设置"))
        ActionChains(driver).move_to_element(mouse).perform()

        #WebDriverWait(driver, 10).until(lambda x: x.find_element("link text", "搜索设置"))
        driver.find_element_by_link_text("搜索设置").click()
        time.sleep(10)
        s = driver.find_element_by_id("nr")
        s.click()
        #s = WebDriverWait(driver, 10).until(lambda x: x.find_element("id","nr"))
        Select(s).select_by_visible_text("每页显示50条")

        js = 'document.getElementsByClassName("prefpanelgo")[0].click()'
        driver.execute_script(js)
        result = EC.alert_is_present()(driver)
        if result:
            print(result.text)
            result.accept()
        else:
            print("alert未弹出")
        driver.quit()

    """
    在做结果判断的时候，经常想判断某个元素中是否存在指定的文本，如登录后判断页面中是账号是否是该用户的用户名
    """
    def test_text_to_be_present_in_element(self):
        driver = webdriver.Chrome()
        driver.get("https://www.baidu.com")
        locator = ("name","tj_trtieba")
        text = u"贴吧"
        result = EC.text_to_be_present_in_element(locator,text)(driver)
        print(result)

        locator1 = ("name","tj_trtieba")
        text1 = u"贴吧kkk"
        result1 = EC.text_to_be_present_in_element(locator1,text1)(driver)
        print(result1)


    """
    获取页面 title 的方法可以直接用 driver.title 获取到，然后也可以把获取到的结果用做断言。
    """
    def test_title_is(self):
        driver = webdriver.Chrome()
        response = driver.get("http://www.cnblogs.com/101718qiong/")

        title = EC.title_is(u"Silence&QH - 博客园")
        print(title(driver))
        title1 = EC.title_contains("Silence&QH")
        print(title1(driver))

    """
    js处理日历控件
    """
    def test_js_calendar(self):
        driver = webdriver.Chrome()
        driver.get("https://kyfw.12306.cn/otn/index/init")
        js = 'document.getElementById("train_date").removeAttribute("readonly")'
        driver.execute_script(js)
        driver.find_element_by_id("train_date").clear()
        js_value = 'document.getElementById("train_date").value="2019-10-26"'
        driver.execute_script(js_value)
        time.sleep(5)

    """
    获取页面元素
    """
    def test_get_page_element(self):
        driver = webdriver.Chrome()
        driver.get("https://www.baidu.com")
        title = driver.title
        text = driver.find_element_by_id("su").text
        tag = driver.find_element_by_id("su").tag_name
        name = driver.find_element_by_id("su").get_attribute("class")
        driver.find_element_by_id("kw").send_keys("hello")
        value = driver.find_element_by_id("kw").get_attribute("value")
        print(title,1)
        print(text,2)
        print(tag,3)
        print(name,4)
        print(value,5)
        print(driver.name,6)

    """
    switch_to.frame()
    """
    def test_switch_to(self):
        driver = webdriver.Chrome()
        driver.get("http://ueditor.baidu.com/website/examples/completeDemo.html")
        driver.switch_to.frame("ueditor_0")
        time.sleep(3)
        driver.find_element_by_tag_name("body").send_keys("hello")
        time.sleep(3)

        text = driver.find_element_by_tag_name("body").text
        print(text)

    """
    Select定位
    1.二次定位，先定位select，再定位选项
    2.直接定位
    3.通过Select类进行定位
        Select(s).select_by_index(2)
        Select(s).select_by_value(20)
        Select(s).select_by_visible_text("每页显示50条")
    """
    def test_select(self):
        driver = webdriver.Chrome()
        driver.get("https://www.baidu.com/")
        ActionChains(driver).move_to_element(driver.find_element_by_link_text("设置")).perform()
        driver.find_element_by_link_text("搜索设置").click()

        #driver.find_element_by_xpath('//*[@id="nr"]/option[2]').click()
        driver.find_element_by_id("nr")
        driver.implicitly_wait(10)
        driver.find_element_by_xpath('//*[@id="nr"]/option[2]').click()
        #Select(s).select_by_index(2)

    def test_login(self):
        driver = webdriver.Firefox()
        driver.get("https://yqtblackbox.sinosun.com:18093/static/tcm/pages/login.html")


        driver.add_cookie("")














if __name__ == "__main__":
    unittest.main()
