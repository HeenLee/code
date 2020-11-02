#coding=utf-8
"""
re.match函数:
re.match 尝试从字符串的起始位置匹配一个模式，如果不是起始位置匹配成功的话，match()就返回none
re.match(pattern, string, flags=0)

group(num) 或 groups() 匹配对象函数来获取匹配表达式

re.search():扫描整个字符串并返回第一个成功的匹配

compile():用于编译正则表达式，生成一个正则表达式（ Pattern ）对象，供 match() 和 search() 这两个函数使用。

re.findall() ：在字符串中找到正则表达式所匹配的所有子串，并返回一个列表，如果没有找到匹配的，则返回空列表。
注意： match 和 search 是匹配一次 findall 匹配所有。
"""
import re

string = "www.runoob.com"
print(re.match("ww",string).span())   #<_sre.SRE_Match object; span=(0, 2), match='ww'>
print(re.match("com",string))  #None

line = "Cats are smarter than dogs"
matchObj = re.match('(.*) are (.*?) .*',line,re.M|re.I)
if matchObj:
    print("matchObj.group():" ,matchObj.group()) #matchObj.group(): Cats are smarter than dogs
    print("matchObj.group(1):" ,matchObj.group(1)) #matchObj.group(): Cats
    print("matchObj.group(2):" ,matchObj.group(2)) #matchObj.group(): smarter
    print("matchObj.groups():",matchObj.groups())   #matchObj.groups(): ('Cats', 'smarter')
else:
    print("no match")

print(re.search("ww",string).span())
print(re.search("com",string).span())

print(re.findall("w",string))


#通过compile获取到pattern对象，然后调用正则的方法
pattern = re.compile("\d+")
result = pattern.findall("aaabbbccc12bbd1234")
print(result)