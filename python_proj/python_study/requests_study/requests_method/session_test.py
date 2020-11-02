import requests
s = requests.Session()
base_url = "http://httpbin.org"

r = s.get(base_url + "/cookies/set/uid/666")
print(r.text)
print("-------------")

r= s.get(base_url  + "/cookies")
print(r.text)