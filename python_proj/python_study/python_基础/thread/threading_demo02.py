# _*_coding=utf8 _*_
"""
线程可以共享全局变量的。
GIL：全局解释器锁
"""
import threading
n = 0

def task1():
    global n
    for i in range(10000000):
        n+=1
    print("task1中n的值",n)


def task2():
    global n
    for i in range(10000000):
        n-=1
    print("task2中n的值",n)


if __name__ == '__main__':
    t1 = threading.Thread(target=task1)
    t2 = threading.Thread(target=task2)
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    print(n)
