
'''
�����ļ���С�ع���־�͸���ʱ��ع���־
'''
import logging
import os
from logging.handlers import RotatingFileHandler


logger = logging.getLogger(__name__)

log_path = os.getcwd() + '/'
rh = RotatingFileHandler()