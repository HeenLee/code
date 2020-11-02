# _*_coding=utf8 _*_

'''
查询语句
'''
import pymysql

#创建连接
db = pymysql.connect(host="localhost",port=3306,user="root",password="root",database='mysql',charset="utf8")
#获取游标对象
cursor = db.cursor()

#查询返回的是结果。要取结果，
# 需要fetchone()以元组方式返回   取出一个
# fetchall() 取出一个
# fetcmany(n)默认取一个，元组里面套元组。里面带参数是n,取n个
a = cursor.execute("select * from user;")    #返回的是记录个数
# print(cursor.fetchall())
# print(cursor.fetchone())
print(cursor.fetchmany()) # 默认取一个
print(cursor.fetchmany(2)) #指定参数取

print(a)




#关闭

cursor.close() #先关闭游标
db.close()

