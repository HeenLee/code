
import  requests
base_url = "http://httpbin.org"

cookie = {"uid":"666"}


r = requests.get(base_url + "/cookies",cookies=cookie,timeout=1)
print(r.text)
#获取响应时间s
print(r.elapsed.total_seconds())