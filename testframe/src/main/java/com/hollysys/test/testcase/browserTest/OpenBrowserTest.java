package com.hollysys.test.testcase.browserTest;

import org.junit.Test;

import com.hollysys.test.base.TestEnv;
import com.hollysys.test.base.ui.Browser;

public class OpenBrowserTest {
	@Test
	public void testOpen() throws InterruptedException{
		Browser browser = TestEnv.getBrowser().getWebDriver("chrome");
		browser.open("http://www.baidu.com");
		browser.findElementById("kw").sendKeys("hello");
		browser.findElementById("su").click();
		Thread.sleep(2000);
		browser.quit();
//		Assert.assertEquals("hello", "");
		
	}
}
