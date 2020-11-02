
import  requests
base_url = "http://httpbin.org"

form_data = {"uname":"test00002","pwd":"123456"}
#post请求参数在body中
r = requests.post(base_url + "/post",data=form_data)
print(r.url)
print(r.status_code)
print(r.text)