#! _*_ coding:utf8 _*_
'''
python logging 重复写日志问题:遇到了重复记录日志的问题，第一条记录写一次，第二条记录写两次，第三条记录写三次
'''
import logging

def log():
    logger = logging.getLogger('testlog')
    logger.setLevel(logging.DEBUG)
    #方法1：添加handler之前先清理一下
    logger.handlers.clear()
    streamHandler = logging.StreamHandler()
    streamHandler.setLevel(logging.DEBUG)
    formatter = logging.Formatter("%(asctime)s - %(levelname)s - %(name)s - %(message)s")
    streamHandler.setFormatter(formatter)

    logger.addHandler(streamHandler)

    # 方法2：判断一下，有的话就不加了。判断logger是否已经添加过handler，是则直接返回logger对象，否则执行handler设定以及addHandler(ch)
    # if not logger.handlers:
    #     ch = logging.StreamHandler()
    #     ch.setLevel(logging.INFO)
    #     fmt = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    #     ch.setFormatter(fmt)
    #
    #     logger.addHandler(ch)

    return logger

log().info('one')
log().info('two')
log().info('three')


