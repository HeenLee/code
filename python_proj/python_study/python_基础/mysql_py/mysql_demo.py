# _*_coding=utf8 _*_
import pymysql
'''
实现创建表
表中插入数据
表中删除数据
表中修改数据
表中查询数据
增删改的操作之后，需要用db 进行commit 后才会生效。commit之前可以撤销，rollback
'''
class PyMysql(object):
    def __init__(self):
        self.db = pymysql.connect(host="localhost", port=3306, user="root", password="root", database='student', charset="utf8")
        self.cursor = self.db.cursor()

    def __delete__(self):
        self.cursor.close()
        self.db.close()

    def insert_sql(self):
        """向表中添加数据"""
        sql = "insert into st values (0,'小王')"
        self.cursor.execute(sql)

    def delete_sql(self):
        """删除表中数据"""
        sql = "delete from st where id = 1"
        self.cursor.execute(sql)

    def update_sql(self):
        """修改表中数据"""
        sql = "update st set name='小美' where id=2"
        self.cursor.execute(sql)

    def select_sql(self):
        """查询表中数据"""
        sql = "select * from st"
        self.cursor.execute(sql)

    def commit(self):
        self.db.commit()

def main():
    #创建对象
    pysql = PyMysql()
    pysql.insert_sql()
    # 创建连接
    pysql.commit()

if __name__ == '__main__':
    main()


