"""
调用read()会将文件文件的所有内容全部读取。如果读取文件较大，会一次性将文件的内容加载到内存中，耗时，导致内存泄露。\
对于较大的文件，不要直接调用read()。可以指定size
read(size)


操作文件步骤：
打开文件-->对文件进行各种操作（读、写）,然后保存-->关闭文件
file_name = "d:/abc.txt"
#调用open打开文件
file_obj = open(file_name)

#当获取了文件对象以后，所有的对文件的操作都应该通过对象来进行
#读取文件中的内容 read()用来读取文件中的内容
content = file_obj.read()
print(content)
#关闭文件，调用close()
file_obj.close()

"""