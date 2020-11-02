#! _*_ coding:utf8 _*_
'''
发送HTML附件
'''

import smtplib
from email.header import Header
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.utils import parseaddr,formataddr
import requests

def getHtml(url):
    html = requests.get(url).text
    return html

def sendEmail(content):
    host = 'smtphm.qiye.163.com'
    user = 'heng.li@sinosun.com.cn'
    pwd = 'heng*@19890515'
    receivers = ['heng.li@sinosun.com.cn']

    msg = MIMEMultipart()
    msg['From'] = Header(user)
    msg['To'] = ','.join(receivers)
    msg['Subject'] = Header('发送html邮件-主题')
    msg.attach(MIMEText('正文邮件'+content,'html','utf8'))

    server = smtplib.SMTP()
    server.connect(host)
    server.login(user,pwd)
    server.sendmail(user,receivers,msg.as_string())
    server.quit()

if __name__ == '__main__':
    url = 'https://www.cnblogs.com/foe0/p/11861731.html'
    content = getHtml(url)
    sendEmail(content)

