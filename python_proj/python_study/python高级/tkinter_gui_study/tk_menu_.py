import tkinter as tk
root = tk.Tk()
root.title('菜单')
root.geometry('400x300+300+100')
menubar = tk.Menu(root)

fmenu1 = tk.Menu(root)
for item in ['新建','打开','保存','另存为']:
    fmenu1.add_command(label=item)

fmenu2 = tk.Menu(root)
for item in ['赋值','粘贴','剪贴']:
    fmenu2.add_command(label=item)

fmenu3 = tk.Menu(root)
for item in ['大纲视图','web视图']:
    fmenu3.add_command(label=item)

fmenu4 = tk.Menu(root)
for item in ['版权信息','其他说明']:
    fmenu4.add_command(label=item)

menubar.add_cascade(label='文件',menu=fmenu1)
menubar.add_cascade(label='编辑',menu=fmenu2)
menubar.add_cascade(label='视图',menu=fmenu3)
menubar.add_cascade(label='关于',menu=fmenu4)

root.config(menu=menubar)
root.mainloop()