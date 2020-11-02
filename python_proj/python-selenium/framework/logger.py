import time
import logging
import logging.handlers
import os.path

class Logger(object):
    def __init__(self,logger):
        '''
        指定保存日志的文件路径，日志级别，以及调用文件
        将日志存入指定的文件中
        '''
        #创建一个日志器logger，并设置其日志级别为DEBUG
        self.logger = logging.getLogger(logger)
        self.logger.setLevel(logging.DEBUG)

        #创建一个handler，用于写入日志文件
        stftime  = time.strftime("%Y-%m-%d %H%M",time.localtime(time.time()))

       #指定日志文件路径  项目根目录\logs下
        log_path = os.path.dirname(os.getcwd()) + "/logs/"
        print(log_path)

        #指定日志文件名称
        log_name = log_path + stftime + ".log"
        print(log_name)

        #创建文件handler
        fh = logging.FileHandler(log_name,encoding='utf-8')

        #创建格式器formatter
        formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
        fh.setLevel(logging.INFO)
        fh.setFormatter(formatter)

        #创建控制台handler
        ch = logging.StreamHandler()
        ch.setLevel(logging.INFO)
        ch.setFormatter(formatter)

        self.logger.addHandler(fh)
        self.logger.addHandler(ch)

    def getlog(self):
        return self.logger
