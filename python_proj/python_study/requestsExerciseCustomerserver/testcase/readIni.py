import configparser
import os

#解析配置文件
config = configparser.ConfigParser()
print(os.getcwd())
#获取配置文件路径
config_path = os.path.dirname(os.getcwd()) + "/conf/conf.ini"
#读取配置文件
config.read(config_path,encoding='utf8')
#通过section，然后获取下面的键
url = config.get('address','url')
#给section添加键值对
config.set('address','name',"lihe")
#把新加的键值对写入配置文件中
with open(config_path,'w') as f:
    config.write(f)

print(url)