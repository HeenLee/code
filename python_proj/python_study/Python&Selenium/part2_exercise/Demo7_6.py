"""
python+selenium+unitest实现登录
"""
import  unittest
from selenium import webdriver
from time import sleep
class Demo7_6(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()

    #登录方法
    def login(self,user_name,password):
        self.driver.get("https://passport.cnblogs.com/user/signin")
        self.driver.find_element_by_id("LoginName").send_keys(user_name)
        self.driver.find_element_by_id("Password").send_keys(password)
        self.driver.find_element_by_xpath('//*[@id="submitBtn"]/span[1]').click()


    #登录需要滑动图片，这个后面练习
    def test_login_success(self):
        self.login("xhfhf@hotmail.com","heng*@19890515")
        sleep(3)
        link = self.driver.find_element_by_id("lnk_current_user")
        self.assertTrue("little-dolphin" in link.text)
        self.driver.get_screenshot_as_file("/login.jpg")

if __name__ == "__main__":
    unittest.main()
