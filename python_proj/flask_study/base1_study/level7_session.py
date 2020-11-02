from flask import session, Flask

app = Flask(__name__)
#flask的session需要用到的密钥
app.config['SECRET_KEY'] = 'AFJDFJDFDJFOFJOFJDOFJDOFJDF'

#说明  flask中默认把session保存到cookie中。django保存在数据库

#设置session数据
@app.route('/login')
def login():
    #设置session数据
    session['name'] = 'python'
    session['mobile'] = '18611111111'
    return 'login success'

#使用session
@app.route('/index')
def index():
    #获取session数据
    name = session.get('name')
    return 'hello %s' % name


if __name__ == '__main__':
    app.run(debug=True)
