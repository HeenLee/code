
import  requests
base_url = "http://httpbin.org"

cookie = {"uid":"555"}

r = requests.get(base_url + "/cookies",cookies=cookie)
print(r.status_code)
print(r.text)