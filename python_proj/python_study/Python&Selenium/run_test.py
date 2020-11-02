import HTMLTestRunner
import time
import unittest

# 相对路径定义用例存放的路径和报告存放路径
from requests_study.requests_method.upload_test import file

test_dir = './test_case'
test_dir1 = './report'  # 查找对应路径下的测试用例放到discover中
discover = unittest.defaultTestLoader.discover(test_dir, pattern='test*.py')
# 定义带有当前测试时间的报告，防止前一次报告被覆盖
now = time.strftime("%Y-%m-%d %H_%M_%S")
filename = test_dir1 + '/' + now + 'result.html'
# 二进制打开，准备写入文件
fp = file(filename, 'wb')
# 定义测试报告
runner = HTMLTestRunner.HTMLTestRunner(
    stream=fp,
    title=u'搜索测试报告',
    description=u'用例执行情况')
runner.run(discover)

