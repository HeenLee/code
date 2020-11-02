#! _*_coding:utf8 _*_
"""
发送请求的类
"""
import requests
from  requestsExerciseCustomerserver.baseclass.logger import Logger
logger = Logger().getLog()
class Request():
    def __init__(self):
        return None

    def send_post(self,url, data=None,json=None, **kwargs):
        logger.info("url: %s, data:%s, json:%s, other:%s" % (url,data,json,kwargs ))
        response = requests.post(url, data,json, **kwargs)
        return response


    def send_get(self, url,param, **kwargs):
        logger.info("url: %s, param:%s, other:%s" % (url, param, kwargs))
        response = requests.get(url, param, **kwargs)
        logger.info("response: %s" % response)
        return  response
