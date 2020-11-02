#闭包的应用  计数器
# _*_coding=utf8 _*_
def generate_count():
    container = [0]
    def add_one():
        container[0] = container[0] + 1  #访问一次 加1
        print('当前是第{}次访问'.format(container[0]))
    return add_one
#内部函数就是一个计数器
counter = generate_count()
counter()
counter()
counter()



