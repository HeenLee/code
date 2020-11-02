
import  requests
base_url = "http://httpbin.org"

param_data = {"uname":"test00001","pwd":"123456"}
#get请求URL参数
r = requests.get(base_url + "/get",params=param_data)
print(r.url)
print(r.status_code)