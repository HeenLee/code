from flask import Flask,current_app
#创建flask的应用对象
#flask以这个模块所在的目录为总目录，默认这个目录中的static为静态目录，templates为模板目录
app = Flask(__name__, #__name__表示当前的模块名字
            static_folder='static',         #静态文件的目录，默认值是static
            template_folder='templates'  #模板文件的目录，默认是templates
            )

#配置参数的使用方式
#1.   使用配置文件
# app.config.from_pyfile('config.cfg')

#2. 使用对象配置参数
class Config(object):
    DEBUG = True
    ITCAST = 'python'
app.config.from_object(Config)

#3.     直接操作config的字典对象
# app.config['DEBUG'] = True

@app.route('/')
def index():
    """定义的视图函数
    :return:
    """
    # 1. 直接从全局对象APP字典中取值
    # print(app.config.get('ITCAST'))
    #2. 通过current_app获取参数
    # print(current_app.config.get('ITCAST'))
    # return 'hello falsk'

if __name__ == '__main__':
    #启动flask程序
    # app.run()
    print(app.url_map)      #通过url_map可以查看整个flask中的路由信息
    app.run(host='127.0.0.1',port=5000,debug=True)







