#coding=utf-8
"""
封装:增强数据的安全性，属性不能随意修改，属性不能修改为任意的值。隐藏对象中一些不希望被外部访问的属性或方法
隐藏属性：__双下划线开头的，无法通过对象访问。其实隐藏属性只不过是python自动为属性改了一个名字。
实际上改为._类名__属性名


"""
class Dog:
    def __init__(self,name,age):
        self.__name = name
        self.__age = age
    def get_name(self):
        return self.__name
    def set_name(self,name):
        self.__name = name
    def run(self):
        print(self.__name + "跑")

d = Dog("小强",12)

#print(d.__name)   #报错，隐藏的属性不能访问
print(d._Dog__name)