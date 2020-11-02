"""
单个元素查找
find_element_by_name
find_element_by_id
find_element_by_xpath
find_element_by_link_text
find_element_by_partial_link_text
find_element_by_tag_name
find_element_by_class_name
find_element_by_css_selector

多个元素查找
find_elements_by_name
find_elements_by_id
find_elements_by_xpath
find_elements_by_link_text
find_elements_by_partial_link_text
find_elements_by_tag_name
find_elements_by_class_name
find_elements_by_css_selector

"""
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
import time
import unittest

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class TestSelenium(unittest.TestCase):
    # 1.访问页面
    def test_demo(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.maximize_window()
        time.sleep(3)
        chrome_driver.get("https://www.baidu.com")
        print(chrome_driver.page_source)
        chrome_driver.quit()

    # 2.查找元素—单个元素查找
    def test_find_element1(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("http://www.taobao.com")
        input_first = chrome_driver.find_element_by_id("q")
        input_second = chrome_driver.find_element_by_css_selector("#q")
        input_third = chrome_driver.find_element_by_xpath('//*[@id="q"]')
        print(input_first)
        print(input_second)
        print(input_third)

    # 3.By   from selenium.webdriver.common.by import By
    def test_By(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("http://taobao.com")
        input_first = chrome_driver.find_element(By.ID, "q")
        print(input_first)
        chrome_driver.quit()

    # 4.多个元素查找
    def test_find_elements(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("http://www.taobao.com")
        element_list = chrome_driver.find_elements_by_css_selector(".service-bd li")
        print(element_list)
        # chrome_driver.quit()

    # 5.通过By查找多个元素 find_elements
    def test_find_elements_By(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("http://www.taobao.com")
        element_list = chrome_driver.find_elements(By.CSS_SELECTOR(".service-bd li"))
        print(element_list)

    ##6.元素交互操作
    def test_send_keys(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("http://www.taobao.com")
        input_str = chrome_driver.find_element_by_id("q")
        input_str.send_keys("macBook")
        chrome_driver.find_element_by_class_name("btn-search").click()

    # 7.交互动作  将动作附加到动作链中串行执行
    def test_actionchains(self):
        chrome_driver = webdriver.Chrome()
        url = "http://www.runoob.com/try/try.php?filename=jqueryui-api-droppable"
        chrome_driver.get(url)
        chrome_driver.switch_to.frame("iframeResult")
        source = chrome_driver.find_element_by_css_selector("#draggable")
        target = chrome_driver.find_element_by_css_selector(("#droppable"))

        actions = ActionChains(chrome_driver)
        chrome_driver.implicitly_wait(3)
        actions.drag_and_drop(source, target)
        actions.perform()

    # 8.执行JavaScript
    def test_execute_js(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("http://www.zhihu.com/explore")
        chrome_driver.execute_script('window.scrollTo(0, document.body.scrollHeight)')
        chrome_driver.execute_script('alert("To Bottom")')

    # 9.获取元素属性
    def test_get_attribute(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("https://www.zhihu.com/explore")
        logo = chrome_driver.find_element_by_class_name("Icon")
        print(logo)
        print(logo.get_attribute("class"))

    # 10.获取文本值
    def test_text(self):
        browser = webdriver.Chrome()
        url = 'https://www.zhihu.com/explore'
        browser.get(url)
        input = browser.find_element_by_class_name('Icon')
        print(input.text)

    # 11.获取Id 位置 标签名
    def test_get(self):
        browser = webdriver.Chrome()
        url = 'https://www.zhihu.com/explore'
        browser.get(url)
        input = browser.find_element_by_class_name('Icon')
        print(input.id)
        print(input.location)
        print(input.tag_name)
        print(input.size)

    # 12.Frame  在很多网页中都是有Frame标签，所以我们爬取数据的时候就涉及到切入到frame中以及切出来的问题，通过下面的例子演示
    def test_frame(self):
        browser = webdriver.Chrome()
        url = 'http://www.runoob.com/try/try.php?filename=jqueryui-api-droppable'
        browser.get(url)
        browser.switch_to.frame('iframeResult')
        source = browser.find_element_by_css_selector('#draggable')
        print(source)
        try:
            logo = browser.find_element_by_class_name('logo')
        except NoSuchElementException:
            print('NO LOGO')
        browser.switch_to.parent_frame()
        logo = browser.find_element_by_class_name('logo')
        print(logo)
        print(logo.text)

    # 13.等待 显示等待是针对某一个元素进行相关等待判定  WebDriverWait(driver,5,0.5),until(EC.presence_of_element_located((By.ID,'su')))
    # 解释：WebDriverWait(driver,5,0.5)5表示等待的最大时长秒单位，0.5位间隔秒
    # EC.presence_of_element_located((By.ID,'su'))方法本身调用时有括号，所以调用时会有双括号填入参数
    # 隐式等待不针对某一个元素进行等待，是全局元素等待  driver.implicitly_wait(5) #隐式等待，设置等待时长5秒
    def test_implicitly_wait(self):  # 隐式等待
        chrome_driver = webdriver.Chrome()
        chrome_driver.implicitly_wait(10)
        chrome_driver.get("https://www.zhihu.com/explore")
        input = chrome_driver.find_element_by_class_name("zu-top-add-question")
        print(input)

    def test_webDriver_wait(self):  # 显示等待
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("https://www.taobao.com")
        wait = WebDriverWait(chrome_driver, 20)
        input = wait.until(EC.presence_of_element_located((By.ID, "q")))
        button = wait.until(EC.element_to_be_clickable((By.CLASS_NAME, "btn-serrch tb-bg")))
        print(input, button)

    def test_get_cookies(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("https://www.zhihu.com/explore")
        print(chrome_driver.get_cookies())
        chrome_driver.add_cookie({"name": "name", "domain": "www.zhihu.com", "value": "sino"})
        print(chrome_driver.get_cookies())
        chrome_driver.delete_all_cookies()
        print(chrome_driver.get_cookies())

    def test_window_open(self):
        chrome_driver = webdriver.Chrome()
        chrome_driver.get("https://www.baidu.com")
        chrome_driver.execute_script("window.open()")
        print(chrome_driver.window_handles)
        chrome_driver.switch_to.window(chrome_driver.window_handles[1])
        chrome_driver.get("https://www.taobao.com")
        time.sleep(1)
        chrome_driver.switch_to.window(chrome_driver.window_handles[0])
        chrome_driver.get("http://python.org")


if __name__ == "__main__":
    unittest.main()
