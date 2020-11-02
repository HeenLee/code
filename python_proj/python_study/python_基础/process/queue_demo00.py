# _*_ coding=utf8 _*_
"""
进程间通信:队列满，队列空都会阻塞

"""
from multiprocessing import Queue
q = Queue(5)
q.put("A")
q.put("B")
q.put("C")
q.put("D")
q.put("E")
print(q.qsize()) #队列大小
if not q.full():   #判断队列是否满      q.empty()判断队列是否空
    q.put("F",timeout=3)  #这里会阻塞   只能放5个  如果队列满了，则只能等待。除非有位置
else:
    print("队列已满")
#获取队列的值
print(q.get(timeout=2))
print(q.get(timeout=2))
print(q.get(timeout=2))
print(q.get(timeout=2))
print(q.get(timeout=2))
print(q.get(timeout=2))
q.put_nowait()
q.get_nowait()  #不等待，就不会阻塞了