import time
def timea():
    stftime = time.strftime('%Y-%m-%d-%H-%M-%S', time.localtime(time.time()))
    return stftime
def a():
    print(timea())
def b():
    for x in range(10000):
        print(x,)
    print(timea())
if __name__ == "__main__":
    a()
    b()