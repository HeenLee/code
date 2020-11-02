from selenium import  webdriver
from selenium.webdriver.common.by import  By
from class_unittest_demo.basePage import  BasePage

class LoginPage(BasePage):
    '''
    新浪微博登录页面，继承基础页面BasePage
    '''
    #定位账号输入框
    username_loc = (By.ID,'loginname')
    #定位密码输入框
    password_loc = (By.ID,'password')
    #定位登录按钮
    submit_loc = (By.XPATH,'//*[@id="pl_login_form"]/div/div[3]/div[6]/a/span')

    # 定位提示信息，如：请输入验证码
    # 不要迷信开发者工具提供的Xpath，
    # 比如这里提供的Xpath：//*[@id="layer_15582553868501"]/div/p/span[2]，
    # id是动态的，无法使用，需自行推到Xpath
    message_loc = (By.XPATH, '//div[@class="content layer_mini_info"]/p/span[2]')

    #输入用户名操作
    def type_username(self,username):
        self.find_element(*self.username_loc).send_keys(username)

    #输入密码操作
    def type_password(self,password):
        self.find_element(*self.password_loc).send_keys(password)

    #点击登录按钮操作
    def submit(self):
        self.find_element(*self.submit_loc).click()

    #获取提示信息
    def get_message(self):
        return self.find_element(*self.message_loc).text

if __name__ == "__main__":
    base_url = 'https://weibo.com/'
    title = '微博-随时随地发现新鲜事'
    username= 'haha'
    password = 'hehe'

    driver = webdriver.Chrome()
    driver.maximize_window()
    login = LoginPage(driver,base_url,title)
    login.open()
    login.type_username(username)
    login.type_password(password)
    login.submit()
    print(login.get_message())