#coding=utf-8
'''
while():
    pass
else:
    pass
在while  else 语句中，条件为false时执行else的语句块


for i in  sequence:
    pass
else:
    pass
在for else语句中，条件为false时执行else语句，例如
for i in range(5):
    print(i)
else:
    print("end")


在for循环中有break语句时，跳出循环，不执行else语句，例如
for i in range(5):
    if i== 4:
        print(i)
        break
    print(i)
else:
    print("没有执行")
print("end")

continue会执行else,例如
for i in range(5):
    if i== 3:
        print(i)
        continue
    print(i)
else:
    print("没有执行")
print("end")

break 语句可以跳出 for 和 while 的循环体。如果你从 for 或 while 循环中终止，任何对应的循环 else 块将不执行。也就是说
循环被 break 终止时不执行

continue 语句被用来告诉 Python 跳过当前循环块中的剩余语句，然后继续进行下一轮循环。
'''

