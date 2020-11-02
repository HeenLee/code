#coding=utf-8
"""
私有化 __属性：就是将属性私有化，访问范围仅限于类中
封装：1.私有化属性 2.定义公有set get方法
"""

class Student:
    """私有属性"""
    def __init__(self, name, age, score):
        self.__name = name
        self.__age = age
        self.__score = score

    """公有方法"""
    def set_name(self,name):
        self.__name = name

    def  get_name(self):
        return self.__name

    def set_age(self, age):
        if age > 0 and age <= 120:
            self.__age = age
        else:
            print("年龄超出范围")

    def get_age(self):
        return self.__age

    def set_score(self, score):
        self.__score = score

    def get_score(self):
        return self.__score

    def __str__(self):
        return "姓名：{}，年龄：{}，分数：{}".format(self.__name, self.__age,self.__score)

s = Student("小米",12,89)
#print(s.__score)          #直接访问不到
print(s)
s.set_age(1000)
print(s)
print(dir(s))
print(s.__dir__())
print(s.__dict__)

