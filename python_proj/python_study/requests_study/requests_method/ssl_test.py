import requests

#base_url = "http://httpbin.org"
#r = requests.get(base_url + "",)

r= requests.get("https://www.12306.cn",verify=True)
print(r.text)