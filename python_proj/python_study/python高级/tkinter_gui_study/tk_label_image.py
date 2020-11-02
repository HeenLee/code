import tkinter as tk
root = tk.Tk()
root.title("image")
logo=tk.PhotoImage(file='monkey.gif')
tk.Label(root,image=logo).pack(side='left')
root.mainloop()