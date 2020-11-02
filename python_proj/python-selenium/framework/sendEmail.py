from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
import os,sys
import smtplib
import time
import logging

logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)
handler = logging.StreamHandler()
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
handler.setLevel(logging.DEBUG)
handler.setFormatter(formatter)
logger.addHandler(handler)

strftime = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))

reportpath = os.path.dirname(os.path.dirname(os.path.abspath('.'))) + '/reports/'
logger.debug(reportpath)

class SendEmail(object):
    def get_report(self):
        dirs = os.listdir(reportpath)
        dirs.sort()
        newreportname = dirs[-1]
        print('the new report name:{0}'.format(newreportname))
        return newreportname
    def take_message(self):
        newreport = self.get_report()
        self.msg = MIMEMultipart()
        self.msg['Subject'] = "BBA JIT自动化测试报告"
        self.msg['data'] = time.strftime('%a,%d %b %Y %H:%M:%S %z')
        with open(os.path.join(reportpath,newreport),'rb') as f:
            mainbody = f.read()
        html = MIMEText(mainbody,_subtype='html',_charset='utf8')
        self.msg.attach(html)

        att1 = MIMEText(mainbody,'base64','utf8')
        att1['content-type'] = 'application/octet-stream'
        att1['content-Disposition'] = 'attachment;filename="testreport.html"'
        self.msg.attach(att1)

    def send(self):
        recipients = ['heng.li@sinosun.com.cn']
        self.take_message()
        self.msg['from'] = 'heng.li@sinosun.com.cn'
        toaddrs = recipients

        smtp = smtplib.SMTP()
        smtp.connect('smtp.mxhichina.com')
        smtp.ehlo()
        smtp.login("heng.li@sinosun.com.cn",'Lh123456')
        smtp.sendmail(self.msg['from'],toaddrs,self.msg.as_string())

if __name__ == '__main__':
    sendMail = SendEmail()
    sendMail.send()