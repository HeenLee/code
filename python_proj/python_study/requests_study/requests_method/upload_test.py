import  requests
base_url = "http://httpbin.org"
file = {"file":open("test.bmp","rb")}
cookie = {"uid":"111"}
r = requests.post(base_url + "/post",files = file,cookies = cookie)
print(r.url)
print(r.status_code)
print(r.text)