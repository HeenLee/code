import tkinter as tk
import socket
import time
import threading
import sys
class ClientUI(object):
    #定义类属性
    title = 'python在线聊天-客户端'
    local = '127.0.0.1'
    port = 5505
    global clientSock
    flag = False

    #构造方法
    def __init__(self):
        self.root = tk.Tk()
        self.root.title(self.title)

        #窗口面板，用四个布局
        self.frame = [tk.Frame(),tk.Frame(),tk.Frame(),tk.Frame()]

        #显示消息Text右边的滚动条
        self.chatTextScrollBar = tk.Scrollbar(self.frame[0])
        self.chatTextScrollBar.pack(side=tk.RIGHT,fill=tk.Y)

        #显示消息Text,并绑定上面的滚动条
        self.chatText = tk.Listbox(self.frame[0],width=70,height=18)
        self.chatText['yscrollcommand'] = self.chatTextScrollBar.set
        self.chatText.pack(expand=1,fill=tk.BOTH)

        self.chatTextScrollBar['command'] = self.chatText.yview()
        self.frame[0].pack(expand=1,fill=tk.BOTH)

        #标签 分开消息显示Text和消息输入Text
        label = tk.Label(self.frame[1],height=2)
        label.pack(fill=tk.BOTH)
        self.frame[1].pack(expand=1,fill=tk.BOTH)

        #输入消息Text的滚动条
        self.inputTextScroolBar = tk.Scrollbar(self.frame[2])
        self.inputTextScroolBar.pack(side=tk.RIGHT,fill=tk.Y)

        #输入消息Text,并与滚动条绑定
        self.inputText = tk.Text(self.frame[2],width=70,height=8)
        self.inputText['yscrollcommand'] = self.inputTextScroolBar.set
        self.inputText.pack(expand=1,fill=tk.BOTH)
        self.inputTextScroolBar['command'] = self.inputText.yview()
        self.frame[2].pack(expand=1,fill=tk.BOTH)

        #发送消息按钮
        self.sendButton = tk.Button(self.frame[3],text='发送',width=10,command=self.sendMessage)
        self.sendButton.pack(expand=1,side=tk.BOTTOM and tk.RIGHT,padx=15,pady=8)

        #关闭按钮
        self.closeButton = tk.Button(self.frame[3],text='关闭',width=10,command=self.close)
        self.closeButton.pack(expand=1,side=tk.RIGHT,padx=15,pady=8)
        self.frame[3].pack(expand=1,fill=tk.BOTH)

    #接收消息
    def receiveMessage(self):
        #建立socket连接
        try:
            self.clientSock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
            self.clientSock.connect((self.local,self.port))
            self.flag = True
        except:
            self.flag = False
            self.chatText.insert(tk.END,'您还未与服务器端建立连接，请检查服务器端是否已经启动')
            return
        self.buffer = 1024
        self.clientSock.send('Y'.encode('utf8'))
        while True:
            try:
                if self.flag == True:
                    #建立连接，接收服务器消息
                    self.serverMsg = self.clientSock.recv(self.buffer).decode('utf8')
                    if self.serverMsg == 'Y':
                        self.chatText.insert(tk.END,'客户端已经与服务器端建立连接...')
                    elif self.serverMsg == 'N':
                        self.chatText.insert(tk.END,'客户端与服务器端连接失败')
                    elif not self.serverMsg:
                        continue
                    else:
                        theTime = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
                        self.chatText.insert(tk.END,'服务器端' + theTime + "说：\n")
                        self.chatText.insert(tk.END," " + self.serverMsg)
                else:
                    break
            except EOFError as  msg:
                raise msg
                self.clientSock.close()
                break

    #发送消息
    def sendMessage(self):
        #得到用户在Text中输入的消息
        message = self.inputText.get("1.0",tk.END)
        #格式化当前时间
        theTime = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime())

        self.chatText.insert(tk.END,'客户端'+ theTime + "说：\n")
        self.chatText.insert(tk.END,"" + message + '\n')
        if self.flag == True:
            self.clientSock.send(message.encode('utf8'))
        else:
            #socket连接没有建立，提示用户
            self.chatText.insert(tk.END,'您还未与服务器建立连接，服务器端无法收到你发送的消息\n')
            #清空用户在Text中输入的消息
            self.inputText.delete(0.0,tk.END)

    def close(self):
        sys.exit()


    #启动线程接收服务器端的消息
    def startNewThread(self):
        #启动一个新线程接收服务器消息
        thread= threading.Thread(target=self.receiveMessage,args=())
        thread.setDaemon(True)
        thread.start()

def main():
    client = ClientUI()
    client.startNewThread()
    client.root.mainloop()

if __name__ == "__main__":
    main()



