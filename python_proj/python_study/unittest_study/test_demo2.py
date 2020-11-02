import unittest

class Demo(unittest.TestCase):
    def setUp(self):
        print("初始化")

    def tearDown(self):
        print("清除操作")

    def test_1(self):
        self.assertTrue(1==1)

    def test_2(self):
        self.assertTrue(1==2)

if __name__ == "__main__":
    unittest.main()