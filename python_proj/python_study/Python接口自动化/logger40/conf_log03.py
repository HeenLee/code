#coding-utf-8
import logging.config

logging.config.fileConfig("logger.conf")
logger = logging.getLogger("example02")

logger.debug("this i debug message")
logger.info("this is info message")
logger.warning("this is warning message")