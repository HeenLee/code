"""
将日志写入到文件
设置logging，创建一个FileHandler,并对输出消息的格式进行设置，将其添加到logger，然后将日志写入到指定的文件中
思路：定义logger对象，设置内容
      定义handler，关联日志文件
      定义日志格式化
      把handler格式化
      处理日志
"""
import logging
#1.定义日志对象
logger = logging.getLogger(__name__)
logger.setLevel(level=logging.INFO)

#2.定义处理日志的对象，写入日志记录
handler = logging.FileHandler("log.txt","w")
handler.setLevel(logging.INFO)

#3.定义日志格式
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')

#4.处理日志的对象格式化
handler.setFormatter(formatter)

#5.处理日志
logger.addHandler(handler)

logger.info("start print log")
logger.debug("do something")
logger.warning("somethindg maybe fail")
logger.info("finish")