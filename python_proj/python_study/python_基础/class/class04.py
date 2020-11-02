#coding=utf-8
"""
开发中私有化的处理：装饰器
把get set方法当属性一样使用
"""
class Student:
    def __init__(self,name,age):
        self.name = name   #未私有化
        self.__age = age   #私有化

    """装饰器，先给get装"""
    @property
    def age(self):                 #相当于get()方法   名称和下面的都是age
        return self.__age

    @age.setter    #"""后给set"""        #相当于set()方法
    def age(self,age):
        if age > 0 and age < 100:
            self.__age = age
        else:
            print("不在范围内")




s = Student("华为",20)
s.name = '荣耀'
print(s.name)
s.age = 18
print(s.age)