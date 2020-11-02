#!_*_ coding:utf8 _*_
'''
发送Excel格式附件
'''

import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.header import Header
from email import encoders
from email.mime.base import MIMEBase

host = 'smtphm.qiye.163.com'
user = 'heng.li@sinosun.com.cn'
pwd = 'heng*@19890515'
receivers = ['heng.li@sinosun.com.cn']

msg = MIMEMultipart()
msg['From'] = Header(user)
msg['To'] = ','.join(receivers)
msg['Cc'] = Header('1044984214@qq.com')
msg['Subject'] = Header('邮件发送-主题').encode()
msg.attach(MIMEText('邮件正文','plain','utf8'))

part = MIMEBase('application','octet-stream')
part.set_payload(open('abc.xls','rb').read())

encoders.encode_base64(part)
part.add_header('Content-Disposition','attachment',filename='abc.xls')
msg.attach(part)

server = smtplib.SMTP()
server.connect(host)
server.login(user,pwd)
server.sendmail(user,receivers,msg.as_string())
server.quit()
