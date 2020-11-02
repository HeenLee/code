# _*_ coding=utf8 _*_
import random
ran = random.random()   # 0-1之间的随机小数

print(ran)

ran = random.randrange(1,10)  # 1-10之间的数 randrange(start,stop,step)
print(ran)

ran = random.randint(1,10)
print(ran)

lt = ['a','b','c','d']
ran = random.choice(lt)    #随机选择列表内容
print(ran)

score = ['a','b','c','d','e']
ran = random.shuffle(score)   #打乱顺序
print(score)


#验证码 大写字母与数字组合

def func():
    code = ''
    for i in range(4):
        ran1 = str(random.randint(0,9))
        ran2 = chr(random.randint(65,90))
        ran3 = chr(random.randint(97,122))
        r = random.choice([ran1,ran2,ran3])
        code+=r
    return code
print(func())
