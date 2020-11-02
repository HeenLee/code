#_*_coding=utf8_*_
import unittest
class Demo(unittest.TestCase):
    def setUp(self):
        print("初始化,每条测试用例前都要执行一次")

    def tearDown(self):
        print("清除操作,每条测试用例执行完后都要执行一次")

    @classmethod  #类装饰器
    def setUpClass(cls):
        print('类的初始化,再类前只执行一次'+"\n")

    @classmethod   #类装饰器
    def tearDownClass(cls):
        print('类的清除操作，类结束后只执行一次')

    def test_1(self):
        self.assertTrue(1==1)

    @unittest.skip('skip跳过') #跳过这个测试用例
    def test_2(self):
        self.assertTrue(1==2)

    def test_3(self):
        self.assertEqual(1,1)

    @unittest.skipIf(1==1,'skipIf条件为真时跳过')   #条件为真时，跳过这个测试用例
    def test_4(self):
        self.assertEqual(1,2)

    @unittest.skipUnless(0,'skipUnless条件为假时跳过')  #条件为假时，跳过这个测试用例
    def test_5(self):
        self.assertEqual(3,4)


if __name__ == "__main__":
    unittest.main()
    #有三种方式：
    # 第一种unittest.main()执行本文件中的所有测试用例
    #第二种，添加到testsuit()套件中中，添加部分，或者添加全部，手动添加比较麻烦
"""     1.本文件添加到套件
        suite = unittest.TestSuite()
        suite.addTest(Demo("test_3"))   #只添加第三个测试用例
        runner = unittest.TextTestRunner()
        runner.run(suite)
         2.从外部导入后再添加到套件
        如果是从其他地方导入的用例
        case_01 = unittest.TestLoader().loadTestsFromTestCase(Test_case01)
        case_02 = unittest.TestLoader().loadTestsFromTestCase(Test_case02)
        case_03 = unittest.TestLoader().loadTestsFromTestCase(Test_case03)
        suite = unittest.TestSuite([case_01, case_02, case_03])  # 添加到套件里面
        unittest.TextTestRunner().run(suite)  # 执行所有的
"""
    #第三种  通过 unittest.defaultTestLoader.discocer()
"""
    discover = unittest.defaultTestLoader.discover(".",pattern='test*.py')
    runner = unittest.TextTestRunner()
    runner.run(discover)
"""
