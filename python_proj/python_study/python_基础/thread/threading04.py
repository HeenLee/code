#coding=utf-8
"""
Python3 线程中常用的两个模块为：
_thread
threading(推荐使用)

Python中使用线程有两种方式：函数或者用类来包装线程对象。
函数式：调用 _thread 模块中的start_new_thread()函数来产生新线程

threading 模块除了包含 _thread 模块中的所有方法外，还提供的其他方法：

threading.currentThread(): 返回当前的线程变量。
threading.enumerate(): 返回一个包含正在运行的线程的list。正在运行指线程启动后、结束前，不包括启动前和终止后的线程。
threading.activeCount(): 返回正在运行的线程数量，与len(threading.enumerate())有相同的结果。
除了使用方法外，线程模块同样提供了Thread类来处理线程，Thread类提供了以下方法:

run(): 用以表示线程活动的方法。
start():启动线程活动。
join([time]): 等待至线程中止。这阻塞调用线程直至线程的join() 方法被调用中止-正常退出或者抛出未处理的异常-或者是可选的超时发生。
isAlive(): 返回线程是否活动的。
getName(): 返回线程名。
setName(): 设置线程名。
"""
import  _thread
import time
def print_time(threadName,delay):
    count = 0
    while count < 5:
        time.sleep(delay)
        count += 1
        print("%s:%s" %(threadName,time.ctime(time.time())))


#创建两个线程
try:
    _thread.start_new_thread(print_time,("Thread-1",2,))
    _thread.start_new_thread(print_time,("Thread-2",4,))
except:
    print("error:无法启动")
while 1:
    pass
