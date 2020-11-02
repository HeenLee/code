#coding=utf-8
'''
os 模块提供了非常丰富的方法用来处理文件和目录
os.getcwd()  获取当前所在目录
os.listdir(path)  返回path指定的文件夹包含的文件或文件夹的名字的列表
os.makedirs(path[, mode]) 递归文件夹创建函数
os.mkdir(path[, mode])   以数字mode的mode创建一个名为path的文件夹.默认的 mode 是 0777 (八进制)
os.remove(path)  删除路径为path的文件
os.removedirs(path) 递归删除目录
os.rename(src, dst)  重命名文件或目录，从 src 到 dst
os.renames(old, new) 删除path指定的空目录，如果目录非空，则抛出一个OSError异常。
os.rmdir(path)  删除path指定的空目录，如果目录非空，则抛出一个OSError异常。

os.path 模块获取文件的属性信息
os.path.abspath(path)	返回绝对路径
os.path.basename(path)	返回文件名
os.path.dirname(path)	返回文件路径
os.path.isfile(path)	判断路径是否为文件
os.path.isdir(path)	    判断路径是否为目录
os.path.join(path1[, path2[, ...]])	 把目录和文件名合成一个路径
os.path.split(path)	把路径分割成 dirname 和 basename，返回一个元组
'''
import os
print(os.getcwd())  #获取当前所在目录 绝对路径 #D:\PycharmProjects\sinosun\python_基础\base03
result = os.mkdir("d:/p3")
print(result)
print(os.access("d:/hello.txt",os.W_OK))

#os.path
print(os.path.basename(os.getcwd()))   #   绝对路径  base03     返回文件/文件夹的名称
print(os.path.basename("d:/hello.txt")) #hello.txt
print(os.path.dirname(os.getcwd()))     #返回文件/文件夹所在目录
print(os.path.split(os.getcwd()))    #('D:\\PycharmProjects\\sinosun\\python_基础', 'base03')
print(os.path.join(os.path.dirname(os.getcwd()),"base03"))

print(os.path.dirname(__file__))
print(os.path.dirname("D:/PycharmProjects/python_study/python_基础/os"))
print(os.path.split("D:/PycharmProjects/python_study/python_基础/os"))
print(os.path.splitext("D:/PycharmProjects/python_study/python_基础/os"))

print(os.path.getsize(__file__))  # 文件大小

print(os.path.getsize("D:/PycharmProjects/python_study/python_基础/os"))  #0

