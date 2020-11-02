"""
文件写入
# 文件写入 write   write方法回会返回写入的字符的个数
file_name = “d:/hello.txt”
#使用open打开文件时必须指定打开文件的模式（读、写、追加） 如果不指定操作类型，默认是读取，
读取是不能够写入的
#使用w写入文件时，如果文件不存在会创建文件，如果文件存在则会覆盖之前的内容#a追加模式
#+为操作符增加功能
# r+ 既可读又可写，文件不存在会报错
# w+
# a+
with open(file_name, encoding=“utf-8”,mode=“a”) as file_obj:
    file_obj.write(“123\n”)    \n写入换行符
    file_obj.write(“abc”)
    lists = [“1”,“2”]
    file_obj.writelines(lists)  写入多个



二进制文件读写
# 二进制文件  图片 mp3
# 读取模式
# t 读取文本文件(默认值)
# b 读取二进制文件
file_name = "C:\\Users\\lihe\\Desktop\\Penguins.jpg"with open(file_name, "rb") as file_obj:
    # 读取文本文件时，size是以字符为单位的
    # 读取二进制文件时，size是以字节为单位的
    #print(file_obj.read(100)) #一次读取100字节
    # 将读取到的内容写出来
    # 定义一个新的文件
    new_name = "d:/a.jpg"
    with open(new_name, "wb") as new_obj:
        # 定义每次读取的大小
        chunk = 1024 * 10
        while True:
            # 从已有的对象中读取数据
            content = file_obj.read(chunk)
            # 内容读取完毕，终止循环
            if not content:
                break
            # 将读取到的数据写入到新对象中
            new_obj.write(content)


"""