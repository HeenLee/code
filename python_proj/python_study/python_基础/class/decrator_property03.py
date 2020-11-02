#coding=utf-8
"""
property装饰器 ： getter装饰器和setter装饰器


"""
class Dog:
    def __init__(self,name):
        self.__name = name
    '''
    @property 是装饰器，用来将一个get方法转换为对象的属性。添加property后，就可以像调用属性一样使用get方法
        使用property装饰的方法，必须和属性名是一样的。
    '''
    @property        #get装饰器
    def name(self):
        return self.__name

    @name.setter        #set装饰器  @属性名.setter
    def name(self,name):   #使用装饰器setter可以改变赋值
        self.__name = name


d = Dog("旺财")
d.name = "xiaoxiao"
print(d.name)