import tkinter as tk
root = tk.Tk()
root.title("学习GUI")
logo = tk.PhotoImage('monkey.gif')
content = """At present, only GIF and PPM/PGM
formats are supported, but an interface
exists to allow additional image file
formats to be added easily."""
tk.Label(root,compound='left',text=content,image=logo).pack(side='right')
root.mainloop()