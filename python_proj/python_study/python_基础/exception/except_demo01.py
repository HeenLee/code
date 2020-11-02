#coding=utf-8
'''
异常处理：
try:
    代码块：可能出现错误的语句
except 异常类型as 异常名:
    代码块：出现错误以后的处理方式
except 异常类型as 异常名:
    代码块：出现错误以后的处理方式
except 异常类型as 异常名:
    代码块：出现错误以后的处理方式
else:
    代码块：没有出错时要执行的语句 出现异常，执行了except，就不会执行try和else。 没有异常，则执行try else
finally：
    代码块：该代码块总会执行
try是必须的，else有没有都行，except和finally至少有一个


抛出异常： 使用 raise 语句抛出一个指定的异常，后边跟一个异常类，或异常类的实例
  raise Exception
  raise Exception("具体信息")
抛出异常的目的，告诉调用者这里调用时出现问题，希望你自己处理一下


自定义异常
创建一个类继承Exception即可
class MyError(Exception):
    pass
'''
