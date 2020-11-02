#coding=utf-8
#定义类和属性
#类属性
#对象属性
class Phone():
    brand = 'huawei' #类属性，被所有对象共享。 对象如果修改后，对其不影响

    pass
print(Phone.brand)
# Phone.brand = 'xiaomi'

p1 = Phone()
print(p1.brand)
p1.brand = 'iphone'
print("修改后",p1.brand)

p2 = Phone()
print(p2.brand)