#coding=utf-8
import logging
import father_sonModule02
#定义父类的logger  任何以fatherModule开头的都是他的子logger，例如子类中的fatherModule.son
logger = logging.getLogger("fatherModule")
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

logger.info("create an instance of sonModule.sonModuleClass")
a = father_sonModule02.SonModuleClass()
logger.info("calling son Module.sonModuleClass.doSomething")
a.doSomething()
logger.info("done with sonModule.sonModuleClass.doSomething")
logger.info("calling sonModule.some_function")

father_sonModule02.som_function()

logger.info("done with sonModule.some_function")

"""
首先在父模块定义了logger'fatherModule'，并对它进行了配置，就可以在解释器进程里面的其他地方通过
getLogger('fatherModule')得到的对象都是一样的，不需要重新配置，可以直接使用。定义的该logger的子logger，
都可以共享父logger的定义和配置，所谓的父子logger是通过命名来识别，任意以'fatherModule'开头的logger都是它的子logger
，例如'fatherModule.son'。

　　实际开发一个application，首先可以通过logging配置文件编写好这个application所对应的配置，可以生成一个根logger，
如'PythonAPP'，然后在主函数中通过fileConfig加载logging配置，接着在application的其他地方、不同的模块中，可以使用根
logger的子logger，如'PythonAPP.Core'，'PythonAPP.Web'来进行log，而不需要反复的定义和配置各个模块的logger。
"""
