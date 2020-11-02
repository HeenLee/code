'''
创建两个线程，放在线程列表中
'''
import threading
import time
def music(func):
    for i in range(2):
        print("begin listening to %s .%s" % (func,time.ctime()))
        time.sleep(4)
        print("end listending %s" % time.ctime())
def move(func):
    for i in range(2):
        print("begin watching at the % s ! %s" % (func,time.ctime()))
        time.sleep(5)
        print('end watching %s' % time.ctime())

threads = []
t1 = threading.Thread(name = 'son1',target=music,args=('七里香',))
threads.append(t1)

t2= threading.Thread(name = 'son2',target=move,args=('阿甘正传',))
threads.append(t2)

if __name__ == "__main__":
    for i in threads:
        i.setDaemon(True)
        i.start()

    # print(t1.current_thread())
    print(threading.current_thread())
    print("all over %s" % time.ctime())