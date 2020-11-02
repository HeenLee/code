# coding=utf-8
"""
多态
"""
class Animal:
    def __init__(self):
        print("我是父类")

    def run(self):
        print("动物跑")


class Dog(Animal):
    def __init__(self):
        print("我是狗类")

    def run(self):
        print("狗跑")


class Cat(Animal):
    def __init__(self):
        print("我是猫类")

    def run(self):
        print("猫跑")

#注意：这里给obj
def print_run(self,obj):
    print(obj.run())

class Person:
    def __init__(self,name,age):
        self.name = name
        self.age = age

    def keep(self,animal):
        animal.run()

p = Person("小明",12)
p.keep(Animal())
p.keep(Dog())
p.keep(Cat())