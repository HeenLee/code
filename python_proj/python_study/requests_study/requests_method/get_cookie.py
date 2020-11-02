
import  requests
base_url = "http://www.baidu.com"

r = requests.get(base_url)
print(r.status_code)
print(r.text)
print(r.cookies)
print(type(r.cookies))

for key,value in r.cookies.items():
    print(key + ":" + value)

