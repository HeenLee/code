import requests
base_url = "http://httpbin.org"
proxy = {"http":"127.0.0.1:8080"}
r = requests.get(base_url + "/get",proxies = proxy)