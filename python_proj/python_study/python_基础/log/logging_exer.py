
'''
根据文件大小回滚日志和根据时间回滚日志
'''
import logging
import os
from logging.handlers import RotatingFileHandler


logger = logging.getLogger(__name__)

log_path = os.getcwd() + '/'
rh = RotatingFileHandler()