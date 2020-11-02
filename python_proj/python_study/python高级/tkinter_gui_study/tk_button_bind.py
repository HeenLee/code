import tkinter as tk
import math
def printInfo():
    #output输入框清楚内容
    entry2.delete(0,tk.END)
    #获取到input输入的值
    input_value = int(entry1.get())
    #计算值
    s = math.pi * input_value ** 2
    #把计算的值插入到output中
    entry2.insert(1,s)
    #执行完后清除input框的值
    entry1.delete(0,tk.END)

#设置主窗口
root = tk.Tk()
root.title("学习GUI")

#添加两个文本标签  0行0列  1行0列
tk.Label(root,text='input').grid(row=0)
tk.Label(root,text='output').grid(row=1)

#添加两个文本输入框
entry1 = tk.Entry(root)
entry2 = tk.Entry(root)
entry1.grid(row=0,column=1)
entry2.grid(row=1,column=1)

#添加两个按钮 quit退出  run计算
tk.Button(root,text='Quit',command=root.quit).grid(row=2,column=0,sticky='W',padx=5,pady=5)
tk.Button(root,text='Run',command=printInfo).grid(row=2,column=1,sticky='W',padx=5,pady=5)
root.mainloop()