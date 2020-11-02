#coding=utf-8
import requests

url = 'http://httpbin.org/post'

with open("body.xml","r",encoding='utf-8') as f:
    body = f.read()
print(body)

r = requests.post(url,body.encode("utf-8"))
print(r.content)