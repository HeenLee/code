import time
class GetTime(object):
    def get_system_time(self):
        print(time.time())  #获取从1970年到现在的时间间隔，单位秒
        print(time.localtime())
        new_time = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime()) #格式化时间，按照2019-12-13格式打印
        print(new_time)

gettime = GetTime()
gettime.get_system_time()