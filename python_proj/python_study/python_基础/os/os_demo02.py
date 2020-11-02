# _*_ coding=utf8 _*_
import os
import os.path

# os.mkdir("d:/p1")  #创建目录
# os.mkdir("d:/p1/p2")  # 不能递归创建
# os.makedirs("d:/p1/p2")  #递归创建
# os.rmdir("d:/p1/p2")  #只删除p2目录

# os.mkdir("d:/p3")
# os.rmdir("d:/p3")  #删除空目录

os.makedirs("d:/p1/p2/p3")  #递归创建
os.removedirs("d:/p1/p2/p3") #递归删除

# os.mkdir("d:/p1")
# os.rmdir("d:/p1")

# os.removedirs("d:/p1")

print(os.listdir("D:/"))