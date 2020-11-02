import requests
base_url = "http://httpbin.org"

r = requests.get(base_url + "/get")
print(r.status_code)

r = requests.post(base_url + "/post")
print(r.status_code)

