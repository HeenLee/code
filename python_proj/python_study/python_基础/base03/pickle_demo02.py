#coding=utf-8
'''
python的pickle模块实现了基本的数据序列和反序列化。
通过pickle模块的序列化操作我们能够将程序中运行的对象信息保存到文件中去，永久存储。
通过pickle模块的反序列化操作，我们能够从文件中创建上一次程序保存的对象。
dump() 将对象存储到文件
load() 将文件的内容加载到对象
'''
import pickle
data = {
        'a':[1,2,3],
        'b':"123"
        }
output = open("data.pk1","wb")
pickle.dump(data,output,protocol=None)
output.close()

file1 = open("data.pk1","rb")
data1 = pickle.load(file1)
print(data1)
