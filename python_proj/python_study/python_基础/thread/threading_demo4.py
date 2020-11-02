# _*_coding=utf8 _*_
import os
import threading
import time

"""
死锁：资源使用不当
避免死锁：
1.重构代码
2.添加锁timeout

"""
lockA = threading.Lock()
lockB = threading.Lock()


class MyThread(threading.Thread):
    def run(self):
        if lockA.acquire():  # 如果获取到锁，则返回True
            print(self.name + "获取了A锁")
            time.sleep(0.1)
            if lockB.acquire(timeout=5):    #加上timeout就会释放锁
                print(self.name + "又获取了B锁，原来还有A锁")
                lockB.release()
            lockA.release()


class MyThread1(threading.Thread):
    def run(self):
        if lockB.acquire():  # 如果获取到锁，则返回True
            print(self.name + "获取了B锁")
            time.sleep(0.1)
            if lockA.acquire(timeout=5):
                print(self.name + "又获取了A锁，原来还有B锁")
                lockA.release()
            lockB.release()


if __name__ == '__main__':
    t1 = MyThread()
    t2 = MyThread1()
    t1.start()
    t2.start()
