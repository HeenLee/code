#闭包
# _*_coding=utf8 _*_
def func(a,b):
    c = 10
    def inner_func():
        s = a + b + c
        print(s)
    return inner_func


sum = func(1,2) #sum就是inner_func
#调用函数
sum()


#可以定义多个内部，只返回一个
def func(a,b):
    def func1():
        pass
    def func2():
        pass
    return func2


