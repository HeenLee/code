#! _*_coding:utf8 _*_
'''
配置文件类，加载conf.ini的
'''
import configparser


class Config():

    def __init__(self, conf_path):
        """
        定义构造参数，传入配置文件的路径，然后读取
        """
        self.config = configparser.ConfigParser()
        self.conf_path = conf_path
        self.config.read(conf_path, encoding='utf8')

    def get_value(self, section, option):
        """
        获取配置文件的属性值
        :param section: conf.ini配置文件的部分
        :param option:  conf.ini配置文件的部分下面的属性
        :return: 返回属性的值
        """
        value = self.config.get(section, option)
        return value

    def set_value(self, section, option, value):
        """
        设置conf.ini配置文件中的某个属性值
        :param section: conf.ini配置文件的部分
        :param option:  conf.ini配置文件的部分下面的属性
        :param value: 设置的新值
        :return: None
        """
        self.config.set(section, option, value) #设置某个属性的值
        #设置后，需要写入到配置文件中
        with open(self.conf_path, 'w') as f:
            self.config.write(f)
