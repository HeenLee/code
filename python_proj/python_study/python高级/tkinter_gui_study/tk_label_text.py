'''
标签展示文本
'''
import tkinter as tk
root = tk.Tk()
root.title('demo')
# photo = tk.PhotoImage('monkey.gif')
tk.Label(root,text='username',bg='red',font=('Arial,20,bold'),width=20,height=5,anchor='center').pack()
tk.Label(root,text='pwd',bg='green',width=20,height=5).pack()
root.mainloop()
