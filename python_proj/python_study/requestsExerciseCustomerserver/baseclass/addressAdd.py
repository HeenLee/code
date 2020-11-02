#! _*_coding:utf8 _*_

"""
添加收货地址
"""
class AddressAdd():
    # '''
    # 添加收货地址类
    # '''
    # #类属性变量
    userId = ''
    companyId = ''
    channelId = ''
    area = ''
    address = ''
    phone = ''
    name = ''
    tags = ''
    defaultFlag = ''
    areaCode = ''
    def __init__(self):
        return None

    def setUserId(self,userId):
        self.userId = userId
    def setCompanyId(self,companyId):
        self.companyId = companyId
    def setChannelId(self,channelId):
        self.channelId = channelId
    def setArea(self,area):
        self.area = area
    def setAddress(self,address):
        self.address = address
    def setPhone(self,phone):
        self.phone = phone
    def setName(self,name):
        self.name = name
    def setTags(self,tags):
        self.tags = tags
    def setDefaultFlag(self,defaultFlag):
        self.defaultFlag = defaultFlag
    def setAreaCode(self,areaCode):
        self.areaCode = areaCode\

    def getUserId(self):
        return self.userId
    def getCompanyId(self):
        return self.companyId
    def getChannelId(self):
        return self.channelId
    def getArea(self):
        return self.area
    def getAddress(self):
        return self.address
    def getPhone(self):
        return self.phone
    def getName(self):
        return self.name
    def getTags(self):
        return self.tags
    def getDefaultFlag(self):
        return self.defaultFlag
    def getAreaCode(self):
        return self.areaCode

    def get_param(self):
        data = {'userId':self.userId,'companyId':self.companyId,'channelId':self.channelId,'area':self.area
                ,'address':self.address,'phone':self.phone,'name':self.name,'defaultFlag':self.defaultFlag,'tags':self.tags,'areaCode':self.areaCode}
        return data