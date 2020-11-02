import tkinter as tk
def callCheckbutton():
    v.set('变化了，CheckButton')
root = tk.Tk()
root.title("给绑定函数")

v = tk.StringVar()
v.set("check python")
tk.Checkbutton(root,textvariable=v,command=callCheckbutton).pack()

root.mainloop()