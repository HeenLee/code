#coding=utf-8

import calendar

import datetime  #日期时间    datetime.timedelta  时间差

t = datetime.date   #类

d = datetime.date(2019,6,20)
print(d.day)
print(datetime.date.ctime(d))

#返回日期
print(datetime.date.today())

timedelta = datetime.timedelta(hours=2)  #添加2小时  使用场景： now + 时间差，就过期
#
now = datetime.datetime.now()
print(now)

print(now + timedelta)
#获取某月日历
cal = calendar.month(2020,1)
print(cal)

