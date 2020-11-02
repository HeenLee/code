from flask import Flask,make_response
app = Flask(__name__)


@app.route('/index')
def index():
    #1. 使用元组，返回自定义的响应信息
    #       响应参数：响应体    状态码  响应头
    # return 'Hello Flask!',400,[('itcast','python'),('city','shenzhen')]  状态码可以自定义
    # return 'Hello Flask!',400,{'itcast':'python','city':'shenzhen1'}
    # return 'Hello Flask!','666  wo cuo la',{'itcast':'python','city':'shenzhen1'}
    # return 'Hello Flask!','666  wo cuo la'


    #2 .使用make_response()构造响应信息
    resp = make_response('index page 2')  #设置响应内容
    resp.status = '999 cuo la'  #设置状态码
    resp.headers = {'city':'shenzhen','name':'hehe','content-type':'application/json'} # 设置响应头

    return resp


if __name__ == '__main__':
    app.run(debug=True)
