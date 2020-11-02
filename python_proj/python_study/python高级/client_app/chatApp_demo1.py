import tkinter as tk
import time

def main():
    #发送消息
    def sendMsg():
        strMsg = '我：' + time.strftime('%Y-%m-%d %H:%M:%S',time.localtime()) + '\n'
        txtMsgList.insert(tk.END,strMsg,'greencolor')    #给组件中插入内容
        txtMsgList.insert(tk.END,txtMsg.get('0.0',tk.END))  #get()  获取消息框组件中的内容
        txtMsg.delete('0.0',tk.END)
    #取消消息，事件是绑定给消息框的
    def cancelMsg():
        txtMsg.delete('0.0',tk.END)   #清除组件全部内容

    #发送消息事件
    def sendMsgEvent(envent):
        if envent.keysym == 'up':
            sendMsg()

    #创建窗口
    app = tk.Tk()
    app.title("与python聊天")

    #布局，页面分为左上msgList，左中为msgTxt，左下，右侧
    #创建frame容易
    frmLT = tk.Frame(width=500,height=320,bg='white')
    frmLC = tk.Frame(width=500,height=150,bg='white')
    frmLB = tk.Frame(width=500,height=30)
    frmRT = tk.Frame(width=200,height=500)

    #创建控件
    txtMsgList = tk.Text(frmLT) #左上的，是消息列表
    txtMsgList.tag_config('greencolor',foreground='#008C00') #创建tag

    txtMsg = tk.Text(frmLC) #左中间的，是消息文本
    txtMsg.bind('<KeyPress-Up>',sendMsgEvent)

    #左下的按钮控件
    btnSend = tk.Button(frmLB,text='发送',width=8,command=sendMsg)
    btnCancel  = tk.Button(frmLB,text='取消',width=8,command=cancelMsg)

    #右侧的图片
    imgInfo = tk.PhotoImage(file='a.gif')
    lblImage = tk.Label(frmRT,image=imgInfo)
    lblImage.image = imgInfo

    #窗口网格布局
    frmLT.grid(row=0,column=0,columnspan=2,padx=1,pady=3)
    frmLC.grid(row=1,column=0,columnspan=2,padx=1,pady=3)
    frmLB.grid(row=2,column=0,columnspan=2)
    frmRT.grid(row=0,column=2,rowspan=3,padx=2,pady=3)

    #固定大小
    frmLT.grid_propagate(0)
    frmLC.grid_propagate(0)
    frmLB.grid_propagate(0)
    frmRT.grid_propagate(0)


    btnSend.grid(row=2,column=0)
    btnCancel.grid(row=2,column=1)
    lblImage.grid()
    txtMsgList.grid()
    txtMsg.grid()
    app.mainloop()

if __name__ == '__main__':
    main()



