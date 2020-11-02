'''
服务端
1.绑定地址
2.开始监听
3.接收客户端连接
4.接收客户端数据，并且发送数据。  注意：发送的是二进制数据，需要转为utf8编码
                data.encode('utf8)   data.decode('utf8')
5.
'''
import socket
address = ('127.0.0.1',5501)
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind(address)

s.listen()
print('开始监听')

while True:
    #外层循环是服务器不断接口客户端连接
    conn, addr = s.accept()
    print('客户端上线')
    print('开始接收数据。。。。')
    #内层循环是等外部连接好后，然后客户端和服务器不停的接收和发送消息
    while True:
        data = conn.recv(1024)   #
        client_data = data.decode('utf8')
        data1 = conn.send('server is ok'.encode('utf8'))
        print("recv...",client_data)
        if client_data == 'q':
            print('客户机下线')
            break
s.close()
