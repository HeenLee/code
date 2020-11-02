import requests
import json
'''
post带参数的请求。 
请求类型为x-www-frome-urlencoded    print(res.request.body)   username=test_user&client_secret=99d1873f-0486-431e-8e85-61350ba4a561&client_id=testClient&grant_type=password&password=123456
请求类型为application/json  print(res.request.body) {"phone": "15116263899", "tags": "sino", "userId": 123, "companyId": 111, "address": "\u897f\u5b89\u96c1\u5854", "name": "lili", "area": "\u4e2d\u56fd\u9655\u897f", "areaCode": "0731", "de
'''
#第一步获取token  post请求 参数是x-www-from-urlencoded，放在data中
url = 'https://bplusdev.sinosun.com:18180/auth/realms/bplusdev/protocol/openid-connect/token'
data = {
           "grant_type":"password",
            "client_id":"testClient",
            "username":"test_user",
            "password":"123456",
            "client_secret":"99d1873f-0486-431e-8e85-61350ba4a561"
        }
res = requests.post(url,data=data)
print(res.content)
jsonData = json.loads(res.content.decode('utf8'))
access_token = jsonData['access_token']
# print(res.content)
# print(res.url)
# print(res.encoding)
# print(res.headers)
# print(res.request.headers)
# print(res.request.body)        username=test_user&client_secret=99d1873f-0486-431e-8e85-61350ba4a561&client_id=testClient&grant_type=password&password=123456
#第二步是添加收货地址，post请求，参数是json  放在json中
url1 = 'https://bplusdev.sinosun.com:18180/customer-profile/v1/addAddress'
token = access_token
json_add = {
            'userId':123,
            'companyId':111,
            'channelId':1,
            'area':'中国陕西',
            'address':'西安雁塔',
            'phone':'15116263899',
            'name':'lili',
            'tags':'sino',
            'defaultFlag':False,
            'areaCode':'0731'
         }

headers = {
            'Authorization':"Bearer " + access_token,
            'content-type':'application/json'
            }
res1 = requests.post(url1,json=json_add,headers=headers)
content = res1.content.decode('utf8')
print( "a",content)
item = json.loads(content)
print(item['result'])
id = item['result']['id']
print(id)
print(res1.request.headers)
print(res1.request.body.decode('utf8'))

#第三步 get请求，带参数.会自动把参数放在url的后面
url_get = "https://bplusdev.sinosun.com:18180/customer-profile/v1/listAddress"
parm = {
    'userId':123,
    'companyId':111,
    'channelId':1
}
res_get = requests.get(url_get,params=parm)
print(res_get.content)
print('-----',res_get.request.url)

#第四步，删除地址  post请求，参数是json， 放在json中
url2 = 'https://bplusdev.sinosun.com:18180/customer-profile/v1/deleteAddress'

json_dele = {
                "userId": 123,
                "companyId": 111,
                "channelId": 1,
                "ids": [id]
            }
res_dele = requests.post(url2,json=json_dele,headers=headers)
print(res_dele.content)