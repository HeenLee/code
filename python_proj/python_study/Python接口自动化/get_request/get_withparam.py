import requests

param = {"name","hehe"}

r = requests.get("http://www.zhihu.com",data=param)
print(r.url)
print(r.text)
