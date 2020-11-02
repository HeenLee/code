from test1.browser_engine import BrowserEngine

class TestBrowserEngine(object):
    def open_browser(self):
        browser_engine = BrowserEngine(self)
        driver = browser_engine.get_browser()


tbe = TestBrowserEngine()
tbe.open_browser()