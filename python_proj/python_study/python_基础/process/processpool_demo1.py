# _*_ coding=utf-8 _*_
'''
进程池
非阻塞式：一次添加完后
阻塞式：添加一个进程执行，然后返回，再添加
'''
from multiprocessing import Pool
import time
import random
import os
#非阻塞式进程：把全部任务加载到队列，然后往池子里加。 池子中的任务完成后，从队列继续取任务。任务完成后，再回调
def task(task_name):
    print("开始做任务",task_name)
    start = time.time()
    #模拟任务 sleep
    time.sleep(random.random()*2)
    end = time.time()
    #print("完成{}任务耗时{},进行id:{}".format(task_name,(end-start),os.getpid()))
    return "完成{}任务耗时{},进行id:{}".format(task_name,(end-start),os.getpid())

#上面任务执行完，返回的结果给下面的回调函数。
container = []

def callback_func(n):
    container.append(n)

if __name__ == '__main__':
    pool = Pool(5)
    tasks = ['听音乐','吃饭','洗衣服','打游戏','散步','看孩子','做饭']
    for task1 in tasks:
        pool.apply_async(task,args=(task1,),callback=callback_func)  #非阻塞式
    pool.close()   #添加任务结束
    pool.join()   # 插队，主线程让步

    for c in container:
        print(c)
    print('over!!!')




