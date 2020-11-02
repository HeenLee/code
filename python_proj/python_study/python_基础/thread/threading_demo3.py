# _*_coding=utf8 _*_

import threading
import time

lock = threading.Lock()

list=[0]*10
def task1():
    #获取锁,如果已经被其他上锁，则等待锁的释放
    lock.acquire() #阻塞

    for i in range(len(list)):
        list[i] = 1
        time.sleep(0.5)
    lock.release()

def task2():
    lock.acquire()
    for i in range(len(list)):
        print("------",list[i])
        time.sleep(0.5)
    lock.release()

if __name__ == '__main__':
    t1 = threading.Thread(target=task1)
    t2 = threading.Thread(target=task2)
    t2.start()
    t1.start()

    t2.join()
    t1.join()
    print(list)

