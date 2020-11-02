#! _*_ coding:utf8 _*_
'''
发送图片附件
'''
import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.header import Header
from email.mime.image import MIMEImage
from email.utils import parseaddr,formataddr
def sendEmail(body,image):
    host = 'smtphm.qiye.163.com'
    user = 'heng.li@sinosun.com.cn'
    pwd = 'heng*@19890515'
    receivers = ['heng.li@sinosun.com.cn']

    msg =  MIMEMultipart()
    msg['From'] = Header(user)
    msg['To'] = ','.join(receivers)
    msg['Subject'] = Header('图片-主题')
    msg.attach(MIMEText(body,'html','utf8'))

    with open(image,'rb') as f:
        pic = MIMEImage(f.read())
    pic.add_header('Content-ID','<image1>')
    msg.attach(pic)

    server  = smtplib.SMTP()
    server.connect(host)
    server.login(user,pwd)
    server.sendmail(user,receivers,msg.as_string())
    server.quit()

if __name__ == '__main__':
    body = '''
       <html><body>
       <center>下边是一张图片</center>
       <img src="cid:image1" alt="image1" align="center" width=100% >
       <center>上边是一张图片</center>
       </body></html>
       '''
    sendEmail(body,'image.jpg')

