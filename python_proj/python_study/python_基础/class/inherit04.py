#coding=utf-8
"""
继承：方法重写：   子类方法会覆盖父类的方法
调用对象的方法时，会优先去当前对象中寻找，如果没有，则去当前对象的父类中寻找，再去父类的父类中寻找。就进原则
super()：调用父类方法
super().__init__(name) 子类调用父类构造方法
super().父类方法()   子类调用父类方法

多重继承 classA(B,C)
__bases__这个属性可以获取当前类的所有父类：类名.__bases__


"""
class Animal:
    def __init__(self,name):
        self.__name = name
    def run(self):
        print("动物跑")
    def sleep(self):
        print("动物睡觉")

    @property   #相当于get()
    def name(self):
        return self.__name
    @name.setter
    def name(self,name):
        self.__name = name

class Dog(Animal):
    def __init__(self,name,age):
        #这里子类调用父类的构造方法
        #Animal.__init__(self,name)  #这里self必须传入，它指实例，不是类。不建议用Animal调用，用super
        super().__init__(name)   #这里不需要传self，对象调用父类方法   super(Doc,self).
        self.__age = age
    def bark(self):
        print("汪汪")
    def run(self):     #子类重新父类方法
        super().run()   #子类调用父类方法
        print("小狗跑")


d = Dog("小强",12)
d.run()
d.bark()
print(Dog.__bases__)    #多重继承查看所有的父类

