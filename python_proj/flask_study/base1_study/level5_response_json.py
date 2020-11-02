from flask import Flask,make_response,jsonify
app = Flask(__name__)


@app.route('/index')
def index():
    # json就是字符串
    data = {
        'name':'python',
        'age':18
    }
    #1. 返回json格式数据  用json模块
    # return json.dumps(data),200,{'content-type':'application/json'}

    # 2. 使用jsonify()函数, 转为json数据，并设置响应头
    # return jsonify(data)
    return jsonify(city='sz',country='china')

if __name__ == '__main__':
    app.run(debug=True)
