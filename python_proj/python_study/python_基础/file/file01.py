"""
1.
#with ... as 语句文件自动关闭
file_name = "d:/abc.txt"
with open(file_name) as file_obj:
    #在with语句中可以直接使用file_obj做文件操作
    print(file_obj.read())
eg.1
try:
    with open(file_name) as file_obj:
        print(file_obj.read())
except FileNotFoundError:
    print(f"{file_name} 文件不存在")

2.
文件读取read() read(size) readline() readlines()
调用open()打开文件，可以分为纯文本文件（使用utf-8等编码编写的文本文件），另一种是二进制文件（图片、mp3、ppt）
Open()打开文件时，默认以文本文件的形式打开，但是open()默认编码为null，处理不了中文
处理文本文件时，必须指定文件的编码
file_name = "d:/abc.txt"
try:
    with open(file_name,encoding="utf-8") as file_obj:
        print(file_obj.read())
except FileNotFoundError:
    print("{file_name} 文件不存在")

Read(size)，该参数用来指定要读取的字符的数量。
默认值为-1，它会读取文件中的所有字符
可以为size指定一个值，这样read()会读取指定数量的字符，
	每一次读取都是从上次读取到位置开始读取的
	如果字符的数量小于size，则会读取剩余所有的
	如果读取到了文件最后，则会返回””空串

file_name = "d:/abc.txt"
try:
    with open(file_name,encoding="utf-8") as file_obj:
        content = file_obj.read(1000)
        print(content)
        print(len(content))
except FileNotFoundError:
    print('{file_name} 文件不存在')


"""
