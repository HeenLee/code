#！_*_ coding:utf8 _*_
'''
发送简单的文本附件
'''
import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.header import Header

host = 'smtphm.qiye.163.com'
user = 'heng.li@sinosun.com.cn'
pwd = 'heng*@19890515'
receivers = ['heng.li@sinosun.com.cn']

def sendEmain():
    msg = MIMEMultipart()
    msg['From'] = Header(user)
    msg['To'] = ','.join(receivers)
    a = msg['To']
    print(a)
    print(type(a))
    msg['Subject'] = Header('邮件发送-主题')
    msg['Cc'] = Header('1044984214@qq.com')

    msg.attach(MIMEText('正文：python邮件发送','plain','utf8'))

    att1 = MIMEText(open('hello.txt','rb').read(),_subtype='base64',_charset='utf8')
    att1['Content-Type'] = 'text/plain'
    att1['Content-Disposition'] = 'attachment;filename="hello.txt"'
    msg.attach(att1)

    server = smtplib.SMTP()
    server.connect(host)
    server.login(user,pwd)
    server.sendmail(user,receivers,msg.as_string())

    server.quit()

if __name__ == '__main__':
    sendEmain()
