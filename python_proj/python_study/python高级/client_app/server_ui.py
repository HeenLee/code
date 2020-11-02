import tkinter as tk
import socket
import time
import threading
import sys

class ServerUI(object):
    local = '127.0.0.1'
    port = 5505
    global serverSock
    flag = False

    def __init__(self):
        self.root = tk.Tk()
        self.root.title("python 在线聊天-服务器端")

        #窗口面板，四个frame框架布局
        self.frame = [tk.Frame(),tk.Frame(),tk.Frame(),tk.Frame()]

        #显示消息Text右边的滚动条
        self.chatTextScrollBar = tk.Scrollbar(self.frame[0])
        self.chatTextScrollBar.pack(side=tk.RIGHT,fill=tk.Y)

        #显示消息Text,并绑定上面的滚动条
        self.chatText = tk.Text(self.frame[0],width=70,height=18)
        self.chatText['yscrollcommand'] = self.chatTextScrollBar.set
        self.chatText.pack(expand=1,fill=tk.BOTH)
        self.chatTextScrollBar['command'] = self.chatText.yview()
        self.frame[0].pack(expand=1,fill=tk.BOTH)

        #标签，分开消息显示Text和消息输入Text
        self.label = tk.Label(self.frame[1],height=2)
        self.label.pack(fill=tk.BOTH)
        self.frame[1].pack(expand=1,fill=tk.BOTH)

        #输入消息Text的滚动条
        self.inputTextScrollBar = tk.Scrollbar(self.frame[2])
        self.inputTextScrollBar.pack(side=tk.RIGHT,fill=tk.Y)

        #输入消息Text，并绑定滚动条
        self.inputText = tk.Text(self.frame[2],width=70,height=8)
        self.inputText['yscrollcommand'] = self.inputTextScrollBar.set
        self.inputText.pack(expand=1,fill=tk.BOTH)

        self.inputTextScrollBar['command'] = self.inputText.yview()
        self.frame[2].pack(expand=1,fill=tk.BOTH)

        #发送消息按钮
        self.sendButton = tk.Button(self.frame[3],text='发送',width=10,command=self.sendMessage)
        self.sendButton.pack(expand=1,side=tk.BOTTOM and tk.RIGHT,padx=25,pady=5)

        #关闭按钮
        self.closeButton = tk.Button(self.frame[3],text='关闭',width=10,command=self.close)
        self.closeButton.pack(expand=1,side=tk.RIGHT,padx=25,pady=5)
        self.frame[3].pack(expand=1,fill=tk.BOTH)

    #接收消息
    def receiveMessage(self):
        self.serverSock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
        self.serverSock.bind((self.local,self.port))
        self.serverSock.listen(15)

        self.buffer = 1024
        self.chatText.insert(tk.END,'服务器已经准备就绪....')

        #循环接收客户端请求
        while True:
            self.connection,self.address = self.serverSock.accept()
            self.flag = True
            while True:
                self.clientMsg = self.connection.recv(self.buffer).decode('utf8')
                if not self.clientMsg:
                    continue
                elif self.clientMsg == 'Y':
                    self.chatText.insert(tk.END,'服务器与客户端建立连接')
                    self.connection.send('Y'.encode('utf8'))
                elif self.clientMsg == 'N':
                    self.chatText.insert(tk.END,'服务器与客户端建立连接失败...')
                    self.connection.send('N'.encode('utf8'))
                else:
                    theTime = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
                    self.chatText.insert(tk.END,'客户端' + theTime + "说：\n")
                    self.chatText.insert(tk.END,'' + self.clientMsg)

    def sendMessage(self):
        message = self.inputText.get('1.0',tk.END)
        theTime = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
        self.chatText.insert(tk.END,'服务器' + theTime + "说：\n")
        self.chatText.insert(tk.END,"" + message + '\n')
        if self.flag ==True:
            self.connection.send(message.encode('utf8'))
        else:
            self.chatText.insert(tk.END,'您还没有与客户端建立连接，客户端无法收到消息')
        self.inputText.delete(0,0,message.__len__()-1.0)

    def close(self):
        sys.exit()

    def startNewThread(self):
        thread = threading.Thread(target=self.receiveMessage,args=())
        thread.setDaemon(True)
        thread.start()

def main():
    server = ServerUI()
    server.startNewThread()
    server.root.mainloop()

if __name__ == "__main__":
    main()