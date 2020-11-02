
import  requests
base_url = "http://httpbin.org"

form_data = {"uname":"test00003","pwd":"123456"}
header = {"user-agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36"}

#post请求参数在body中
'''
r = requests.post(base_url + "/post",data=form_data,headers=header)
print(r.url)
print(r.status_code)
print(r.json())
'''

r1 = requests.get("https://www.zhihu.com/explore",headers=header)
print(r1.text)