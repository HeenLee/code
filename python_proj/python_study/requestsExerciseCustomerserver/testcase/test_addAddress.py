#! _*_coding:utf8 _*_
'''
添加地址测试
'''
import unittest
import os
import requests
import json
from requestsExerciseCustomerserver.baseclass.addressAdd import AddressAdd
from requestsExerciseCustomerserver.baseclass.addressDelete import AddressDelete
from requestsExerciseCustomerserver.baseclass.request import Request
from requestsExerciseCustomerserver.baseclass.conf import Config
class AddressAddTest(unittest.TestCase):
    def test_addAddress(self):
        # 配置文件路径
        conf_path = os.path.dirname(os.getcwd()) + '/conf/conf.ini'
        # 从配置文件中获取值.之前是直接读取，现在是将其封装到conf.py的Config类中
        # config = configparser.ConfigParser()
        # config.read(conf_path, encoding='utf8')
        # url = config.get('address', 'url') + config.get('address', 'addpath')
        config = Config(conf_path)  # 创建配置文件对象
        url_add = config.get_value('address', 'url') + config.get_value('address', 'addpath')  # 读取配置文件中的值，拼接url
        print('_________' + url_add)
        # 创建添加地址的对象，组装参数
        addressAdd = AddressAdd()
        addressAdd.setUserId(config.get_value('address_param', 'userid'))  # 通过config对象中的get_value()获取值
        addressAdd.setCompanyId((config.get_value('address_param', 'companyid')))
        addressAdd.setChannelId(config.get_value('address_param', 'channelid'))
        addressAdd.setArea('中国陕西')
        addressAdd.setAddress('高新区')
        addressAdd.setAreaCode('0731')
        addressAdd.setDefaultFlag(False)
        addressAdd.setPhone('1515685')
        addressAdd.setName('sino')
        #条用方法，将参数组成字典对象
        param_add = addressAdd.get_param()

        # 组装请求
        headers = {
            'Content_type': 'application/json',
            'Authorization': 'Bearer ' + config.get_value('token', 'access_token')
        }
        #响应
        # res_add = requests.post(url_add, json=param_add, headers=headers)
        request = Request()
        res_add = request.send_post(url_add,json=param_add,headers=headers)
        print(res_add)
        print(res_add.content) #响应的二进制内容，是json字符串。
        #
        id = json.loads(res_add.content.decode('utf8'))['result']['id'] # 将二进制内容解码转为字符串，然后loads()加载为字典对象，取出id
        print(type(id))
        #调用配置文件对象的方法，将取出的id写入到配置文件中
        config.set_value('address_param', 'addressId', str(id))
        # with open(conf_path, 'w') as f:
        #     config.write(f)

        #获取删除收货地址的url
        delete_url = config.get_value('address', 'url') + config.get_value('address', 'deletepath')
        # 创建删除地址的对象，组装参数
        deleteAddress = AddressDelete()
        deleteAddress.setCompanyId(config.get_value('address_param', 'companyid'))
        deleteAddress.setUserId(config.get_value('address_param', 'userid'))
        deleteAddress.setChannelId(config.get_value('address_param', 'channelid'))
        #定义地址列表Ids
        ids = []
        #从配置文件中取出id
        newID = config.get_value('address_param', 'addressid')
        ids.append(newID) #将地址添加到列表中
        deleteAddress.setIds(ids) #将列表赋值
        print(newID)
        print(ids)
        #将删除的参数组成字典对象
        param_delete = deleteAddress.get_param()
        # 发送请求
        # res_delete = requests.post(delete_url, json=param_delete, headers=headers)
        request = Request()
        res_delete = request.send_post(delete_url,json=param_delete,headers=headers)
        content = json.loads(res_delete.content.decode('utf8')) #取出响应的内容

        print(content)
        self.assertEqual(content['resultCode'], 0)


if __name__ == "__main__":
    unittest.main()
