from flask import Flask, Blueprint, render_template
#导入蓝图对象
from .level1_blueprint_login_create import logins
from .level1_blueprint_user_create import users
app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'hello world'

#注册蓝图，第一个参数logins是蓝图对象，url_prefix参数默认值时跟路由，如果指定，会在蓝图注册的路由url中添加
app.register_blueprint(logins,url_prefix='')
app.register_blueprint(users,url_prefix='')

if __name__ == '__main__':
    app.run(debug=True)


