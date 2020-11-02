#coding=utf-8
'''在 Python 中，使用了 yield 的函数被称为生成器（generator）
跟普通函数不同的是，生成器是一个返回迭代器的函数，只能用于迭代操作，更简单点理解生成器就是一个迭代器。
在调用生成器运行的过程中，每次遇到 yield 时函数会暂停并保存当前所有的运行信息，返回 yield 的值, 并在下一次执行
 next() 方法时从当前位置继续运行。
调用一个生成器函数，返回的是一个迭代器对象。

生成器与yield：函数中使用yield，会返回一个生成器对象
[i**2 for i in rang(10)]  这个是列表生成式，返回[0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
(i**2 for i in range(10)) 这个是列表生成器 返回<generator object <genexpr> at 0x000000000338CC50>
'''
import  sys
def gen_num(x):
    y = 0
    while y<= x:
        yield y
        y += 1

def gen_num1(n):
    i = 1
    while i <= n:
        yield i**2
        i += 1

f = gen_num(10)
print(f)    #<generator object gen_num at 0x0000000000AB9360>

#使用for迭代
# for i in f:
#     print(i,end=" ")


#使用while迭代
# while True:
#     try:
#         print(next(f))
#     except StopIteration as e:
#         sys.exit()


f1 = gen_num1(20)
for i in f1:
    print(i)