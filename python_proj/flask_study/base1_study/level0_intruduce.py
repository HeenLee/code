"""
flask入门，包含路由传参，视图函数，重定向redirect() url_for()
"""

from flask import Flask, abort, make_response
from flask import request,jsonify,redirect,url_for

#创建app应用
app = Flask(__name__)


# 1 路由地址、视图函数
@app.route('/')
def hello_world():
    return 'Hello World!'


#  2 路由传参   <int:parms>    参数类型：参数名 常用的有默认string， int  path
@app.route('/user/<int:user_id>')
def user_info(user_id):
    return 'the num is %d' % user_id

@app.route('/user/2/<path:user_id>')
def user_info2(user_id):
    return 'hello %s' % user_id

# 3 指定请求类型
@app.route('/postmethod',methods=['GET','POST'])
def demo2():
    return request.method

# 4 响应内容，返回json
@app.route('/response_json')
def demo4():
    json_dict = {
        "user_id":10,
        "user_name":"pill"
    }
    return jsonify(json_dict)   #将字典数据转为json

# 5 重定向
@app.route('/redirect')
def demo5():
    return redirect('http://www.baidu.com')   #重定向到url地址

@app.route('/url_for')
def demo6():
    return redirect(url_for('demo4'))    #重定向到 根据name查找视图函数

@app.route('/demo7')
def demo7():
    return redirect(url_for('user_info',user_id=100))  #重定向到视图函数，可以传参

#返回响应码
@app.route('/code')
def response_code():
    return 'success',1000   #返回1000响应码

#abort函数
#如果在视图函数执行过程中，出现了异常错误，我们可以使用abort函数立即终止视图函数的执行 如果abort函数被触发，其后面的语句将不会执行
@app.route('/abort')
def stop():
    abort(400)
    return 'hello flask',999
#装饰器异常处理。如果这里处理了400，则访问上面的会返回200
@app.errorhandler(400)
def error(e):
    return "出错了"


#设置cookie和获取cookie
@app.route('/cookie')
def set_cookie():
    response = make_response('this is to set cookie')
    response.set_cookie('username','itcast')
    return response

#设置请求
@app.route('/request')
def resp_cookie():
    resp = request.cookies.get('username')
    return resp

if __name__ == '__main__':
    print(app.url_map)
    app.run(debug=True)
