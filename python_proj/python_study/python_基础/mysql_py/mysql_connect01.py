# _*_coding=utf8 _*_
import pymysql
'''
创建表
'''
db = pymysql.connect("localhost","root","3306","sino")
cursor = db.cursor()
# cursor.execute("select version()")
cursor.execute("drop table if exists employee")
sql = """
        create table employee (
        first_name char(20) not null,
        last_name char(20),
        age int,
        sex char(1),
        income float 
        )
    """

cursor.execute(sql)
# print(data)
db.close()
