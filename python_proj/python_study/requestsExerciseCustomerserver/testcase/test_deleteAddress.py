#! _*_coding:utf8 _*_
import unittest
import os
import json
from requestsExerciseCustomerserver.baseclass.addressDelete import AddressDelete
from requestsExerciseCustomerserver.baseclass.request import Request
from requestsExerciseCustomerserver.baseclass.conf import Config

class AddressDeleteTest(unittest.TestCase):
    def test_deleteAddress(self):
        # 配置文件路径
        conf_path = os.path.dirname(os.getcwd()) + '/conf/conf.ini'
        #创建配置文件对象
        config = Config(conf_path)
        # 从配置文件中获取url
        url = config.get_value('address', 'url') + config.get_value('address', 'deletepath')
        #创建删除地址的对象，组装参数
        deleteAddress = AddressDelete()
        deleteAddress.setCompanyId(config.get_value('address_param', 'companyid'))
        deleteAddress.setUserId(config.get_value('address_param', 'userid'))
        deleteAddress.setChannelId(config.get_value('address_param', 'channelid'))
        #收货地址Id列表
        ids = []
        #从配置文件中获取到地址Id
        newID = config.get_value('address_param','addressId')
        ids.append(newID) #将获取的id添加到列表中
        #给列表赋值
        deleteAddress.setIds(ids)
        print(newID)
        print(ids)
        #将参数组为字典对象
        param = deleteAddress.get_param()
        #组装请求首部
        headers = {'Authorization': 'Bearer ' + config.get_value('token', 'access_token'),
                   'Content-Type': 'application/json'
                   }
        #发送请求
        request = Request()
        res = request.send_post(url, json=param, headers=headers)
        # 获取到请求内容，content是二进制内容，需要解码转为字符串，通过loads()加载为Python的字典对象。text是文本内容
        content = json.loads(res.content.decode('utf8'))

        print(content)
        self.assertEqual(content['resultCode'],0)

