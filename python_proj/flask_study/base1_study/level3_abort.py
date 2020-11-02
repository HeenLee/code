from flask import Flask, abort, Response, request

app = Flask(__name__)

@app.route('/login',methods=['GET'])
def login():
    # name = request.form.get('name')
    # pwd = request.form.get()
    name = ''
    pwd = ''

    if name != 'zhangsan' or pwd != 'admin':
        #使用abort函数可以立即终止视图函数的执行
        #并返回给前端指定的信息
        #1.传递状态码信息,必须是标准http状态码
        # abort(404) #abort函数可以终止
        # 2.传递响应体信息
        abort(Response("login failed"))
        return 'login success'
    else:
        return 'login success'

#定义错误处理的方法
@app.errorhandler(404)
def handle_404_error(error):
    """自定义的处理错误方法"""
    #这是函数的返回值是前端用户看到的最终结果
    return "出现了404错误,错误信息:%s" % error


if  __name__ == '__ma:in__':
    app.run(debug=True)