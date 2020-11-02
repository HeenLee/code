#coding=utf-8
import json
dict_data = {"name":"hhe","age":18}
#将字典转为json
json_data = json.dumps(dict_data)
print(dict_data)
print(json_data)

#将json转为字典
data = json.loads(json_data)
print(data)