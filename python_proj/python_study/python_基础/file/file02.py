"""
#读取大文件file_name = "d:/abc.txt"
try:
    with open(file_name,encoding="utf-8") as file_obj:
        file_content = ""
        #定义一个变量，来指定每次读取的大小
        chunk = 100
         #创建循环读取文件的内容
         while True:
         #读取chunk大小的内容
            content = file_obj.read(chunk)
            #检查是否读取到了内容
             if not content:
                break
                 #输出内容
            print(content, end="")
            file_content += content
except FileNotFoundError:
    print('{file_name} 文件不存在')
print(file_content)


# 一行一行读取
file_name = "d:/hello.txt"
with open(file_name, encoding="utf-8") as file_obj:
    #content = file_obj.read()
    #readline()每次一行读取
     #readlines()该方法用于一行一行读取内容，一次性将读取到的内容封装到列表中返回
     #print(file_obj.readline())
     print(file_obj.readlines()[0])    #
     这个对file_obj也是一行一行读取
     for t in file_obj:
        print(t)



"""