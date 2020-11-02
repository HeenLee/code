from flask import Flask
from flask_sqlalchemy import  SQLAlchemy

app = Flask(__name__)

class Config(object):
    """配置参数"""
    #sqlalchemy配置参数
    SQLALCHEMY_DATABASE_URI = 'mysql+pymysql://root:root@127.0.0.1:3306/db_python'
   # 设置sqlalchemy自动跟踪数据库
    SQLALCHEMY_TRACK_MODIFICATIONS = True

app.config.from_object(Config)
# 创建数据库工具对象
db = SQLAlchemy(app)

#表名的常见规范
# ihome -> ih_user   数据库名缩写_表名
# tbl_user  tbl_表名


#创建数据库模型类
class Role(db.Model):
    """用户角色表"""
    __tablename__ = 'tbl_roles'
    id = db.Column(db.Integer,primary_key=True)
    name = db.Column(db.String(32),unique=True)
    users = db.relationship('User',backref='role')


class User(db.Model):
    """用户表"""
    __tablename__ = 'tbl_users'  #指明数据库的表名
    id = db.Column(db.Integer,primary_key=True)   #整型的主键会默认设置为自增主键
    name = db.Column(db.String(64),unique=True)
    email = db.Column(db.String(128),unique=True)
    password = db.Column(db.String(128))
    role_id = db.Column(db.Integer,db.ForeignKey('tbl_roles.id'))

@app.route('/')
def index():
    return  'index page'

if __name__ == '__main__':
    #清除数据库里的所有数据
    db.drop_all()
    #创建所有的表
    db.create_all()
"""
    #1.创建对象
    role1 = Role(name='admin')
    # 2.session记录对象任务
    db.session.add(role1)
    #3. 提交任务到数据库中
    db.session.commit()

    role2 = Role(name='stuff')
    db.session.add(role2)
    db.session.commit()

    us1 = User(name='wang',email='wang@163.com',password='123456',role_id=role1.id)
    us2 = User(name='zhang',email='zhang@189.com',password='201512',role_id=role2.id)
    us3 = User(name='chen',email='chen@126.com',password='987654',role_id=role2.id)
    us4 = User(name='zhou',email='zhou@163.com',password='456789',role_id=role1.id)

    #一次保存多条数据
    db.session.add_all([us1,us2,us3,us4])
    db.session.commit()

    #查询操作
    Role.query.all() #查询所有记录
    Role.query.first()#查询单个记录
    Role.query.get(2)#主键的I的

    db.session.query(Role).all()
    db.session.query(Role).get(2)

    #过滤查询
    #举例，查询User表
    User.query.filter_by(name='wang').all()
    User.query.filter_by(name='wang').first()
    #and查询
    User.query.filter_by(name='wang',role_id=1).first()
    User.query.filter(User.name=='wang',User.role_id=='1').all()
    User.query.filter(User.name=='wang',User.role_id=='1').first()
    #or查询
    from sqlalchemy import or_
    User.query.filter(or_(User.name=='wang',User.email.endswith('163.com'))).all()
    #offset()偏移，跳过几条
    User.query.offset(2).all()
    User.query.offset(1).limit(2).all()
    User.query.filter().offset().limit().order_by().all()
    #排序
    User.query.order_by('-id').all()#不推荐
    User.query.order_by(User.id.desc()).all() #降序
    User.query.order_by(User.id.asc()).all() #降序
    #分组查询,
    from sqlalchemy import func
    db.session.query(User.role_id,func.count(User.role_id)).group_by(User.role_id).all()

    #关联查询
    Role.query.get(1)
"""

