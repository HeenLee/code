from flask import Flask, render_template
#此处需要注意，视图函数渲染的模板，目录默认在本包的templates中
#不同的视图函数指向的模板最好不要用同一个html，会无法显示
"""
模板的基础语法:
1. 变量引用用{{ var}}
2. 编程语言用{% if ...%}       
{% if user %}      if ...else  ..endif
    {{ user }}
{% else %}
    hello!
<ul>
    {% for index in indexs %}   for ... endfor    
    <li> {{ index }} </li>
    {% endfor %}
</ul>


3. 使用 {# #} 进行注释，注释的内容不会在html中被渲染出来


模板中特有的变量和函数:你可以在自己的模板中访问一些 Flask 默认内置的函数和对象
config：你可以从模板中直接访问Flask当前的config对象  {{config.SQLALCHEMY_DATABASE_URI}}
reqeust：就是flask中代表当前请求的request对象 {{request.url}}
session：为Flask的session对象   {{session.new}}
g变量：在视图函数中设置g变量的name属性值，然后在模板中直接可以取用   {{ g.name }}
url_for()：url_for会根据传入的路由器函数名,返回该路由对应的URL,在模板中始终使用url_for()就可以安全的修改路由绑定的URL,
则不比担心模板中渲染出错的链接     {{ url_for('post', post_id=1)}}
 
"""
app = Flask(__name__, #__name__表示当前的模块名字
            static_folder='static',         #静态文件的目录，默认值是static
            template_folder='templates'  #模板文件的目录，默认是templates
            )

#创建Manager管理类的对象

@app.route('/demo')
def hello1():
    return render_template('demo.html')

@app.route('/hello2')
def hello2():
    user = 'python'
    return render_template('index.html',user=user)

@app.route('/hello3/<name>')
def hello3(name):
    return render_template('index.html',name=name)

#字典格式的用可变的**可以代替
@app.route('/index')
def index():
    data = {
        'name':'python',
        'age':18,
        'my_dict':{'city':'sz'},
        'my_list':[1,2,3,4,5],
        'my_int':0
    }
    # return  render_template('index.html',name='python',age=18)
    return  render_template('dict.html', **data)

@app.route('/hello')
def hello():
    mydict = {'key':'silence is gold'}
    mylist = ['Speech', 'is','silver']
    myintvar = 0

    return render_template('vars.html',mydict=mydict, mylist=mylist,myintvar=myintvar )

#自定义过滤器 :两种方式
def list_step_2(li):
    """自定义过滤器"""
    return li[::2]
#注册过滤器,第一个是函数，第二个是别名
app.add_template_filter(list_step_2,'li2')

@app.template_filter('li3')
def list_step_3(li):
    """自定义过滤器"""
    return li[::3]

if __name__ == '__main__':
    app.run(debug=True)