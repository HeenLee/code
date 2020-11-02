# _*_ coding=utf-8 _*_
# Process(target= , name= , args=)   target是任务，name是名称，args是任务的参数，是一个可迭代的对象.元组需要带括号
from multiprocessing import Process
import time
import os

'''
多进程对于全局变量访问，在每一个全局变量里面都放一个m变量
保证每个进程访问变量互不干扰
'''
m = 1   #全局变量。  不可变类型，子进程不能共享，每个进程都有属于自己的m
list = []
def task1(s):
    global m
    while True:
        time.sleep(s)
        m+=1
        print("----------task1------------",m)

def task2(s):
    global m
    while True:
        time.sleep(s)
        print("--------task2-----------",m)

number = 1
if __name__ == "__main__":
    p1  =  Process(target=task1,name="任务1",args=(1,))
    p1.start()   #启动进程

    p2 = Process(target=task2,name="任务2",args=(2,))
    p2.start()

    while True:
        time.sleep(1)
        m+=1
        print("-------main",m)


