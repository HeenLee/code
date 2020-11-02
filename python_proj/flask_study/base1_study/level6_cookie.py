from flask import Flask, make_response, request

app = Flask(__name__)

@app.route('/set_cookie')
def set_cookie():
    resp = make_response('success') #设置响应内容
    # 1. 设置cookie,默认有效期是临时cookie，浏览器关闭失效
    resp.set_cookie('langue','python')
    # resp.set_cookie('Path','java')
    # #max_age 设置有效期，单位 '秒'
    # resp.set_cookie('domain','/main',max_age=3600)

    # 2. 也可以通过headers设置cookie
    # resp.headers['Set-cookie'] = 'itcast3=python3; Expire=Thu;   max_age=12 '
    return resp

@app.route('/get_cookie')
def get_cookie():
    cookie1 = request.cookies.get('langue')
    return cookie1

@app.route('/delete_cookie')
def delete_cookie():
    resp = make_response('dele success')
    #删除cookie
    resp.delete_cookie('itcast')
    return resp


if __name__ == '__main__':
    app.run(debug=True)
