from flask import Flask, render_template, request, redirect, url_for, flash

from flask_wtf import FlaskForm, Form
from wtforms import SubmitField,StringField,PasswordField
from wtforms.validators import DataRequired,EqualTo
#web表单
app = Flask(__name__)
app.config['SECRET_KEY'] = '1'

class Login(Form):
    us = StringField(label='用户：',validators=[DataRequired()])
    ps = PasswordField(label='密码',validators=[DataRequired(),EqualTo('ps2','err')])
    ps2 = PasswordField(label='确认密码',validators=[DataRequired()])
    submit = SubmitField("提交")

#使用HTML写页面
@app.route('/login',methods=['POST','GET'])
def login():
    if request.method == 'POST':
        username = request.form.get('username')
        password = request.form['password']
        print(username,password)
    return render_template('form.html',method=request.method)

#使用flask-wtf
@app.route('/login1')
def login1():
    return render_template('login.html')

#定义根路由视图函数，生成表单对象，获取表单数据，进行表单数据验证
@app.route('/',methods=['GET','POST'])
def index():
    form = Login()
    if form.validate_on_submit():
        name = form.us.data
        pswd = form.ps.data
        pswd2 = form.ps2.data
        print(name,pswd,pswd2)
        return redirect(url_for('login'))
    else:
        if request.method=='POST':
            flash(u'信息有误，请重新输入！')
        print(form.validate_on_submit())

    return render_template('index.html',form=form)

"""前端输入脚本，注入攻击"""
@app.route('/xss',methods=['GET','POST'])
def index1():
    text = ''
    if request.method == 'POST':
        text = request.form.get('text')
    # return  render_template('index111.html',name='python',age=18)
    return  render_template('xss.html', text=text)


if __name__ == '__main__':
    app.run(debug=True)