'''
异常的传播（抛出异常）
当在函数中出现异常时，如果在函数中对异常进行了处理，则异常不会再继续传播。
如果函数中没有对异常进行处理，则异常会继续向函数条用出传播，即向上抛
如果函数调用处处理了异常，则不再传播，如果没有处理则继续向调用处传播。
知道传递到全局作用域（主模块）如果依然没有处理，则程序终止，并显示异常信息

except后面不跟具体的异常类型，则会捕获所有的异常
如果在except后跟着一个异常的类型，那么此时它只会捕获该类型的异常
except 异常类型

try:
except NameError:
except ZeroDivisionError:
...
except Exception:   //Exception是所有异常类的父类。如果except后跟的是Exception，也会捕获到所有异常

可以将异常赋值给异常对象e
except Exception as e:
try:
except:
else:
finally: 无论如何都会执行
'''