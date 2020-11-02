'''
chVarDis = IntVar()  如果勾选了，chVarDis.get()返回1  否则是0
'''
import tkinter as tk
root = tk.Tk()
root.title("学习复选框")

chVarDis = tk.IntVar()
print(chVarDis.get())
check1 = tk.Checkbutton(root,text='Disabled',variable=chVarDis,state='disabled')
check1.select()
check1.grid(row=0,column=0,sticky=tk.W)

chvarUn = tk.IntVar()
print(chvarUn.get())
check2 = tk.Checkbutton(root,text='Unchceked',variable=chvarUn)
check2.deselect()
check2.grid(row=0,column=1,sticky=tk.W)

chvarEn = tk.IntVar()

check3= tk.Checkbutton(root,text='Enabled',variable=chvarEn)
check3.select()
print(chvarEn.get())
check3.grid(row=0,column=2,sticky=tk.W)

root.mainloop()