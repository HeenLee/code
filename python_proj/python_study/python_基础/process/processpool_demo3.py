# _*_ coding=utf-8 _*_
'''
阻塞式：添加一个任务执行一个任务，如果一个任务不结束，另一个任务进不来。

'''
from multiprocessing import Pool
import time
import random
import os
#阻塞式进程：
def task(task_name):
    print("开始做任务",task_name)
    start = time.time()
    #模拟任务 sleep
    time.sleep(random.random()*2)
    end = time.time()
    print("完成{}任务耗时{},进行id:{}".format(task_name,(end-start),os.getpid()))
    # return "完成{}任务耗时{},进行id:{}".format(task_name,(end-start),os.getpid())


if __name__ == '__main__':
    pool = Pool(5)
    tasks = ['听音乐','吃饭','洗衣服','打游戏','散步','看孩子','做饭']
    for task1 in tasks:
        pool.apply(task,args=(task1,))  #  阻塞式
    # pool.close()   #添加任务结束   这里不需要加入两个方法
    # pool.join()   # 插队，阻塞主进程
    print('over!!!')




