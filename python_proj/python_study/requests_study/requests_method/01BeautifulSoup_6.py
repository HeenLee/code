"""
上一篇文章的正则，其实对很多人来说用起来是不方便的，加上需要记很多规则，所以用起来不是特别熟练，
而这节我们提到的beautifulsoup就是一个非常强大的工具，爬虫利器。
一个灵活又方便的网页解析库，处理高效，支持多种解析器。
利用它就不用编写正则表达式也能方便的实现网页信息的抓取

标签选择器:
通过这种soup.标签名 我们就可以获得这个标签的内容
这里有个问题需要注意，通过这种方式获取标签，如果文档中有多个这样的标签，返回的结果是第一个标签的内容，
如上面我们通过soup.p获取p标签，而文档中有多个p标签，但是只返回了第一个p标签内容

"""
from bs4 import BeautifulSoup
import unittest
class TestBeautifulSoup(unittest.TestCase):
    def test_bs(self):
        html = '''
        <html><head><title>The Dormouse's story</title></head>
        <body>
        <p class="title"><b>The Dormouse's story</b></p>

        <p class="story">Once upon a time there were three little sisters; and their names were
        <a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>,
        <a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
        <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
        and they lived at the bottom of a well.</p>
        <p class="story">...</p>
        </body>
        </html>
        '''
        soup = BeautifulSoup(html,"lxml")
        print(soup.prettify())
        print(soup.title)   #<title>The Dormouse's story</title>
        print(soup.title.name) #title
        print(soup.title.string)  #The Dormouse's story
        print(soup.title.parent.name)
        print(soup.p)
        print(soup.p["class"])
        print(soup.a)
        print(soup.find_all("a"))
        print(soup.find(id="link3"))

        for link in soup.find_all("a"):
            print(link.get("href"))
        print(soup.get_text())

    #标签选择器
    def test_bs2(self):
        html = '''
         <html><head><title>The Dormouse's story</title></head>
         <body>
         <p class="title"><b>The Dormouse's story</b></p>

         <p class="story">Once upon a time there were three little sisters; and their names were
         <a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>,
         <a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
         <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
         and they lived at the bottom of a well.</p>
         <p class="story">...</p>
         </body>
         </html>
         '''
        soup = BeautifulSoup(html,"lxml")
        #通过这种soup.标签名 我们就可以获得这个标签的内容
        #如果文档中有多个这样的标签，返回的结果是第一个标签的内容，如上面我们通过soup.p获取p标签，而文档中有多个p标签，但是只返回了第一个p标签内容
        print(soup.title)
        print(type(soup.title))
        print(soup.head)
        print(soup.p)

    #
    def test_bs3(self):
        html = '''
         <html><head><title>The Dormouse's story</title></head>
         <body>
         <p class="title"><b>The Dormouse's story</b></p>

         <p class="story">Once upon a time there were three little sisters; and their names were
         <a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>,
         <a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
         <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
         and they lived at the bottom of a well.</p>
         <p class="story">...</p>
         </body>
         </html>
         '''
        soup = BeautifulSoup(html,"lxml")
        #获取名称
        print(soup.title.name)
        print(soup.p)
        #获取属性  两种方式  soup.标签名["属性"]
        print(soup.p.attrs["class"])
        print(soup.p["class"])

        #获取内容
        print(soup.p.string)

        #嵌套选择  我们直接可以通过下面嵌套的方式获取

        print(soup.head.title.string)

    #3.子节点和子孙节点 通过contents以及children都是获取子节点  descendants获取子孙节点
    def test_bs4(self):
        html = """
        <html>
            <head>
                <title>The Dormouse's story</title>
            </head>
            <body>
                <p class="story">
                    Once upon a time there were three little sisters; and their names were
                    <a href="http://example.com/elsie" class="sister" id="link1">
                        <span>Elsie</span>
                    </a>
                    <a href="http://example.com/lacie" class="sister" id="link2">Lacie</a>
                    and
                    <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>
                    and they lived at the bottom of a well.
                </p>
                <p class="story">...</p>
        """
        soup = BeautifulSoup(html, 'lxml')
        print(soup.p.contents)  #结果是将p标签下的所有子标签存入到了一个列表中

        #通过下面的方式也可以获取p标签下的所有子节点内容和通过contents获取的结果是一样的，
        # 但是不同的地方是soup.p.children是一个迭代对象，而不是列表，只能通过循环的方式获取素有的信息
        print(soup.p.children)
        for i,child in enumerate(soup.p.children):
            print(i,child)
        #通过contents以及children都是获取子节点，如果想要获取子孙节点可以通过descendants
        #print(soup.descendants)同时这种获取的结果也是一个迭代器
        for i in soup.p.descendants:
            print(i)

    #父节点和祖先节点  soup.a.parent就可以获取父节点的信息  通过list(enumerate(soup.a.parents))可以获取祖先节点，这个方法返回的结果是一个列表
    def test_bs5(self):
        html = """
        <html>
            <head>
                <title>The Dormouse's story</title>
            </head>
            <body>
            <span>
            <a href = "http://www.baidu.com" class="lg">自己</a>
            <p class="lg">我的</p>
            </span>
                <p class="story">
                    Once upon a time there were three little sisters; and their names were
                    <a href="http://example.com/elsie" class="sister" id="link1">
                        <span>Elsie</span>
                    </a>
                    <a href="http://example.com/lacie" class="sister" id="link2">Lacie</a>
                    and
                    <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>
                    and they lived at the bottom of a well.
                </p>
                <p class="story">...</p>
                <a href = "http://www.baidu.com" class="lg">自己</a>
        """
        soup = BeautifulSoup(html, 'lxml')
        #获取父节点
        print(soup.a.parent)
        #获取祖先节点  获取的是迭代器，需要遍历
        print("################################")
        print(soup.a.parents)
        for i in soup.a.parents:
            print(i)
        print("________________")

        #兄弟节点   获取的是迭代器  需要遍历
        print(soup.a.next_siblings) #获取后面的兄弟节点

        for i,s in enumerate(soup.a.next_siblings):
            print(i,s)

        for i,s in enumerate(soup.a.previous_siblings):
            print(i,s)

        for i,s in enumerate(soup.a.next_sibling):
            print(i,s)

        for i,s in enumerate(soup.p.previous_sibling):
            print(i,s)

    #标准选择器  find_all  find_all(name,attrs,recursive,text,**kwargs)
    #可以根据标签名，属性，内容查找文档
    def test_all(self):
        html = '''
        <div class="panel">
            <div class="panel-heading">
                <h4>Hello</h4>
            </div>
            <div class="panel-body">
                <ul class="list" id="list-1">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                    <li class="element">Jay</li>
                </ul>
                <ul class="list list-small" id="list-2">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                </ul>
            </div>
        </div>
        '''
        soup = BeautifulSoup(html,"lxml")
        print(soup.find_all("ul")) #结果返回的是一个列表的方式
        print(soup.find_all('ul')[0])

        for ul in soup.find_all("ul"):
            print(ul.find_all("li"))

    #attrs  attrs可以传入字典的方式来查找标签，但是这里有个特殊的就是class,因为class在python中是特殊的字段，所以如果想要查找class相关的可以更改attrs={'class_':'element'}
    # 或者soup.find_all('',{"class":"element})，特殊的标签属性可以不写attrs，例如id
    def test_attr(self):
        html = '''
        <div class="panel">
            <div class="panel-heading">
                <h4>Hello</h4>
            </div>
            <div class="panel-body">
                <ul class="list" id="list-1" name="elements">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                    <li class="element">Jay</li>
                </ul>
                <ul class="list list-small" id="list-2">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                </ul>
            </div>
        </div>
        '''
        soup = BeautifulSoup(html,"lxml")
        print(soup.find_all(attrs={"id":"list-1"}))
        print(soup.find_all(attrs={"name":"elements"}))

    #text
    def test_text(self):
        html = '''
         <div class="panel">
             <div class="panel-heading">
                 <h4>Hello</h4>
             </div>
             <div class="panel-body">
                 <ul class="list" id="list-1" name="elements">
                     <li class="element">Foo</li>
                     <li class="element">Bar</li>
                     <li class="element">Jay</li>
                 </ul>
                 <ul class="list list-small" id="list-2">
                     <li class="element">Foo</li>
                     <li class="element">Bar</li>
                 </ul>
             </div>
         </div>
         '''
        soup = BeautifulSoup(html, "lxml")
        print(soup.find_all(text="Foo")) #结果返回的是查到的所有的text='Foo'的文本

    #find()find(name,attrs,recursive,text,**kwargs)
    #find返回的匹配结果的第一个元素
    def test_find(self):
        html = '''
         <div class="panel">
             <div class="panel-heading">
                 <h4>Hello</h4>
             </div>
             <div class="panel-body">
                 <ul class="list" id="list-1" name="elements">
                     <li class="element">Foo</li>
                     <li class="element">Bar</li>
                     <li class="element">Jay</li>
                 </ul>
                 <ul class="list list-small" id="list-2">
                     <li class="element">Foo</li>
                     <li class="element">Bar</li>
                 </ul>
             </div>
         </div>
         '''
        soup = BeautifulSoup(html,"lxml")
        print(soup.find("ul").find_next_siblings())
        print(soup.find(attrs={"class":"list"}))

    #CSS选择器  通过select()直接传入CSS选择器就可以完成选择
    def test_select(self):
        html = '''
        <div class="panel">
            <div class="panel-heading">
                <h4>Hello</h4>
            </div>
            <div class="panel-body">
                <ul class="list" id="list-1">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                    <li class="element">Jay</li>
                </ul>
                <ul class="list list-small" id="list-2">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                </ul>
            </div>
        </div>
        '''
        soup = BeautifulSoup(html,"lxml")
        print(soup.select(".panel .panel-heading"))
        print(soup.select("ul li"))
        print(soup.select("#list-2 .element"))
        print(type(soup.select("ul")[0]))

    #获取内容 get_text() 获取文本内容
    def test_get_text(self):
        html = '''
        <div class="panel">
            <div class="panel-heading">
                <h4>Hello</h4>
            </div>
            <div class="panel-body">
                <ul class="list" id="list-1">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                    <li class="element">Jay</li>
                </ul>
                <ul class="list list-small" id="list-2">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                </ul>
            </div>
        </div>
        '''
        soup = BeautifulSoup(html, 'lxml')
        for li in soup.select("li"):
            print(li.get_text())

    #获取属性 通过[属性名]或者attrs[属性名]
    def test_attrs(self):
        html = '''
        <div class="panel">
            <div class="panel-heading">
                <h4>Hello</h4>
            </div>
            <div class="panel-body">
                <ul class="list" id="list-1">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                    <li class="element">Jay</li>
                </ul>
                <ul class="list list-small" id="list-2">
                    <li class="element">Foo</li>
                    <li class="element">Bar</li>
                </ul>
            </div>
        </div>
        '''
        soup = BeautifulSoup(html, 'lxml')
        for ul in soup.select("ul"):
            print(ul["id"])
            #print(ul.attrs["id"])


"""
总结：推荐使用lxml解析库，必要时使用html.parser
标签选择筛选功能弱但是速度快
建议使用find()、find_all() 查询匹配单个结果或者多个结果
如果对CSS选择器熟悉建议使用select()
记住常用的获取属性和文本值的方法
"""








