#coding=utf-8
'''
创建数据库表
'''
import pymysql
#打开数据库连接
conn = pymysql.connect('localhost','root','root','testdb')

#使用cursor()创建一个游标对象
cursor = conn.cursor()

#使用execute()执行SQL,如果存在将其删除
cursor.execute('drop table if exists  employee')

# 使用预处理语句创建表
sql = """CREATE TABLE `employee` (
   `first_name` varchar(255) DEFAULT NULL COMMENT '姓',
   `last_name` varchar(255) DEFAULT NULL COMMENT '名',
   `age` int(11) DEFAULT NULL COMMENT '年龄',
   `sex` varchar(255) DEFAULT NULL COMMENT '性别',
   `income` varchar(255) DEFAULT NULL COMMENT '收入'
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 """

cursor.execute(sql)
conn.close()