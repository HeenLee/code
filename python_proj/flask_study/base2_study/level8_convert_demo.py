from flask import Flask, url_for, redirect
from werkzeug.routing import BaseConverter
app = Flask(__name__)

#转换器
@app.route("/goods/<int:good_id>")
def good(good_id):
    return 'good id %d ' % good_id

#1. 定义自己的转换器
class RegexConverter(BaseConverter):
        #调用父类的构造方法
        super().__init__(url_map)
        #将正则表达式的参数保存到对象属性中,flask会使用这个属性进行路由正则匹配
        self.regex = regex

#2. 将自定义的转换器添加到flask应用中
app.url_map.converters['re'] = RegexConverter

@app.route("send/<re(r'1[34578]\d{9}'):mobile>")
def send_ses(mobile):
    return 'send sms to %s' % mobile



if __name__ == '__main__':
    app.run(debug=True)