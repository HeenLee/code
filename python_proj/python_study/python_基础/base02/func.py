#coding=utf-8
'''
加了星号 * 的参数会以元组(tuple)的形式导入
**是以字典的形式传入

匿名函数：lambda [args1,args2...]:expression  例如，lambda x,y : x+y
return [表达式] 语句用于退出函数，选择性地向调用方返回一个表达式。不带参数值的return语句返回None
'''
a = lambda x,y : x+y

def sum(x,y):
    total = x + y
    return total
print(sum(10,20))