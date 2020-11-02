# _*_ coding=utf-8 _*_
f = open('d:/hello.txt',"w+")

# print(f.read())  #全部读取
content = f.read(10) #读取n个大小的内容
print(type(content))
f.write(content)
# print(f.readline()) #读取一行
# print(f.readlines()) #全部读取，返回列表
#
a = f.write("ssss\n")
print(a)
# f.write("1")
# f.writelines("abc\n")
# f.writelines(("3","4"))
b = f.writelines(["xxxx\n","yyyy\n"])
print(b)
f.close()

'''
while True:
    line = f.readlines()
    if not line:   #读取完后，返回空
        break

'''
import os
import os.path