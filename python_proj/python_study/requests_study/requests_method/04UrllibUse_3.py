'''
Urllib是python内置的HTTP请求库
包括以下模块
urllib.request 请求模块
urllib.error 异常处理模块
urllib.parse url解析模块
urllib.robotparser robots.txt解析模块
1.urlopen()方法--关于urllib.request.urlopen参数的介绍：
urllib.request.urlopen(url, data=None, [timeout, ]*, cafile=None, capath=None, cadefault=False, context=None)
'''
import unittest
import urllib.request
import urllib.parse
import http.cookiejar
import urllib.error
import socket
import json
class TestUrllib(unittest.TestCase):
    #1.简单的urlopen例子。 read()读取的是二进制数据，decode()是将二进制转换
    def test_urlopen(self):
        response = urllib.request.urlopen("http://www.baidu.com")
        print(response.read().decode("utf-8"))
    #2.urlopen一般常用的有三个参数，它的参数如下：urllib.requeset.urlopen(url,data,timeout)
    #response.read()可以获取到网页的内容，如果没有read(),返回<http.client.HTTPResponse object at 0x0000000003205E48>
    def test_openurl_withData(self):
        #"定义字典"
        data = {"word":"hello"}
        #对字典data进行格式编码
        data = urllib.parse.urlencode(data)   #编码后的格式为word = hello
        response = urllib.request.urlopen("http://httpbin.org/post",data=bytes(data,encoding="utf-8"))
        print(response.read().decode("utf-8"))

    #3.响应  响应类型、状态码、响应头
    def test_response(self):
        response = urllib.request.urlopen("http://www.python.org")
        print(response.read().decode("utf-8"))
        print(response.status)
        print(response.getheaders())  #打印的是key-value元组列表
        res_dict1 = dict(response.getheaders())  #转为dict
        print(res_dict1["Server"])

    #4.设置headers 方式一:该方法是将data先urlencode(),再encoding.将整体放倒req参数中
    def test_set_headers1(self):
        url = "http://httpbin.org/post"
        headers = {
            "User-Agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36",
            "Host":"httpbin.org",
            #"Content-Type":"appilication/json"  这里是json下面的就要改为json  默认为application/x-www-form-urlencoded
        }
        data = {"name":"zhangsan"}
        #对data进行编码
        data = bytes(urllib.parse.urlencode(data),encoding="utf-8")
        req = urllib.request.Request(url = url,data=data,headers=headers,method="POST")
        response = urllib.request.urlopen(req)
        print(response.read().decode("utf-8"))
    #5.方式二 该方式是通过add_header()
    def test_set_headers2(self):
        url = "http://httpbin.org/post"
        data = {"name":"gewe"}
        data = bytes(urllib.parse.urlencode(data),encoding="utf-8")
        res = urllib.request.Request(url=url,data=data,method="POST")
        res.add_header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36")
        response = urllib.request.urlopen(res)
        print(response.read().decode("utf-8"))

    #6.
    def test_proxyHandler(self):
        proxy_handler = urllib.request.ProxyHandler({
            "http":"http://127.0.0.1:9743",
            "https":"https://127.0.0.1:9743"
        })
        opener = urllib.request.build_opener(proxy_handler)
        response = opener.open("http://httpbin.org/get")
        print(response.read())

    #7.cookie  HTTPCookiProcessor
    #cookie中保存中我们常见的登录信息，有时候爬取网站需要携带cookie信息访问,这里用到了http.cookijar，用于获取cookie以及存储cookie
    def test_get_cookie(self):
        cookie = http.cookiejar.CookieJar()
        handler = urllib.request.HTTPCookieProcessor(cookie)
        opener = urllib.request.build_opener(handler)
        response = opener.open("http://www.baidu.com")
        for item in cookie:
            print(item.name + "=" + item.value)
    #8.保存cookie 方式一  同时cookie可以写入到文件中保存，有两种方式http.cookiejar.MozillaCookieJar和http.cookiejar.LWPCookieJar()，当然你自己用哪种方式都可以
    def test_save_cookie1(self):
        filename = "./conf/cookie.txt"
        cookie = http.cookiejar.MozillaCookieJar(filename)
        handler = urllib.request.HTTPCookieProcessor(cookie)
        opener = urllib.request.build_opener(handler)
        response = opener.open("http://www.baidu.com")
        cookie.save(ignore_discard=True,ignore_expires=True)

    #9.保存cookie 方式二
    def test_save_cookie(self):
        filename = "./conf/cookie1.txt"
        cookie = http.cookiejar.LWPCookieJar(filename)
        handler = urllib.request.HTTPCookieProcessor(cookie)
        opener = urllib.request.build_opener(handler)
        response = opener.open("http://www.baidu.com")
        cookie.save(ignore_discard=True, ignore_expires=True)

    #10.同样的如果想要通过获取文件中的cookie获取的话可以通过load方式，当然用哪种方式写入的，就用哪种方式读取。
    def test_read_cookie(self):
        cookie = http.cookiejar.LWPCookieJar()
        cookie.load("cookie1.txt",ignore_expires=True,ignore_discard=True)
        handler = urllib.request.HTTPCookieProcessor(cookie)
        opener = urllib.request.build_opener(handler)
        response = opener.open("http://www.baidu.com")
        print(response.read().decode("utf-8"))

    #11.异常处理
    #下面代码访问的是一个不存在的页面，通过捕捉异常，我们可以打印异常错误
    def test_except(self):
        try:
            response = urllib.request.urlopen("http://pythonsite.com/1111.html")
        except urllib.error.URLError as e:
            print(e.reason)
            print(type(e.reason))
            if isinstance(e.reason,socket.timeout):
                print("timeout")

    #12.这里我们需要知道的是在urllb异常这里有两个异常错误：
    """URLError,HTTPError，HTTPError是URLError的子类
    URLError里只有一个属性：reason,即抓异常的时候只能打印错误信息，类似上面的例子
    HTTPError里有三个属性：code,reason,headers，即抓异常的时候可以获得code,reson，headers三个信息
    """
    def test_except1(self):
        try:
            response = urllib.request.urlopen("http://pythonsite.com/1111.html")
        except urllib.error.HTTPError as e:
            print(e.reason)
            print(e.code)
            print(e.headers)
        except urllib.error.URLError as e:
            print(e.reason)
        else:
            print("request successfully")


    #13.URL解析 urlparse()
    '''这里就是可以对你传入的url地址进行拆分
    同时我们是可以指定协议类型：
    result = urlparse("www.baidu.com/index.html;user?id=5#comment", scheme="https")
    这样拆分的时候协议类型部分就会是你指定的部分，当然如果你的url里面已经带了协议，你再通过scheme指定的协议就不会生效
    '''
    def test_urlparse(self):
        result = urllib.parse.urlparse("http://www.baidu.com/index.html;user?id=5#comment")
        print(result)

    #14 urlunpars与urlparse()功能相反，用于拼接
    def test_urlunpars(self):
        data = ["http","www.baidu.com","index.html","user","a=123","comment"]
        result = urllib.parse.urlunparse(data)
        print(result)

    #15 urljoin() 这个是做拼接的。拼接的时候后面的优先级高于前面的url
    def test_urljoin(self):
        print(urllib.parse.urljoin("http://www.baidu.com", "FAQ.html")) #拼接在一起
        print(urllib.parse.urljoin("http://www.baidu.com", "https://pythonsite.com/FAQ.html"))#优先后面的url
        print(urllib.parse.urljoin("www.baidu.com#comment", "?category=2"))

    #16.urlencode() 这个方法将字典转换为url参数
    def test_urlencode(self):
        params = {"name":"zhaosan","age":28}
        data = urllib.parse.urlencode(params)
        base_url = "http://www.baidu.com?"
        url = base_url + data
        print(url)





if __name__ == "__main__":
    if __name__ == '__main__':
        unittest.main()
