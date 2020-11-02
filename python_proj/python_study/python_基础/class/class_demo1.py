#类方法和静态方法不能访问对象属性、方法。 静态方法和类方法最好用类访问

class ClassA(object):
    string1 = "这是类属性变量"

    def instancefunc(self,name):
        print("这是一个实例方法")
        self.name = name   #实例属性
        print(self.string1)
        print(self)

    @classmethod
    def classfunc(cls,age):
        print('这是一个类方法')
        print(age)
        print(cls)

    @staticmethod
    def staticfun():
        print('这是一个静态方法')

    def show(self):
        self.instancefunc()
        self.classfunc()


test = ClassA() #初始化对象
test.instancefunc("mingming") #对象调用实例方法
test.staticfun() #对象调用静态方法     可以调用成功，最好还是类调用
test.classfunc(11) #对象调用类方法       可以调用成功，最好还是类调用
print(test.string1)  #对象调用类变量


ClassA.instancefunc(test,"aa")  #类调用实例方法 需要带参数，test是一个对象参数
ClassA.instancefunc(ClassA,"aa") #类调用实例方法，需要带参数，ClassA是一个类参数

ClassA.classfunc(12) #类调用类方法
ClassA.staticfun()  #类调用静态方法
#
# import os
# print(os.getcwd())
# print(os.path.abspath('.'))



