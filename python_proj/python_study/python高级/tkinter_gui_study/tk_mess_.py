import tkinter as tk
root = tk.Tk()

mes = 'Only those who have the patience to do simple things per'
msg = tk.Message(root,text=mes)
msg.config(bg='lightgreen',font=('times',20,'italic'))
msg.pack()
root.mainloop()