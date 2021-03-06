"""正则表达式 re模块
\w      匹配字母数字及下划线
\W      匹配f非字母数字下划线
\s      匹配任意空白字符，等价于[\t\n\r\f]
\S      匹配任意非空字符
\d      匹配任意数字
\D      匹配任意非数字
\A      匹配字符串开始
\Z      匹配字符串结束，如果存在换行，只匹配换行前的结束字符串
\z      匹配字符串结束
\G      匹配最后匹配完成的位置
\n      匹配一个换行符
\t      匹配一个制表符
^       匹配字符串的开头
$       匹配字符串的末尾
.       匹配任意字符，除了换行符，re.DOTALL标记被指定时，则可以匹配包括换行符的任意字符
[....]  用来表示一组字符，单独列出：[amk]匹配a,m或k
[^...]  不在[]中的字符：[^abc]匹配除了a,b,c之外的字符
*       匹配0个或多个的表达式
+       匹配1个或者多个的表达式
?       匹配0个或1个由前面的正则表达式定义的片段，非贪婪方式
{n}     精确匹配n前面的表示
{m,m}   匹配n到m次由前面的正则表达式定义片段，贪婪模式
a|b     匹配a或者b
()      匹配括号内的表达式，也表示一个组
注意到group(0)永远是原始字符串，group(1)、group(2)……表示第1、2、……个子串。groups()是子串的元组
"""
import unittest
import re
import requests
class TestRegExp(unittest.TestCase):
    #1.re.match(pattern,string,flags=0)尝试从字符串的起始位置匹配一个模式，如果不是起始位置匹配的话，match（）就会返回None
    def test_match(self):
        content = "hello 123 4567 World_This is a regex Demo"
        print(len(content))
        result = re.match("^hello\s\d{3}\s\d{4}\s\w{10}.*Demo",content)
        #result = re.match("e.*",content)
        #result = re.search("hello.*?(\d+).*?re",content)
        print(result)
        print(result.group())  #获取匹配的结果
        print(result.span())   #获取匹配字符串的长度范围


    #2.泛匹配
    def test_match2(self):
        content = "hello 123 4567 World_This is a regex Demo"
        print(len(content))
        result = re.match("^hello.*o$",content)  #  ^是开头   $是结尾
        print(result)
        print(result.group())  #获取匹配的结果
        print(result.span())   #获取匹配字符串的长度范围

    #3.匹配目标 如果为了匹配字符串中具体的目标，则需要通过（）括起来
    def test_match3(self):
        content = "hello 1234567 World_This is a regex Demo"
        print(len(content))
        result = re.match("^hello\s(\d+)\sWorld.*Demo$", content)  # ^是开头   $是结尾
        print(result)
        print(result.group())  # 获取匹配的结果
        print(result.group(1)) #1234567 这里需要说一下的是通过re.group()获得结果后，如果正则表达式中有括号，则re.group(1)获取的就是第一个括号中匹配的结果
        print(result.span())  # 获取匹配字符串的长度范围

    #4.贪婪匹配
    def test_match4(self):
        content = "hello 1234567 World_This is a regex Demo"
        result = re.match("^hello.*(\d+).*Demo",content)
        print(result)
        print(result.group())  # 获取匹配的结果
        print(result.group(1)) # 7
        print(result.span())  # 获取匹配字符串的长度范围
        """
        从结果中可以看出只匹配到了7，并没有匹配到1234567，出现这种情况的原因是前面的.* 给匹配掉了， .*在这里会尽可能的匹配多的内容，也就是我们所说的贪婪匹配，

          如果我们想要匹配到1234567则需要将正则表达式改为：

        result= re.match('^he.*?(\d+).*Demo',content)

        这样结果就可以匹配到1234567"""

    #5.匹配模式 很多时候匹配的内容是存在换行的问题的，这个时候的就需要用到匹配模式re.S来匹配换行的内容
    def test_match5(self):
        content = """hello 123456 world_this
                my name is zhaofan
"""
        result = re.match('^he.*?(\d+).*?zhaofan$', content, re.S)
        print(result)
        print(result.group())  #获取匹配结果。包括匹配的换行符
        print(result.group(1))

    #6.转义
    def test_match6(self):
        content = "price is $5.00"
        result = re.match("price is \$5\.00",content)
        print(result)
        print(result.group())
        """
        对上面的一个小结：
        尽量使用泛匹配，使用括号得到匹配目标，尽量使用非贪婪模式，有换行符就用re.S
        强调re.match是从字符串的起始位置匹配一个模式
        """

    #7.re.search()扫描整个字符串返回第一个成功匹配的结果
    def test_search(self):
        content = "extra things hello 123455 world_this is a Re Extra things"
        result = re.search("hello.*?(\d+).*?Re",content)  #实这个时候我们就不需要在写^以及$，因为search是扫描整个字符串
        print(result)
        print(result.groups())
        print(result.group(1)) #所以为了匹配方便，我们会更多的用search，不用match,match必须匹配头部，所以很多时候不是特别方便

    def test_serach1(self):
        html = '''<div id="songs-list">
            <h2 class="title">经典老歌</h2>
            <p class="introduction">
                经典老歌列表
            </p>
            <ul id="list" class="list-group">
                <li data-view="2">一路上有你</li>
                <li data-view="7">
                    <a href="/2.mp3" singer="任贤齐">沧海一声笑</a>
                </li>
                <li data-view="4" class="active">
                    <a href="/3.mp3" singer="齐秦">往事随风</a>
                </li>
                <li data-view="6"><a href="/4.mp3" singer="beyond">光辉岁月</a></li>
                <li data-view="5"><a href="/5.mp3" singer="陈慧琳">记事本</a></li>
                <li data-view="5">
                    <a href="/6.mp3" singer="邓丽君">但愿人长久</a>
                </li>
            </ul>
        </div>'''
        result = re.search('<li.*?active.*?singer="(.*?)">(.*?)</a>', html, re.S)
        print(result)
        print(result.groups())  #返回匹配的括号内数组的元组
        print(result.group(1))
        print(result.group(2))

    #8. re.findall()搜索字符串，以列表的形式返回全部能匹配的子串
    def test_findall(self):
        html = '''<div id="songs-list">
            <h2 class="title">经典老歌</h2>
            <p class="introduction">
                经典老歌列表
            </p>
            <ul id="list" class="list-group">
                <li data-view="2">一路上有你
                </li>
                <li data-view="7">
                    <a href="/2.mp3" singer="任贤齐">沧海一声笑</a>
                </li>
                <li data-view="4" class="active">
                    <a href="/3.mp3" singer="齐秦">往事随风</a>
                </li>
                <li data-view="6">
                    <a href="/4.mp3" singer="beyond">光辉岁月</a>
                </li>
                <li data-view="5">
                    <a href="/5.mp3" singer="陈慧琳">记事本</a>
                </li>
                <li data-view="5">
                    <a href="/6.mp3" singer="邓丽君">但愿人长久</a>
                </li>
            </ul>
        </div>'''
        results = re.findall('<li.*?href="(.*?)".*?singer="(.*?)">(.*?)</a>',html,re.S)  #添加括号是一组，为了提取出来内容
        print(results)
        print(type(results))
        for result in results:
            print(result)
            print(result[0],result[1],result[2])

    #9.findall()练习  s*? 这种用法其实就是为了解决有的有换行，有的没有换行的问题
    #(<a.*?>)? 这种用法是因为html中有的有a标签，有的没有的，？表示匹配一个或0个，正好可以用于匹配
    def test_findall2(self):
        html = '''<div id="songs-list">
            <h2 class="title">经典老歌</h2>
            <p class="introduction">
                经典老歌列表
            </p>
            <ul id="list" class="list-group">
                <li data-view="2">一路上有你
                </li>
                <li data-view="7">
                    <a href="/2.mp3" singer="任贤齐">沧海一声笑</a>
                </li>
                <li data-view="4" class="active">
                    <a href="/3.mp3" singer="齐秦">往事随风</a>
                </li>
                <li data-view="6">
                    <a href="/4.mp3" singer="beyond">光辉岁月</a>
                </li>
                <li data-view="5"><a href="/5.mp3" singer="陈慧琳">记事本</a>
                </li>
                <li data-view="5">
                    <a href="/6.mp3" singer="邓丽君">但愿人长久</a>
                </li>
            </ul>
        </div>'''

        results = re.findall('<li.*?>\s*?(<a.*?>)?(\w+)(</a>)?\s*?</li>',html,re.S)   #需要哪些，就在哪里分段
        print(results)
        for result in results:
            print(result[1])

    #10.re.sub() 替换字符串中每一个匹配的子串后返回替换后的字符串 re.sub(正则表达式，替换成的字符串，原字符串)
    def test_sub(self):
        content = "Extra things hello 123455 World_this is a regex Demo extra things"
        content = re.sub("\d+","",content)
        print(content)

    def test_sub2(self):
        content = "Extra things hello 123455 World_this is a regex Demo extra things"
        content = re.sub("(\d+)",r'\1 7890',content)
        print(content)

    #11.re.compile() 将正则表达式编译成正则表达式对象，方便复用该正则表达式
    def test_compile(self):
        content = """hello 123456 world_this
123 fan
"""
        pattern = re.compile("hello.*fan",re.S)
        result = re.match(pattern,content)
        print(result)
        print(result.group())


    #12.正在表达式综合练习
    def test_re(self):
        request = requests.get("https://book.douban.com/")
        content = request.text
        pattern = re.compile('<li.*?cover.*?href="(.*?)".*?title="(.*?)".*?more-meta.*?author">(.*?)</span>.*?year">(.*?)</span>.*?</li>',re.S)
        results = re.findall(pattern,content)
        #print(results)
        for result in results:
            url,name,author,date = result
            author = re.sub("\s","",author)
            date = re.sub("\s","",date)
            print(url,name,author,date)


if __name__ == "__main__":
    unittest.main()