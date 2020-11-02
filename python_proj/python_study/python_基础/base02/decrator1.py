#coding=utf-8
'''
装饰器（闭包）：扩展函数的内容。装饰器本身是一个函数，用于装饰其他函数。增强被装饰函数的功能
装饰器一般接收一个函数作为参数，以对其进行增强
'''
def deco(func):  #1.deci是装饰器，func是需要被扩展的函数
    def wrapper():
        print("say something")
        result = func()                #调用函数本身
        print("end")
        return result           #返回内部结果
    return wrapper        #返回内部函数  闭包
@deco
def show():
    print("hello world")
show()



def begin(ss):   #1.被装饰的函数作为参数，begin是装饰器，ss是被装饰的函数
    def hello(*args,**kwargs):       #2.如果需要参数
        print("start")
        result = ss(*args,**kwargs)    #3.把参数传入被装饰的函数中
        print("end")
        return result                   #4.返回被装饰函数的结果值
    return hello                        # 5.返回内部函数
@begin                                  #6.装饰器的使用
def say():                              #7.定义被装饰的函数
    print("haole")
say()                                   #8.调用被装饰的函数


def decorator(func):
    a = 100
    print("start")
    def wrapper():
        print('-----111')
        func()
        print('---2222')
        print(a)
    print("end")
    return wrapper


@decorator
def house():
    print('我是毛坯房')

house()