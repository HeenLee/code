# _*_ coding=utf-8 _*_
from multiprocessing import Process
import time
import os

'''
自定义进程

'''
class MyProcess(Process):
    def __init__(self,name):
        super().__init__()
        #super(MyProcess,self).__init__()  两个都可以
        self.name = name
    #重写run方法
    def run(self):
        n=1
        while True:
            print('{}____自定义进程,n={}'.format(n,self.name))
            n+=1

if __name__ == "__main__":
    p = MyProcess("小明")
    p.start()

    p2 = MyProcess("小红")
    p2.start()


