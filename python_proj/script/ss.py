#_*_ coding=utf-8
import json
import os.path

# with open("C:/Users/lihe/Desktop/com/combined/CartTest.postman_collection.json",'r') as f:
#     data = json.load(f,encoding='utf8')
# print(type(data),data)
# jsonData = json.dumps(data)
# print(type(jsonData),jsonData)
# ss = data.get("info").get("schema")
# print(type(ss),ss)
# print(type(jsonData))
# print(jsonData.info.name)

import time
# s = json.loads('a.json',encoding='utf8')
# with open('a.json','rb') as f:
#     data = json.load(f,encoding='utf8')
# print(data)
# print(data["type"]["name"])
# data["type"]["name"] = 'll'
# print(data["type"]["name"])
# print(data)
# with open('a.json','wb') as f:
#     json.dump(data,f)
#
# # with open('abc.txt','rb') as f:
# #     with open('s.txt','w') as outfile:
# #         for content in f:
# #             content = content.rstrip()
# #             outfile.writelines(content + '\n')
# with open('C:/Users/lihe/Desktop/com/abc.txt', 'r') as f1:
#     with open('C:/Users/lihe/Desktop/com/s.txt', 'w') as f2:
#         f2.write(f1.read())
print os.path.abspath(__file__)
print os.path.dirname(os.path.abspath('d:/mall/test/'))
print(os.path.abspath('d:/mall/test/'))

for file  in os.listdir("d:/mall"):
    print(os.path.basename(file))

# count = 0
# while (count < 3):
#     if (os.path.exists("d:/hello")):
#         break
#     else:
#         time.sleep(5)
#         count += 1
# else:
#     assert False
    #print(f.readline())
# print type(s),s
# print s.keys()
# print s["name"]
# print s["type"]["name"]
# print s["type"]["parameter"][1]
# s["type"]["name"] = 'll'
# print s["type"]["name"]
# a = json.load('a.json',encoding='utf8')
import sys
print(sys.getdefaultencoding())
# reload(sys)
# sys.setdefaultencoding('utf-8')
# print(sys.getdefaultencoding())
print(sys.maxint)
# with open("a.json",'r') as f:
#     a = json.load(f,encoding='utf8')
# print(a)
s = 'abcde'
# print(s[-100:100])
# for i in range(-1,-len(s),-1):
#     # print(s)
#     # s =
#     print(s[:i])
i = 0;
#满足while时，执行循环。 直到不满足，然后执行else
# while i < 3 :
#     print(i)
#     i+=1
# else:
#     print("False")
# f = open("d:/abc.txt","r")
# print(type(f))
# a = f.readline().strip()
# # print(type(a))
# print(a)
# f.close()
# import collections
# with open("d:/hello/b.json") as f:
#     data = json.load(f,encoding='utf8',object_pairs_hook=collections.OrderedDict)
# print(data)
# print(data['values'])
# data["values"][0]["value"] = 123
# with open("d:/hello/b.json","w") as f:
#     json.dump(data,f,encoding='utf8')
#
# import hashlib
# a = 'abc'
# m5 = hashlib.md5()
# m5.update(a)
# b = m5.hexdigest()
# print(b,type(b))
'''
1.类属性可以通过类或者实例访问
'''


class Demo():
    count = 0   #类属性 也是静态成员。只能通过类来更新
    # def __init__(self,name,age):
    #     self.name = name   #实例属性
    #     self.age = age


d = Demo()
print(d.count)
print(Demo.count)     #
Demo.count = 2
print(d.count)
print(Demo.count)
d.count=1
print(Demo.count)
print(d.count)

# print

# import logging
# log = logging.getLogger("__name__")
# log.setLevel(logging.DEBUG)
# stftime = time.strftime('%Y-%m-%d-%H-%M-%S', time.localtime(time.time()))
# #生成日志的路径
# log_path = './' + stftime + '_test.log'
# fh = logging.FileHandler(log_path,encoding='utf8')
# #设置日志输出格式
# formatter = logging.Formatter("%(asctime)s - %(filename)s - %(levelname)s - %(message)s")
# fh.setLevel(logging.DEBUG)
# fh.setFormatter(formatter)
# log.addHandler(fh)
#
# mes = "abc"
# a=1
# b=2
# log.debug("requestParam: %s, host:%s, path:%s" % (mes,a,b) )
# log_path = os.path.dirname(__file__)
# print(log_path)
# print(log)

print(os.getcwd())
print(os.path.dirname(os.path.dirname(__file__)))
print os.path.dirname(os.getcwd())

print(__file__)
print(__name__)
import  re

# m = re.match('foo','foo')
# m = re.search('foo','seafood')
bt = 'bat|bet|bit'
m =re.match(bt,'bat')
result = m.groups()
result1 = m.group()
print(result)
print result1




