from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, String, Integer
from sqlalchemy.orm import sessionmaker

engine = create_engine("mysql+pymysql://root:root@127.0.0.1/db_python", encoding="utf-8", echo=True, max_overflow=5)
# 连接mysql数据库，echo为是否打印结果

Base = declarative_base()  # 生成orm基类


class User(Base):  # 继承生成的orm基类
    __tablename__ = "sql_test"  # 表名
    id = Column(Integer, primary_key=True)  # 设置主键
    user_name = Column(String(32))
    user_password = Column(String(64))


class Admin(Base):
    __tablename__ = "admin"
    id = Column(Integer, primary_key=True)
    username = Column(String(32))
    password = Column(String(64))

if __name__ == '__main__':

    # Base.metadata.drop_all(engine)  # 创建表结构
    Base.metadata.create_all(engine)  # 创建表结构
    Session_Class = sessionmaker(bind=engine)
    session = Session_Class()
    t1 = Admin(username='test',password='123456')
    t2 = Admin(username='test1',password='adcdef')

    print(t1.username,t1.password)
    print(t2.username,t2.password)

    session.add(t1)
    session.add(t2)
    session.commit()
