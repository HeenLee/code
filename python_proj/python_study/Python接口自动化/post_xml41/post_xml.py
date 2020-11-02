#coding=utf-8
import requests

url = 'http://httpbin.org/post'

body = '<?xml version="1.0" encoding = "UTF-8"?>' \
        '<COM>' \
        '<REQ name="北京-宏哥">' \
        '<USER_ID></USER_ID>' \
        '<COMMODITY_ID>123456</COMMODITY_ID>' \
        '<SESSION_ID>absbnmasbnfmasbm1213</SESSION_ID>' \
        '</REQ>' \
        '</COM>'
r = requests.post(url,data=body.encode("utf-8"))
print(r.text)