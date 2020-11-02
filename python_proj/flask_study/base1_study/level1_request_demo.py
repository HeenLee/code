"""
定义请求，渲染模板
"""
from flask import Flask, request, render_template, jsonify, make_response

'''请求数据不同的处理'''
app = Flask(__name__)

@app.route('/index',methods=['POST'])
def index():
    #request中包含了前端发送过来的所有请求数据
    #request.form可以直接提取请求体中的表单格式的数据，是一个类字典的对象
   #通过get方法只能拿到多个重名参数的第一个

    #三种获取请求的参数
    # 表单数据：request.form.get(key)
    # json格式数据：request.data
    # 获取get请求url中传递的参数：request.args.get(key)
    name = request.form.get("name") #获取表单数据
    age = request.form.get("age")  #获取表单数据
    name_list = request.form.getlist("hobby")   #获取全部hobby属性
    print(name_list)

    print(request.data)        #获取json等其他格式的数据

    city = request.args.get("city")  # 获取url中的参数，查询字符串

    print(request.headers)  #获取请求首部

    return 'hello name=%s, age=%s ,city=%s ,name_list=%s' % (name,age,city,name_list)


@app.route('/form',methods=['POST'])
def request_form():
    uname = request.form.get('uname')
    password = request.form.get('password')

    return make_response(uname + " " + password)

@app.route('/data/json',methods=['POST'])
def request_data():
    data = request.data

    return make_response(data)

@app.route('/args',methods=['GET'])
def request_args():
    uname = request.args.get('uname')
    password = request.args.get('password')

    return make_response(uname + " " + password)

if  __name__ == '__main__':
    app.run(debug=True)