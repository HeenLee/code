# _*_ coding=utf8 _*_
import time

t_time = time.time()  #返回float类型的秒  时间戳    1603948605.1716578
# time.sleep(3)   #休眠

#将时间戳转成字符串
t_ctime = time.ctime(t_time)   #Thu Oct 29 13:21:21 2020

#将时间戳转成元组
t_localtime = time.localtime(t_time)   #返回年月日 时分秒 星期 等tm_year=2020, tm_mon=10, tm_mday=29, tm_hour=13, tm_min=16, tm_sec=45, tm_wday=3, tm_yday=303, tm_isdst=0
print(t_localtime.tm_yday)
print(t_localtime.tm_hour)

#将元组时间转成时间戳
t = time.mktime(t_localtime)

#将元组转成字符串
format_time = time.strftime("%Y-%m-%d %H:%M:%S",time.localtime())

#将字符串转成元组格式
r = time.strptime('2020/10/29','%Y/%m/%d')


print(t_time)
print(t_ctime)
print(t_localtime)
print(t)
print(format_time)
print(r)