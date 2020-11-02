from flask import Flask
from flask_sqlalchemy import  SQLAlchemy

app = Flask(__name__)

"""配置参数"""
#sqlalchemy配置参数
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root:root@127.0.0.1:3306/db_python'
# 设置sqlalchemy自动跟踪数据库
app.config['SQLALCHEMY_TRACK_MODIFICATIONS']= True
app.config['SQLALCHEMY_COMMIT_ON_TEARDOWN'] = True

# 创建数据库工具对象
db = SQLAlchemy(app)


#创建型类-作者
class Author(db.Model):
    """用户角色表"""
    __tablename__ = 'author'
    id = db.Column(db.Integer,primary_key=True)
    name = db.Column(db.String(32),unique=True)
    email = db.Column(db.String(64))
    au_book = db.relationship('Book',backref='author')
    def __repr__(self):
        return 'Author:%s' % self.name

class Book(db.Model):
    """用户表"""
    __tablename__ = 'books'  #指明数据库的表名
    id = db.Column(db.Integer,primary_key=True)   #整型的主键会默认设置为自增主键
    info = db.Column(db.String(32),unique=True)
    leader = db.Column(db.String(32))
    au_book = db.Column(db.Integer,db.ForeignKey('author.id'))
    def __repr__(self):
        return 'Book:%s,%s' % (self.info,self.leader)
@app.route('/')
def index():
    return  'index page'

if __name__ == '__main__':
    #清除数据库里的所有数据
    db.drop_all()
    #创建所有的表
    db.create_all()


