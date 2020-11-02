#coding=utf-8
import logging
class Log(object):
    def __init__(self,name=__name__,path='mylog.log',level='DEBUG'):
            self.__name = name
            self.__path = path
            self.__level = level
            self.__logger = logging.getLogger(self.__name)
            self.__logger.setLevel(self.__level)
    def __ini_handler(self):
        stream_handler = logging.StreamHandler()
        file_handler = logging.FileHandler(self.__path,encoding='utf-8')
        return stream_handler,file_handler

    def __set_handler(self,stream_handler,file_handler,level='DEBUG'):
        stream_handler.setLevel(level)
        file_handler.setLevel(level)

        self.__logger.addHandler(stream_handler)
        self.__logger.addHandler(file_handler)

    def __set_formatter(self,stream_handler,file_handler):
        formatter = logging.Formatter('%(asctime)s-%(name)s-%(filename)s-[line:%(lineno)d]' 
                                      '-%(levelname)s-[日志信息]: %(message)s',
                                      datefmt='%a, %d %b %Y %H:%M:%S')
        stream_handler.setFormatter(formatter)
        file_handler.setFormatter(formatter)

    def __close_handler(self,stream_handler,file_handler):
        stream_handler.close()
        file_handler.close()

    @property
    def Logger(self):
        stream_handler,file_handler = self.__ini_handler()
        self.__set_handler(stream_handler,file_handler)
        self.__set_formatter(stream_handler,file_handler)
        self.__close_handler(stream_handler,file_handler)
        return self.__logger

if __name__ == "__main__":
    log = Log(__name__,'file.log')
    logger = log.Logger
    logger.debug('i am debug message')
    logger.info('i am info message')
    logger.warning('i am warning message')
    logger.error('i am error message')
    logger.critical('i am critical message')