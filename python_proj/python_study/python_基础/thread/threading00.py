# _*_coding=utf-8 _*_
"""
两种方式：构造器传任务
子类继承threading.Thread  重写run()
线程的状态：新建 就绪 运行 阻塞 结束。  阻塞结束后会到就绪状态
线程间的通信：共享变量
"""
import threading
import time


def download(n):
    images = ['girl.jpg','boy.jpg','man.jpg']
    for image in images:
        print('正在下载：',image)
        time.sleep(n)
        print("下载{}成功".format(image))
def listenMusic():
    musics = ['大碗宽面','土耳其冰淇淋','烤面筋','烤馍片']
    for music in musics:
        print("正在听：{}".format(music))


if __name__ == '__main__':
     #线程对象
    t = threading.Thread(target=download,name='aa',args=(1,))
    t.start()

    t = threading.Thread(target=listenMusic, name='aa')
    t.start()
    n=1
    while True:
         n+=1
         time.sleep(0.5)
         print(n)