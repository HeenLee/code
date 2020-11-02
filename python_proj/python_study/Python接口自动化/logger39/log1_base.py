#coding=utf-8
"""
基本使用:配置logging基本的设置，然后在控制台输出日志
"""
import logging

'''logging.basicCongif函数参数：
    filename:指定日志文件名
    filemode:和file函数意义相同，指定日志文件的打开模式
    format:指定输出的格式和内容，format可以输出很多有用的信息
            参数：作用
            %(levelno)s：打印日志级别的数值
            %(levelname)s：打印日志级别的名称
            %(pathname)s：打印当前执行程序的路径，其实就是sys.argv[0]
            %(filename)s：打印当前执行程序名
            %(funcName)s：打印日志的当前函数
            %(lineno)d：打印日志的当前行号
            %(asctime)s：打印日志的时间
            %(thread)d：打印线程ID
            %(threadName)s：打印线程名称
            %(process)d：打印进程ID
            %(message)s：打印日志信息
    datefmt:指定时间格式，同time.strftime()
    level:设置日志级别，默认logging.WARNNING
    stream:指定日志的输出流，可以指定输出到sys.stderr,sys.stdout或者文件，默认输出到sys.stderr,当stream和filename
    同时指定时，stream被忽略
'''
logging.basicConfig(level=logging.INFO,format='%(asctime)s - %(name)s - %(levelname)s -  %(message)s')

#获取logger对象
logger = logging.getLogger(__name__)

logger.info("start print log")
logger.debug("do something")
logger.warning("something maybe fail")
logger.info("finish")

"""
logging中可以选择很多消息级别，如debug、info、warning、error以及critical。通过赋予logger或者handler不同的级别，
开发者就可以只输出错误信息到特定的记录文件，或者在调试时只记录调试信息。


设置消息的等级：
日志等级：使用范围
FATAL：致命错误
CRITICAL：特别糟糕的事情，如内存耗尽、磁盘空间为空，一般很少使用
ERROR：发生错误时，如IO操作失败或者连接问题
WARNING：发生很重要的事件，但是并不是错误时，如用户登录密码错误
INFO：处理请求或者状态变化等日常事务
DEBUG：调试过程中使用DEBUG等级，如算法中每个循环的中间状态
"""