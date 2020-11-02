#coding=utf-8
'''
查询数据库
'''
import pymysql
#打开数据库连接
conn = pymysql.connect('localhost','root','root','testdb')

#使用cursor()创建一个游标对象
cursor = conn.cursor()

# 查询
sql = "select * from employee where income > 1000"

#异常处理
try:
    cursor.execute(sql)
    #获取所有的记录列表
    results = cursor.fetchall()
    for row in results:
        print(row)
        first_name = row[0]
        last_name = row[1]
        age = row[2]
        sex = row[3]
        income = row[4]
        print(first_name,last_name,age,sex,income)
except:
    #如果发生错误
    print('unable to fetch data!')

conn.close()