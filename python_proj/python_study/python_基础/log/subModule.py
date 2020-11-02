import logging
module_logger = logging.getLogger("mainModule.sub")

class SubModuleClass():
    def __init__(self):
        self.logger = logging.getLogger('mainModule.sub.module')
        self.logger.info('in subModuleClass')
    def doSomething(self):
        self.logger.info('do something')
def som_function():
    module_logger.info('call func')