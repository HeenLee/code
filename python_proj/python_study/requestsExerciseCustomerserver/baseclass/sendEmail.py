#！ _*_ coding:utf8 _*_
'''
简单的邮件发送
'''
import smtplib
from email.mime.text import MIMEText
from email.header import Header

#发件人的信息
from_addr = 'heng.li@sinosun.com.cn'
password = 'heng*@19890515'

#收件人地址
to_addr = 'heng.li@sinosun.com.cn'
#发信服务器
smtp_server = 'smtphm.qiye.163.com'
#抄送的人员
other = 'xhfhf@hotmail.com'

#发送的内容
msg = MIMEText('send by python','plain','utf8')
#邮件的头部  包含发件人、收件人、抄送人员、邮件主题
msg['From'] = Header(from_addr)
msg['To'] = Header(to_addr)
msg['Cc'] = Header(other)
msg['Subject'] = Header('python test')

#开启发信服务，这里使用加密传输
server = smtplib.SMTP()
server.connect(smtp_server)
#登录发信邮箱
server.login(from_addr,password)
#发送邮件
server.sendmail(from_addr,to_addr,msg.as_string())
#关闭服务器
server.quit()
