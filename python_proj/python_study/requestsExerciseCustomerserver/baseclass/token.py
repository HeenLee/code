#!_*_ coding:utf8 _*_
'''
获取token类
'''
from requestsExerciseCustomerserver.baseclass.logger import Logger


class Token():
    grant_type = ''
    client_id = ''
    username = ''
    password = ''
    client_secret = ''

    def __init__(self):
        return None

    # 定义设置获取参数的方法
    def setGrantType(self, grant_type):
        self.grant_type = grant_type

    def setClientId(self, client_id):
        self.client_id = client_id

    def setUsername(self, username):
        self.username = username

    def setPassword(self, password):
        self.password = password

    def setClientSecret(self, client_secret):
        self.client_secret = client_secret

    def getGrantType(self):
        return self.grant_type

    def getClientId(self):
        return self.client_id

    def getUsername(self):
        return self.username

    def getPassword(self):
        return self.password

    def getClientSecret(self):
        return self.client_secret

    # 组装参数
    def get_param(self):
        data = {'grant_type': self.grant_type, 'client_id': self.getClientId(), 'username': self.getUsername(),
                'password': self.getPassword(), 'client_secret': self.getClientSecret()}
        return data
