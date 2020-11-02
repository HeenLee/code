# _*_ coding=utf8 _*_
"""
进程间通信:传一个公共的值。 就是队列
"""
import time
from multiprocessing import Process, Queue


def download(q):
    images = ['girl.jpg','boy.jpg','man.jpg']
    for image in images:
        print('正在下载：',image)
        time.sleep(1)
        q.put(image)

def getfile(q):
    while True:
        file = q.get()
        print("{}保存成功".format(file))
        if(q.empty()):
            break


if __name__ == '__main__':
    q = Queue(5)
    p1 = Process(target=download,args=(q,))
    p2 = Process(target=getfile, args=(q,))
    p1.start()
    p1.join()
    p2.start()
    p2.join()