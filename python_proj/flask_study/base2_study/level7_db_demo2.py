from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import  SQLAlchemy
from flask_wtf import Form
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired

from base2_study.level7_db_demo1 import Author, Book

app = Flask(__name__)

"""配置参数"""
#sqlalchemy配置参数
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root:root@127.0.0.1:3306/db_python?charset=utf8'
# 设置sqlalchemy自动跟踪数据库
app.config['SQLALCHEMY_TRACK_MODIFICATIONS']= True
app.config['SQLALCHEMY_COMMIT_ON_TEARDOWN'] = True
app.config['SECRET_KEY'] = 's'

# 创建数据库工具对象
db = SQLAlchemy(app)


#创建表单类，用来添加信息
class Append(Form):
    au_info = StringField(validators=[DataRequired()])
    bk_info = StringField(validators=[DataRequired()])
    submit = SubmitField('添加')

@app.route('/',methods=['GET','POST'])
def index():
    #查询所有作者和书名信息
    author = Author.query.all()
    book = Book.query.all()
    #创建表单对象
    form = Form()
    if form.validate_on_submit():
        #获取表单输入数据
        wtf_au = form.au_info.data
        wtf_bk = form.bk_info.data
        #把表单数据存入模型类
        db_au = Author(name=wtf_au)
        db_bk = Book(name=wtf_bk)
        #提交会话
        db.session.add_all([db_au,db_bk])
        db.session.commit()

        #添加数据后，再次查询所有作者和数名信息
        author = Author.query.all()
        book = Book.query.all()
        return render_template('auth_book.html',author=author,book=book,form=form)
    else:
        if request.method == 'GET':
            return render_template('auth_book.html', author=author, book=book, form=form)
    return  render_template('auth_book.html',author=author,book=book,form=form)

#删除作者
@app.route('/delete_author<id>')
def delete_author(id):
    #精确查询需要删除的作者id
    au = Author.query.filter_by(id=id).first()
    db.session.delete(au)
    #直接重定向到index视图函数
    return redirect(url_for('index'))

#删除书名
@app.route('/delete_book<id>')
def delete_book(id):
    bk = Book.query.filter_by(id=id).first()
    db.session.delete(bk)
    #直接重定向到index视图函数
    return redirect(url_for('index'))


if __name__ == '__main__':
    #清除数据库里的所有数据
    db.drop_all()
    #创建所有的表
    db.create_all()

    #生成数据
    au_xi = Author(name='我吃西红柿',email='xihongshi@163.com')
    au_qian = Author(name='萧潜',email='xiaoqian@126.com')
    au_san = Author(name='唐家三少',email='sanshao@163.com')
    bk_xi = Book(info='吞噬星空',leader='罗峰')
    bk_xi2 = Book(info='寸芒',leader='李杨')
    bk_qian = Book(info='飘渺之旅',leader='李强')
    bk_san = Book(info='冰火魔厨',leader='融念冰')

    #把数据提交给用户会话
    db.session.add_all([au_xi,au_qian,au_san,bk_xi,bk_xi2,bk_qian,bk_san])
    #提交会话
    db.session.commit()
    app.run()


