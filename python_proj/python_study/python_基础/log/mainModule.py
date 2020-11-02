#! _*_ coding:utf8 _*_
"""
多级模块使用日志，关键要用getLogger(name)来区分
                         getLogger(name.subname)
                         getLogger(name.subname.subname) 都会使用顶级的日志形式
"""
import logging
from python_基础.log import subModule

logger = logging.getLogger('mainModule')
logger.setLevel(logging.INFO)
handler = logging.FileHandler('log.txt')
handler.setLevel(logging.INFO)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
handler.setFormatter(formatter)

console = logging.StreamHandler()
console.setLevel(logging.INFO)
console.setFormatter(formatter)

logger.addHandler(handler)
logger.addHandler(console)

logger.info("创建子模块的实例")
a = subModule.SubModuleClass()
logger.info('call dosomething')
a.doSomething()
subModule.som_function()

