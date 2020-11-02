#coding=utf-8
"""
类变量：类变量在整个实例化的对象中是公用的。类变量定义在类中且在函数体之外。类变量通常不作为实例变量使用
局部变量：定义在方法中的变量，只作用于当前实例的类。
实例变量：在类的声明中，属性是用变量来表示的，这种变量就称为实例变量，实例变量就是一个用 self 修饰的变量
__init__   __new__  __call__
"""
class Cat:
    i = 1 # 类变量   所有对象都共享这个变量
    def __init__(self,name):
        #实例变量
        self.name = name
    def say(self):     #方法
        print("hello")


# Cat().age= 12
class Dog:
    men = "nomen"  #类变量
    def __init__(self,name,age):
        self.name = name        #实例变量
        self.age = age
    def bark(self):
        #print("我不是" + self.mem)    #这样访问会报错AttributeError: 'Dog' object has no attribute 'mem'。实例属性访问不了类属性
        print("我是" + self.name + " ，我" + str(self.age) + "岁了!")
        print("汪汪")
    def run(self):
        print("跑")

d = Dog("xiaobai",2)
print(d.men)
d.bark()
print(d)
print(d.__class__)
