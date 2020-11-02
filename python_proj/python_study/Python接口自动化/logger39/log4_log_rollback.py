"""
日志回滚
其实意思就是log会写在一个文件，这个文件定义成1K大小，日志太多写不下的话，它会自动备份成log.txt.1,log.txt.2 ......，
然后再创建一个log.txt开始写log。使用RotatingFileHandler，可以实现日志回滚：
"""
import logging
from logging.handlers import RotatingFileHandler
logger = logging.getLogger(__name__)
logger.setLevel(level=logging.INFO)

#定义一个RotatingFileHandler,最多备份3个日志文件，每个日志文件最大1K
rh = RotatingFileHandler('log.txt',maxBytes= 1024,backupCount=3)
rh.setLevel(logging.INFO)

formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
rh.setFormatter(formatter)

console = logging.StreamHandler()
console.setLevel(logging.INFO)
console.setFormatter(formatter)

logger.addHandler(rh)
logger.addHandler(console)

logger.info("Start print log")
logger.debug("do something")
logger.warning("somethindg maybe fail")
logger.info("finish")