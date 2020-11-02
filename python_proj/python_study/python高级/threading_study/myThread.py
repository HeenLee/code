'''
继承threading.Thread类，重写run()方法
创建子类对象，调用start()方法
'''
import threading
import time


class MyThread(threading.Thread):
    def __init__(self, args):
        super().__init__()  # 此处要显示调用父类的初始化函数
        self.args = args

    def run(self):
        time.sleep(1)
        print('the args is :%s' % self.args)


for i in range(2):
    mt = MyThread(i)
    mt.start()
print('main thread end')
