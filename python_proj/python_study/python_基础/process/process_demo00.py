# _*_ coding=utf-8 _*_
# Process(target= , name= , args=)   target是任务，name是名称，args是任务的参数，是一个可迭代的对象.元组需要带括号


from multiprocessing import Process
import time
import os
def task1(s):
    while True:
        time.sleep(s)
        print("----------task1------------",os.getpid(),"----",os.getppid())

def task2(s):
    while True:
        time.sleep(s)
        print("--------task2-----------",os.getpid(),"----",os.getppid())

if __name__ == "__main__":
    p1  =  Process(target=task1,name="任务1",args=(1,))   #子进程
    p1.start()   #启动进程
    print(p1.name)

    p2 = Process(target=task2,name="任务2",args=(2,))
    p2.start()
    print(p2.name)

    print("------main------") #这是主进程代码