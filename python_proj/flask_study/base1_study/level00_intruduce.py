from flask import Flask
from flask_script import Manager   #Flask-Script扩展命令行
# 命令如下  python level00_intruduce.py runserver -h 127.0.0.1 -p 5001
""" 
Flask有两种上下文，请求上下文和应用上下文
"""
app = Flask(__name__)
manager = Manager(app)
@app.route('/')
def index():
    return "我是命令行工具"

if __name__ == '__main__':
    manager.run()

"""
 request和session都属于请求上下文 request context
 quest：封装了HTTP请求的内容，针对的是http请求。举例：
 user = request.args.get('user')，获取的是get请求的参数。

session：用来记录请求会话中的信息，针对的是用户信息。举例：
session['name'] = user.id，可以记录用户信息。
还可以通过session.get('name')获取用户信息
"""

"""
应用上下文(application context)
current_app和g都属于应用上下文对象
current_app:表示当前运行程序文件的程序实例。
我们可以通过current_app.name打印出当前应用程序实例的名字

g：处理请求时，用于临时存储的对象，每次请求都会重设这个变量。
比如：我们可以获取一些临时请求的用户信息

区别：请求上下文：保存了客户端和服务器交互的数据。 
应用上下文：在flask程序运行过程中，保存的一些配置信息，
比如程序文件名、数据库的连接、用户信息等
"""
