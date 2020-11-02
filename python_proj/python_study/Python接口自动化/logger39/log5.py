# coding=utf-8
"""
捕获traceback
"""
import logging

logger = logging.getLogger(__name__)
logger.setLevel(level=logging.INFO)

handler = logging.FileHandler('log.txt')
handler.setLevel(logging.INFO)

formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
handler.setFormatter(formatter)

console = logging.StreamHandler()
console.setLevel(logging.INFO)

logger.addHandler(handler)
logger.addHandler(console)

logger.info("start print log")
logger.debug("do something")
logger.warning("something maybe fail")

try:
    open("sklearn.txt", "rb")
except (SystemExit, KeyboardInterrupt):
    raise
except Exception:
    logging.error("failed to open skiearn.txt from logger.error", exc_info=True)

logger.info("finish")
