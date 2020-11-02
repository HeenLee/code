#coding=utf-8
'''
插入数据
'''
import pymysql
#打开数据库连接
conn = pymysql.connect('localhost','root','root','testdb')

#使用cursor()创建一个游标对象
cursor = conn.cursor()

# 插入数据
sql = """INSERT INTO employee 
        (FIRST_NAME,LAST_NAME,AGE,SEX,INCOME) VALUES ('Mac','Mohan',20,'M',2000)
    """

#异常处理
try:
    cursor.execute(sql)
    #提交事务到数据路执行
    conn.commit()
except:
    #如果发生错误则执行回滚操作
    conn.rollback()

conn.close()