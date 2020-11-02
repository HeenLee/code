from flask import Flask, Blueprint, render_template

users = Blueprint('user',__name__)
# 创建蓝图对象
#Blueprint必须指定两个参数，admin表示蓝图的名称，__name__表示蓝图所在模块
# admin = Blueprint('admin',__name__)


@users.route('/user')
def user():
    return render_template('user.html')


