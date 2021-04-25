package com.hollysys.test.testcase.ui.pageA;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.hollysys.test.base.TestEnv;

public class OpenBrowserTest {
	@Test
	public void testOpen() throws InterruptedException{
		
		WebDriver webdriver = TestEnv.getWebDriver();
		webdriver.get("http://www.baidu.com");
		webdriver.close();
		Thread.sleep(2000);
		webdriver.quit();
//		Assert.assertEquals("hello", "");
		
	}
}
