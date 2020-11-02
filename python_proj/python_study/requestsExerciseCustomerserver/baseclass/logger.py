#! _*_ coding:utf8 _*_
'''
日志类，定义生成类
'''
import time
import logging
from logging.handlers import RotatingFileHandler
from logging.handlers import TimedRotatingFileHandler
import os


class Logger():
    strftime = time.strftime('%Y-%m-%d', time.localtime(time.time()))

    def __init__(self):
        return None

    def getLog(self):
        '''
        生成日志
        :return:
        '''
        self.logger = logging.getLogger(__name__)
        self.logger.setLevel(logging.DEBUG)
        # 设置日志生成的路径
        log_path = os.path.dirname(os.getcwd()) + '/logs/' + self.strftime + ".log"
        formatter = logging.Formatter("%(asctime)s - %(name)s - %(levelname)s - %(message)s")
        # 定义日志回滚输入文件和流
        sh = logging.StreamHandler()   # 输出到流

        fh = logging.FileHandler(log_path, encoding='utf8')  # 输出到文件

        # rh = RotatingFileHandler(log_path,maxBytes=1024,backupCount=3)  #根据大小回滚

        # th = TimedRotatingFileHandler(log_path, when='S', interval=1, backupCount=3,encoding='utf8')  # 根据时间回滚
        # th.suffix = "%Y-%m-%d.log"

        sh.setFormatter(formatter)
        sh.setLevel(logging.DEBUG)

        fh.setLevel(logging.DEBUG)  # 输出到文件
        fh.setFormatter(formatter)

        # rh.setLevel(logging.DEBUG)  #
        # rh.setFormatter(formatter)

        # th.setLevel(logging.DEBUG)
        # th.setFormatter(formatter)

        self.logger.addHandler(sh)
        self.logger.addHandler(fh)
        # self.logger.addHandler(rh)
        # self.logger.addHandler(th)
        return self.logger

    # 删除logs目录下的log文件，只保留最近的5个
    def deleteLog(self):
        logs_path = os.path.dirname(os.getcwd()) + "/logs"
        # 遍历该目录
        for file, i in os.listdir(logs_path), len(os.listdir(logs_path)):
            if (i < len(os.listdir(logs_path)) - 5):
                os.remove(file)
