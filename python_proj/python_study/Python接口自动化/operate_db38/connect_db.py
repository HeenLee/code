#coding=utf-8
'''
连接数据库  1.先创建connect对象连接数据库，2.创建cursor执行查询和获取结果
'''
import pymysql

#打开数据库连接
conn = pymysql.connect(host='127.0.0.1',port=3306,user='root',password='root',db='testdb',charset='utf8')
#使用cursor()创建一个游标对象
cursor = conn.cursor()

#使用execute()执行查询
cursor.execute('select version()')

#使用fetchone()获取单条数据
data = cursor.fetchone()

print('database version :%s' %data)
print(conn)
print(cursor)
cursor.close()
conn.close()