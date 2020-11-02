'''
通过传入函数对象创建线程
创建两个线程
'''
import threading
import time
def foo(n):
    print("foo%s" % n)
    time.sleep(1)
def bar(n):
    print("bar%s" % n)
    time.sleep(2)
t1 = threading.Thread(target=foo,args=(1,))
t2 = threading.Thread(target=bar,args=(2,))
t1.start()
t2.start()

print("...in the main...")