# _*_coding=utf8 _*_
"""
线程可以共享全局变量的。
GIL：全局解释器锁
"""
import threading
ticket = 1000

def run1():
    global ticket
    for i in range(100):
        ticket-=1

def run2():
    global ticket
    for i in range(100):
        ticket-=1


if __name__ == '__main__':
    t1 = threading.Thread(target=run1)
    t2 = threading.Thread(target=run2)
    t1.start()
    t2.start()
    print(ticket)
