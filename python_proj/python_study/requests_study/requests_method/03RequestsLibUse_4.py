#Requests是用python语言基于urllib编写的，采用的是Apache2 Licensed开源协议的HTTP库
#setUp() tearDown()会在每个用例执行前都执行。
#而利用@classmethod，setUpClass(cls) tearDownClass(cls)会在用例执行前，执行完后只执行一次
import unittest
from typing import AnyStr, Union, Pattern, Any

import requests
import json   #json.loads(）将json加载到对象     json.dumps()将对象转为json
import urllib3
from requests.auth import  HTTPBasicAuth

class TestRequsets(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        print("start")

    @classmethod
    def tearDownClass(cls):
        print("end")
    #1.基本请求
    def test_base_request(self):
        response = requests.get("http://www.baidu.com")
        print(type(response))
        print(response.status_code)
        print(type(response.text))
        print(response.text)  # 直接使用response.text会出现乱码，所以使用response.content
        print(response.cookies)
        print(response.content)  # 返回二进制格式，通过decode()转换为utf-8
        print(response.content.decode("utf-8"))

    #2.基本get请求
    def test_get_request(self):
        response = requests.get("http://httpbin.org/get")
        print(response.text)

    #2.带参数的get请求
    def test_get_request_with_param(self):
        response = requests.get("http://httpbin.org/get?name=zhaomi&age=23")
        print(response.text)
# 如果我们想要在URL查询字符串传递数据，通常我们会通过httpbin.org/get?key=val方式传递。
# Requests模块允许使用params关键字传递参数，以一个字典来传递这些参数，例子如下：

    #3.与2相似的get请求,位置形式不同
    def test_get_request_with_param2(self):
        data = {"name": "zhaowang", "age": 18}
        response = requests.get("http://httpbin.org/get",params=data)
        print(response.url)
        print(response.text)
# 上述两种的结果是相同的，通过params参数传递一个字典内容，从而直接构造url
# 注意：第二种方式通过字典的方式的时候，如果字典中的参数为None则不会添加到url上

    #4.解析json
    def test_parseJson(self):
        response = requests.get("http://httpbin.org/get")
        print(type(response.text))  #返回str
        print(response.json())
        print(type(response.json()))  # 返回字典
        print(json.loads(response.text))    #load()将json转换为对象  dumps()将对象转为json


    #5.添加headers 我们直接通过requests请求知乎网站的时候，默认是无法访问的 添加headers
    def test_set_headers(self):
        headers = {"User-Agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36"}
        response = requests.get("https://www.zhihu.com",headers=headers)
        print(response.text)

    #6.post请求
    #@unittest.skipIf(sys.version.__contains__("windows"),"skip no")   条件为真，跳过该用例   skipUnless()条件为假，跳过用例
    def test_post_request(self):
        data = {"name":"xiaoming","age":26}  #post请求以字典格式发送数据(表单)  也可以将字典改为json格式发送

        #json_data = json.dumps(data)          #将字典改为json
        response = requests.post("http://httpbin.org/post",data = data)    #data = json.dumps(data)
        print(response.text)

    def assertRegex(self, text: AnyStr, expected_regex: Union[AnyStr, Pattern[AnyStr]], msg: Any = ...) -> None:
        super().assertRegex(text, expected_regex, msg)

    #7.响应
    def test_response(self):
        response = requests.get("http://www.baidu.com")
        print(type(response.status_code),response.status_code)
        print(type(response.headers),response.headers)
        print(type(response.cookies),response.cookies)
        print(type(response.url),response.url)
        print(type(response.history),response.history)

    #8.文件上传
    def test_file_upload(self):
        headers = {"User-Agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36"
                   ,"Content-Type":"multipart/form-data"}
        files = {"files":open("./conf/hello.txt","r+")}
        response = requests.post("http://httpbin.org/post",files = files,headers = headers)

        print(response.text)

    #9.获取cookie
    def test_get_cookie(self):
        response = requests.get("http://www.baidu.com")
        print(response.cookies)
        for key,value in response.cookies.items():
            print(key + "=" +value)

    #10.会话维持  session
    def test_session(self):
        s = requests.Session()
        print(s)
        s.get("http://httpbin.org/cookies/set/number/123456")
        response = s.get("http://httpbin.org/cookies")
        print(response.text)

    #11.证书认证
    def test_verify(self):
        '''
        response = requests.get("https://www.12306.cn")
        print(response.status_code)
        '''
        urllib3.disable_warnings()
        response = requests.get("https://www.12306.cn",verify=False)
        print(response.status_code)

    #12代理设置
    def test_proxy(self):
        proxies = {
            "http":"http://127.0.0.1:9999",
            "https":"http://127.0.0.1:8888"
        }
        response = requests.get("https://www.baidu.com",proxies = proxies)
        print(response.text)

    #13.认证设置及超时 超时通过timeout设置
    def test_auth_timeout(self):
        response  = requests.get("https://120.27.34.24:9001",auth = HTTPBasicAuth("user","123"),timeout = 1)
        print(response.status_code)


if __name__ == "__main__":
    unittest.main()
