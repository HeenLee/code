import configparser
import os

#���������ļ�
config = configparser.ConfigParser()
print(os.getcwd())
#��ȡ�����ļ�·��
config_path = os.path.dirname(os.getcwd()) + "/conf/conf.ini"
#��ȡ�����ļ�
config.read(config_path,encoding='utf8')
#ͨ��section��Ȼ���ȡ����ļ�
url = config.get('address','url')
#��section��Ӽ�ֵ��
config.set('address','name',"lihe")
#���¼ӵļ�ֵ��д�������ļ���
with open(config_path,'w') as f:
    config.write(f)

print(url)