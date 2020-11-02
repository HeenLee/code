# coding=utf-8
'''
%s 字符串中表示任意字符
%f 浮点数占位符#
%d 整数占位符
'''
a = "hello"
print("a = %s" % a)
print("hello %s" % "world")
print("hello %s 你好 %s" % ("tom", "jerry"))
print("hello %3.5s" % "ab")  # 最少三位 不超过五位
print("hello %d" % 123)
print("hello %.2f" % 123.456)
# c = f"hello {a} {b}"  # python3.6以上支持
