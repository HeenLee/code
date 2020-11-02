class Foo: 

    def __init__(self, name):
        self.name = name 

    def ord_func(self):
        """定义实例方法，至少有一个self参数 """
        print('实例方法')

    @classmethod
    def class_func(cls):
        """ 定义类方法，至少有一个cls参数 """
        print('类方法')

    @staticmethod
    def static_func():
        """ 定义静态方法 ，无默认参数"""
        print('静态方法') 

# 调用实例方法
f = Foo("Jack")
f.ord_func()
Foo.ord_func(f) # 请注意这种调用方式，虽然可行，但建议不要这么做！

# 调用类方法
Foo.class_func()
f.class_func()  # 请注意这种调用方式，虽然可行，但建议不要这么做！

# 调用静态方法
Foo.static_func()
f.static_func() # 请注意这种调用方式，虽然可行，但建议不要这么做！

print(__doc__)