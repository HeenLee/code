import threading
from time import ctime,sleep

from selenium import webdriver


def test_baidu(browser,search):
    global driver
    print("start:%s" % ctime)
    print("browser:%s" % browser)
    if browser == "ie":
        driver = webdriver.Ie()
    elif browser == "chrome":
        driver = webdriver.Chrome()
    elif browser == "ff":
        driver = webdriver.Firefox()
    else:
        print("browser only ie/ff/chrome")
    driver.get("http://www.baidu.com")
    driver.find_element_by_id("kw").send_keys(search)
    driver.find_element_by_id("su").click()
    sleep(2)
    driver.quit()


if __name__ == "__main__":
    lists = {"chrome":"threading","ie":"webdriver","ff":"python"}
    threads = []
    file = range(len(lists))
    for browser,search in lists.items():
        t = threading.Thread(target=test_baidu,args=(browser,search))
        threads.append(t)
    for t in file:
        threads[t].start()
    for t in file:
        threads[t].join()
    print("end:%s" % ctime())
