#coding=utf-8
'''
删除数据
'''
import pymysql
#打开数据库连接
conn = pymysql.connect('localhost','root','root','testdb')

#使用cursor()创建一个游标对象
cursor = conn.cursor()

# 查询
sql = "delete from employee where sex = 'M' "

#异常处理
try:
    cursor.execute(sql)
    #提交到数据库执行
    conn.commit()
except:
    #发生错误回滚
    conn.rollback()

conn.close()