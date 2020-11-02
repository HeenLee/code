import unittest
import HTMLTestRunner  #生成HTML报告,需要下载
import os

if __name__ == "__main__":
    # discover = unittest.defaultTestLoader.discover('.', pattern='test*.py')
    # runner = unittest.TextTestRunner()
    # runner.run(discover)

    #生成HTML测试报告的例子,需要导入HTMLTestRunner
    discover = unittest.defaultTestLoader.discover('.',pattern='test*.py')
    report_path = os.getcwd() + '/report.html'
    with open(report_path,'wb') as f:
        runner = HTMLTestRunner.HTMLTestRunner(stream=f,title='reportResult',description='测试报告')
        runner.run(discover)
