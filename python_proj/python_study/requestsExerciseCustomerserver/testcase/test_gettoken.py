#! _*_coding:utf8 _*_

import unittest
import os
import json
from requestsExerciseCustomerserver.baseclass.token import Token
from requestsExerciseCustomerserver.baseclass.conf import Config
from requestsExerciseCustomerserver.baseclass.request import Request


class TestGetToken(unittest.TestCase):

    def test_getToken(self):
        #配置文件路径
        conf_path = os.path.dirname(os.getcwd()) + '/conf/conf.ini'
        # config = configparser.ConfigParser()   之前的直接读取的，现在将该部分写到conf.py中封装起来
        # config.read(conf_path,encoding='utf8')
        # url = config.get('address','url') + config.get('token','path')
        # 创建配置文件对象
        config = Config(conf_path)
        # 从配置文件中获取token的url
        url = config.get_value('address', 'url') + config.get_value('token', 'path')
        print(url)
        # 创建token对象，设置token参数
        token = Token()
        token.setGrantType(config.get_value('token', 'grant_type'))
        token.setClientId(config.get_value('token', 'client_id'))
        token.setClientSecret(config.get_value('token', 'client_secret'))
        token.setUsername(config.get_value('token', 'username'))
        token.setPassword(config.get_value('token', 'password'))
        # 将参数组合成字典对象
        data = token.get_param()
        print(type(data))
        # 发送请求
        # response = requests.post(url, data=data)  #之前是直接导入requests库发送请求，现在将请求封装在request.py中
        #创建请求
        request = Request()
        #发送请求
        response = request.send_post(url,data=data)
        print(response)  # 打印的是response对象<Response [200]>
        print(response.content)  # 打印二进制内容

        # 获取到token的值
        token_value = json.loads(response.content.decode('utf8'))['access_token']
        print(type(token_value))
        # 将token值保存在配置文件中
        config.set_value('token', 'access_token', token_value)  # 该方法是设置属性和值到配置文件，并写入
        # with open(conf_path,'w') as f:
        #     config.write(f)      #写入值到配置文件
        print(response.text)


if __name__ == "__main__":
    unittest.main()
