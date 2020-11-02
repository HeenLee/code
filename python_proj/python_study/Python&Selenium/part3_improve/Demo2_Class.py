class ClassA(object):
    string = '这是一个字符串'

    def instance_func(self):
        print('这是一个实例方法')
        print(self)

    @classmethod
    def class_func(cls):
        print("这是一个类方法")
        print(cls)

    @staticmethod
    def static_func():
        print("这是一个静态方法")


test = ClassA()
test.instance_func()
test.class_func()
test.static_func()

print(test.string)

ClassA.instance_func(test)
ClassA.instance_func(ClassA)
ClassA.class_func()
ClassA.static_func()