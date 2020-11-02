import json
import requests
data = {'username': 'test_user', 'password': '123456', 'client_id': 'testClient', 'client_secret': '99d1873f-0486-431e-8e85-61350ba4a561', 'grant_type': 'password'}
print(type(data))
# print(json.dumps(data))
print(data)
res = requests.post("https://bplusdev.sinosun.com:18180/auth/realms/bplusdev/protocol/openid-connect/token",data=data)
print(res.content)

#get«Î«Û
print(res.request.headers)
print(res.request.url)

#post«Î«Û
print(res.request.url)
print(res.request.headers)
print(res.request.body)
