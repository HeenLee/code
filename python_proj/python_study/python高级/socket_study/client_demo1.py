'''
客户端
1.建立连接 conncet
2.发送或者接收数据  注意：发送的是二进制数据，需要转为utf8编码
                data.encode('utf8)   data.decode('utf8')
'''
import socket
address = ('127.0.0.1',5501)
s= socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.connect(address)
while True:
    data = input("请输入数据")
    s.send(data.encode('utf8'))
    server_data = s.recv(1024)
    print(server_data.decode('utf8'))
    if data == 'q':
        break
s.close()
