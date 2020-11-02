import tkinter as tk
root = tk.Tk()
root.title("按钮学习")
b1 = tk.Button(root,text='button1',bg='red',relief='raised',width=8,height=2)
b1.grid(row=0,column=0,sticky='W',padx=5,pady=5)
b2 = tk.Button(root,text='button2',font=('Helvetica 10 bold'),width=8, height=2)
b2.grid(row=0,column=1,sticky="W",padx=5,pady=5)
root.mainloop()