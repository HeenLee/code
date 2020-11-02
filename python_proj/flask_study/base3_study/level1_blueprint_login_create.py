from flask import Flask, Blueprint, render_template

logins = Blueprint('login',__name__)
# 创建蓝图对象
#Blueprint必须指定两个参数，admin表示蓝图的名称，__name__表示蓝图所在模块
# admin = Blueprint('admin',__name__)


@logins.route('/login')
def login():
    return render_template('login.html')


