import smtplib
from email.mime.text import MIMEText
from email.header import Header

from_addr = 'heng.li@sinosun.com.cn'
password = 'heng*@19890515'

to_addr = 'heng.li@sinosun.com.cn'

smtp_server = 'smtphm.qiye.163.com'

msg = MIMEText('send by python','plain','utf8')

msg['From'] = Header(from_addr)
msg['To'] = Header(to_addr)
msg['Subject'] = Header('python test')

server = smtplib.SMTP_SSL()
server.connect(smtp_server,465)
server.login(from_addr,password)

server.sendmail(from_addr,to_addr,msg.as_string())
server.quit()
