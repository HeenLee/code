#! _*_coding:utf8 _*_
import unittest
import configparser
import os
import requests
import json
from requestsExerciseCustomerserver.baseclass.addressGet import AddressGet
from requestsExerciseCustomerserver.baseclass.request import Request
from requestsExerciseCustomerserver.baseclass.conf import Config
import requests

class AddressGetTest(unittest.TestCase):
    def test_getAddress(self):
        # 配置文件路径
        conf_path = os.path.dirname(os.getcwd()) + '/conf/conf.ini'
        #创建配置文件对象
        config = Config(conf_path)
        # 从配置文件中获取url
        get_url = config.get_value('address', 'url') + config.get_value('address', 'getpath')
        # 创建获取地址的对象，组装参数
        getAddress = AddressGet()
        getAddress.setCompanyId(config.get_value('address_param', 'companyid'))
        getAddress.setUserId(config.get_value('address_param', 'userid'))
        getAddress.setChannelId(config.get_value('address_param', 'channelid'))
        #将参数转为字典对象
        param = getAddress.get_param()
        print(param)
        # 组装请求首部
        headers = {'Authorization': 'Bearer ' + config.get_value('token', 'access_token')}
        #发送get请求
        # res = requests.get(get_url, params=param, headers=headers)
        request = Request()
        res = request.send_get(get_url,param,headers=headers)


        print(res.content)
        # 获取到请求内容，content是二进制内容，需要解码转为字符串，通过loads()加载为Python的字典对象。text是文本内容
        content = json.loads(res.content.decode('utf8'))
        print(content)
        self.assertEqual(content['resultCode'], 0)

