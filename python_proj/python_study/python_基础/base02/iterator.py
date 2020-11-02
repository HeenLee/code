#coding=utf-8
'''
迭代是Python最强大的功能之一，是访问集合元素的一种方式。
迭代器是一个可以记住遍历的位置的对象。
迭代器对象从集合的第一个元素开始访问，直到所有的元素被访问完结束。迭代器只能往前不会后退。
迭代器有两个基本的方法：iter() 和 next()。
字符串，列表或元组对象都可用于创建迭代器：
'''
list = [1,2,3]
it = iter(list)  #通过iter()创建迭代器。list是可迭代对象
print(next(it))
print(next(it))
print(next(it))
print(next(it))
print(next())



