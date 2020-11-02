#! _*_coding:utf8 _*_
"""
删除收货地址
"""

class AddressDelete():
    '''
    删除地址类
    '''
    userId = ''
    companyId = ''
    channelId = ''
    ids = []
    def __init__(self):
        return None
    def setUserId(self,userId):
        self.userId = userId
    def setCompanyId(self,companyId):
        self.companyId = companyId
    def setChannelId(self,channelId):
        self.channelId = channelId
    # lst=[]
    def setIds(self,ids):
        self.ids = ids

    def getUserId(self):
        return self.userId

    def getCompanyId(self):
        return self.companyId

    def getChannelId(self):
        return self.channelId

    def getIds(self):
        return self.ids

    def get_param(self):
        data = {'userId':self.userId,'companyId':self.companyId,'channelId':self.channelId,'ids':self.ids}
        return data