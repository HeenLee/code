# _*_ coding=utf-8 _*_
# Process(target= , name= , args=)   target是任务，name是名称，args是任务的参数，是一个可迭代的对象.元组需要带括号
from multiprocessing import Process
import time
import os
def task1(s):
    while True:
        time.sleep(s)
        print("----------task1------------")

def task2(s):
    while True:
        time.sleep(s)
        print("--------task2-----------")

number = 1
if __name__ == "__main__":
    p1  =  Process(target=task1,name="任务1",args=(1,))
    p1.start()   #启动进程

    p2 = Process(target=task2,name="任务2",args=(2,))
    p2.start()

    while True:
        number+=1
        if number == 100:
            p1.terminate()  #终止进程
            p2.terminate()
            break
        else:
            print("-----number",number)
    print("-----")
    print("*****")
