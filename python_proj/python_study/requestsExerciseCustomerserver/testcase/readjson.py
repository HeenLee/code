import json
import logging.config
import os
def set(default_path,default_level=logging.INFO,env_key='log_cfg'):
    if os.path.exists(default_path):
        with open(default_path,'r') as f:
            config = json.load(f)
            logging.config.dictConfig(config)
    else:
        logging.basicConfig(level=default_level)

def func():
    logging.info("start")
    logging.info('exec')
    logging.info('end')

if __name__ == '__main__':
    path = os.path.dirname(os.getcwd()) + '/conf.json'
    set(path)
    func()