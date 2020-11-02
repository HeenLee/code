#coding=utf-8
#eg.1
try:
    with open("a.txt","r") as f:
        print(f.read())
except:
    print("me")
finally:
    print("end")

#eg.2
def not_zero(num):
    try:
        if num ==0:
            raise ValueError("参数错误")
        return  num
    except Exception as e:
        print(e)
not_zero(0)

#eg.3
try:
    raise Exception
except:
    print("e")