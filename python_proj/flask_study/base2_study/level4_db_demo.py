from flask import Flask
from flask_sqlalchemy import  SQLAlchemy
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
#该脚本只能在dos执行 python level4_db_demo.py  后续查找原因
"""
在Flask-SQLAlchemy中，插入、修改、删除操作，均由数据库会话管理。会话用db.session表示。在准备把数据写入数据库前，
要先将数据添加到会话中然后调用commit()方法提交会话。
"""
app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root:sinosun@127.0.0.1:3306/db_python'   #设置连接数据路的url
app.config['SQLALCHEMY_COMMIT_ON_TEARDOWN'] = True     # 设置每次请求结束后自动提交数据库中的改动
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = True
app.config['SQLALCHEMY_ECHO'] = True    #查询时会显示原始SQL语句

# engine = create_engine('mysql+pymysql://root:sinosun@127.0.0.1:3306/db_python',encoding='utf8',echo=True,max_overflow=5)
# Base = declarative_base()

db = SQLAlchemy(app)

'''
class Config(object):
    """配置参数"""
    #sqlalchemy配置参数
    SQLALCHEMY_DATABASE_URI = 'mysql://root:sinosun@127.0.0.1:3306/db_python'
   # 设置sqlalchemy自动跟踪数据库
    SQLALCHEMY_TRACK_MODIFICATIONS = True
app.config.from_object(Config)
# 创建数据库工具对象
db = SQLAlchemy(app)
'''
#表名的常见规范
# ihome -> ih_user   数据库名缩写_表名
# tbl_user  tbl_表名


#创建数据库模型类
class Role(db.Model):
    """用户角色表"""
    #定义表名
    __tablename__ = 'tbl_roles'
    #定义列对象
    id = db.Column(db.Integer,primary_key=True)
    name = db.Column(db.String(64),unique=True)
    users = db.relationship('User',backref='role')

    def __repr__(self):
        return 'Role:%s' % self.name

class User(db.Model):
    """用户表"""
    __tablename__ = 'tbl_users'  #指明数据库的表名
    id = db.Column(db.Integer,primary_key=True)   #整型的主键会默认设置为自增主键
    name = db.Column(db.String(64),unique=True,index=True)
    email = db.Column(db.String(128),unique=True)
    pwd = db.Column(db.String(128))
    role_id = db.Column(db.Integer,db.ForeignKey('tbl_roles.id'))

    def __repr__(self):
        return 'User:%s' % self.name

if __name__ == '__main__':
    db.drop_all()  #删除表
    db.create_all() #创建表

    ro1 = Role(name='Admin')   #创建角色对象1
    ro2 = Role(name='user')
    db.session.add(ro1)  #添加角色
    db.session.add(ro2)  #添加角色
    db.session.commit()

    #添加多条记录
    us1 =User(name='wang',email='wang@163.com',pwd='123456',role_id=ro1.id)
    us2 = User(name='zhang',email='zhang@189.com',pwd='201512',role_id=ro2.id)
    us3 = User(name='chen',email='chen@126.com',pwd='987654',role_id=ro2.id)
    us4 = User(name='zhou',email='zhou@163.com',pwd='456789',role_id=ro1.id)
    db.session.add(us1)
    db.session.add(us2)
    db.session.add(us3)
    db.session.add(us4)
    db.session.commit()      # db.session.add_all([]) 一次性添加

    # 查询：filter_by 精确查询
    User.query.filter_by(name='wang').all()  #返回名字等于wang的所有人
    User.query.first()  #返回查询到的第一个对象
    User.query.all()  # 返回查找到的所有对象
    #filter模糊查找
    User.query.filter(User.name.endswith('g')).all()  #返回名字结尾字符为g的所有数据
    #get() 参数为主键，如果主键不存在没有返回内容
    User.query.get("name")

    User.query.filter(User.name!='wang').all()    #逻辑非，返回名字不等于wang的所有数据

    from sqlalchemy import and_,or_,not_
    User.query.filter(and_(User.name!='wang',User.email.endswith('163.com'))).all() #逻辑与，需要导入and_
    User.query.filter(or_(User.name!='wang',User.email.endswith('163.com'))).all() #逻辑或，需要导入and_
    User.query.filter(not_(User.name=='chen')).all()

    #查找数据后删除
    user = User.query.first()
    db.session.delete(user)
    db.session.commit()
    User.query.all()

    #更新数据
    user = User.query.first()
    user.name = 'dong'
    db.session.commit()
    User.query.first()
    #使用update
    User.query.filter_by(name='zhang').update({'name':'li'})


    """
    关联查询示例：角色和用户的关系是一对多的关系，一个角色可以有多个用户，一个用户只能属于一个角色。
    """
    #查询角色的所有用户
    # 查询roles表id为1的角色
    ro1 = Role.query.get(1)
    # 查询该角色的所有用户
    ro1.us


    #查询用户所属角色
    # 查询users表id为3的用户
    us1 = User.query.get(3)
    # 查询用户属于什么角色
    us1.role

    app.run()




'''
当然你也可以按照模块分类将数据库模型写在一个models.py文件里，但是注意这时候需要先创建db,然后再导入数据表，
例如
config.py:
SQLALCHEMY_DATABASE_URI = 'mysql+pymysql://root:123456@localhost/web'
SQLALCHEMY_COMMIT_ON_TEARDOWN =True
SQLALCHEMY_TRACK_MODIFICATIONS = True

__init__.py:
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
app = Flask(__name__)
app.config.from_object('blog2.config')
db = SQLAlchemy(app)

from blog2.model import User    注意这句话的位置是在创建db之后
db.create_all()

'''