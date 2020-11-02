# coding=utf-8
#装饰器带参数,在原来的基础上再加一层函数。
# 带参数的装饰器是三层的，最外层的函数负责接收装饰器的参数
# 不带参数的装饰器是两层的
def outer(a):                  #第一层 负责接收装饰器的参数的
    def decorate(func):         #第二次 负责接收函数的
        def wrapper(*args,**kwargs):  #第三层 负责接收函数的参数
            func(*args,**kwargs)
            print('铺地板{}块'.format(a))
        return wrapper
    return decorate


@outer(10)    #
def house(time):
    print("我{}日期拿到钥匙，是毛坯房".format(time))

@outer(100)
def street():
    print("新修的街道")

house("2019-6-1")

street()