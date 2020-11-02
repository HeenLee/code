import tkinter as tk
#初始化Tk()
root=tk.Tk()
root.title('Python GUI Learning')
v=tk.IntVar()  #选中选项的值  默认从0开始
#列表中存储的是元素是元组
language=[('python',0),('C++',1),('C',2),('Java',3)]
#定义单选按钮的响应函数
def callRB():
    for i in range(4):
        if (v.get()==i):
            root1 = tk.Tk()
            tk.Label(root1,text='你的选择是'+language[i][0]+'!',fg='red',width=20, height=6).pack()
            tk.Button(root1,text='确定',width=3,height=1,command=root1.destroy).pack(side='bottom')
tk.Label(root,text='选择一门你喜欢的编程语言').pack(anchor=tk.W)
#for循环创建单选框
for lan,num in language:
    tk.Radiobutton(root, text=lan, value=num, command=callRB, variable=v).pack(anchor=tk.W)
#进入消息循环
root.mainloop()