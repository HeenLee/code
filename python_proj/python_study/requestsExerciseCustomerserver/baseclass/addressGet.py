class AddressGet():
    userId = ''
    companyId = ''
    channelId = ''
    def __init__(self):
        return  None

    def setUserId(self, userId):
        self.userId = userId

    def setCompanyId(self, companyId):
        self.companyId = companyId

    def setChannelId(self, channelId):
        self.channelId = channelId

    def getUserId(self):
        return self.userId

    def getCompanyId(self):
        return self.companyId

    def getChannelId(self):
        return self.channelId

    def get_param(self):
        data = {'userId':self.userId,'companyId':self.companyId,'channelId':self.channelId}
        return data
