"""
读取位置及设置指针位置
# 读取文件的位置
file_name = "D:/hello.txt"with open(file_name, "rb") as file_obj:
    # print(file_obj.read(100))
    # print(file_obj.read(20))
    # seek()可以修改当前读取的位置
    file_obj.seek(55)
    file_obj.seek(70,1)  #从当前的读，如果前面有指针，就加上
    #file_obj.seek(1,2)  #从最后位置读    


    # seek()需要两个参数
    # 第一个是要切换到的位置
     # 第二个 计算位置方式
      # 可选值
      # 0 从头计算，默认值
      # 1 从当前位置计算
      # 2 从最后位置开始计算
      file_obj.read()
       # tell()方法用来查看当前读取的位置
       print("当前读取到了-->", file_obj.tell())


#文件的其他操作 删除、重命名、移动
import os
#listdir() 获取指定目录结构，需要一个路径作为参数，返回列表
r = os.listdir()
#getcwd()获取当前所在目录
r = os.getcwd()
#chdir()切换当前目录
os.chdir("..")
r = os.getcwd()
#mkdir()创建目录
#rmdir()删除目录
#remove()删除文件
#rename()重命名  也可以移动一个文件
print(r)
"""