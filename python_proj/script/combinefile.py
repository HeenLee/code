#! /usr/bin/python
#_*_ coding:utf-8 _*_
import sys
import json
import os
import argparse
import time
import collections
import hashlib
import logging

reload(sys)   # 重新加载sys
sys.setdefaultencoding('utf8') # 修改默认的编码

'''
@:param
case_path 为用例路径，可以指定到具体的用例文件路径，也可以是用例目录
report_path 为测试报告路径
address 为访问的地址
client_secret 为获取token的密钥
mall_type 为商城的环境
'''

def parse_cmd_args(cmd_args):
    parse = argparse.ArgumentParser()
    parse.add_argument("-c","--case-path",type=str,required=True,help="testcase path")
    parse.add_argument("-r", "--report-path", type=str,required=True, help="output test report path")
    parse.add_argument("-s","--source_address",type=str,required=True,help="access address")
    parse.add_argument("-t","--client-secret",type=str,required=True,help="for generate token")
    parse.add_argument("-e","--mall-type",type=str,help="environment-type",default="mall_dev")
    args = parse.parse_args(cmd_args)
    return args


# 设置格式化时间
def stf_time():
    stftime = time.stftime = time.strftime('%Y-%m-%d-%H-%M-%S', time.localtime(time.time()))
    return stftime


#生成日志
def log(report_path):
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.DEBUG)
    # 设置格式化时间
    stftime = stf_time()
    # 生成日志的路径
    if(not os.path.exists(report_path)):
        os.makedirs(report_path)
    log_path = report_path + '/' + stftime + '_test.log'
    fh = logging.FileHandler(log_path, encoding='utf8')
    # 设置日志输出格式
    formatter = logging.Formatter("%(asctime)s - %(name)s - %(levelname)s - %(message)s")
    fh.setLevel(logging.DEBUG)
    fh.setFormatter(formatter)
    logger.addHandler(fh)
    return logger


# 通过address生成md5
def md5_value(address):
    m5 = hashlib.md5()
    m5.update(address)
    value = m5.hexdigest()  # value用来作为生成新的环境变量的文件名
    return value


#获取环境变量路径
def get_envir_path(envir_dir,address,client_secret,mall_type):

    # 环境变量
    if (os.listdir(envir_dir)):
        for envir_file in os.listdir(envir_dir):  # 遍历环境变量目录
            if (not envir_file.__contains__("bplus")):
                continue
            # 获取环境变量文件路径
            envir_path = envir_dir + envir_file
            # 新的环境变量文件路径
            new_envir_path = envir_dir + md5_value(address) + '_environment.json'
            # 复制环境变量文件内容到新的文件中
            with open(envir_path, 'r') as f:
                with open(new_envir_path, 'w') as outfile:
                    outfile.writelines(f.readlines())
            # 打开新的环境变量文件
            with open(new_envir_path, 'r') as f:
                data = json.load(f, encoding='utf8', object_pairs_hook=collections.OrderedDict)
            # 修改新变量中的值
            data['values'][0]['value'] = address
            data['values'][2]['value'] = client_secret
            data['values'][1]['value'] = mall_type
            # 将修改内容写入
            with open(new_envir_path, 'w') as f:
                json.dump(data, f, encoding='utf8', ensure_ascii=False)
        return new_envir_path
    else:
        raise Exception("envir_var not exist")


#执行用例
def excute_case(cmd_args):
    args = parse_cmd_args(cmd_args)
    case_path = args.case_path
    report_path = args.report_path
    address = args.source_address
    client_secret = args.client_secret
    mall_type = args.mall_type

    logger = log(report_path)
    logger.debug("param is : case_path:%s, report_path:%s, address:%s,client_secret:%s,mall_type:%s" % (
    case_path, report_path, address, client_secret, mall_type))

    # 如果是用例文件
    if os.path.isfile(case_path):
        envir_dir = os.path.dirname(os.path.dirname(case_path)) + '/env/'
        print(envir_dir)
        # 获取环境变量目录
        new_envir_path = get_envir_path(envir_dir, address, client_secret, mall_type)
        print(new_envir_path)
        # 测试报告名称
        report_name = report_path + '/newman-run-reporter-' + stf_time() + '.xml'
        print(report_name)
        command = 'newman run ' + case_path + ' -e ' + new_envir_path + ' --timeout-request 10000 -r junit --reporter-junit-export ' + report_name
        print(command)

        # 执行命令
        os.system(command)
        # 执行完删除生成的新环境变量文件
        # os.remove(new_envir_path)

        # 测试报告如果没有生产，查找3次，每次等待5s
        count = 0
        while(count < 3):
            if(os.path.exists(report_name)):
                break
            else:
                time.sleep(5)
                count += 1
        else:
            assert False

    # 如果是用例目录,则合并所有json到一个新的json文件
    elif os.path.isdir(case_path):
        # 获取环境变量目录
        envir_dir = os.path.dirname(case_path) + '/env/'
        new_envir_path = get_envir_path(envir_dir, address, client_secret, mall_type)

        new_file = case_path + '/test_all.json'  # 定义新文件

        file_list = os.listdir(case_path)  # 获取测试用例目录下的文件列表
        # 将目录中的第一个文件写入到新文件中
        with open(case_path + '/' + file_list[0], 'r') as f:
            with open(new_file, 'w') as outfile:
                outfile.writelines(f.readlines())

        # 获取新文件中的内容
        with open(new_file, 'r') as f:
            new_file_data = json.load(f, encoding='utf8', object_pairs_hook=collections.OrderedDict)

        # 将项目名称改为test_all
        new_file_data['info']['name'] = 'test_all'
        # item_content = new_file_data.get('item')[0].get('item')

        # 获取new_file的item列表
        item_content = new_file_data.get('item')

        # 从第二个文件开始读取item列表的内容，添加到上一步的item_content列表中
        for subfile in file_list[1:]:  # 从第二个文件开始遍历
            if (os.path.basename(subfile) == 'test_all.json'):
                continue
            with open(case_path + '/' + subfile, 'r') as f:  # 打开文件
                subfile_data = json.load(f, encoding='utf8', object_pairs_hook=collections.OrderedDict)  # 读取文件内容
            subfile_item = subfile_data.get('item')  # 获取到文件的itemList
            item_content.extend(subfile_item)  # 将itemList追加到item_content中

        # new_file的item已经更新，然后用新的内容替换new_file中的内容
        with open(new_file, mode='w') as f:
            json.dump(new_file_data, f, encoding='utf8', ensure_ascii=False)


        # 测试报告名称

        report_name = report_path + '/newman-run-reporter-' + stf_time() + '.xml'
        command = 'newman run ' + new_file + ' -e ' + new_envir_path + ' --timeout-request 10000 -r junit --reporter-junit-export ' + report_name

        # 执行命令
        os.system(command)
        # 执行完删除生成的新环境变量文件
        # os.remove(new_envir_path)

        # 测试报告如果没有生产，查找3次，每次等待5s
        count = 0
        while (count < 3):
            if (os.path.exists(report_name)):
                break
            else:
                time.sleep(5)
                count += 1
        else:
            assert False
    else:
        raise Exception("error,please input case_dir again")


def main():
    excute_case(sys.argv[1:])


if __name__ == "__main__":
    main()