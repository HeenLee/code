package com.li.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 元素定位的八种方式
 * @author lihe
 *
 */

public class Demo02_Test {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		chromeDriver.get("https://www.baidu.com");
		
//		chromeDriver.findElement(By.id("kw")).sendKeys("java");
//		chromeDriver.findElement(By.id("su")).click();
		
//		chromeDriver.findElement(By.name("wd")).sendKeys("c");
//		chromeDriver.findElement(By.id("su")).click();

		
//		chromeDriver.findElement(By.className("s_ipt")).sendKeys("c++");
//		chromeDriver.findElement(By.id("su")).click();

		
//		chromeDriver.findElement(By.tagName("input")).sendKeys("mat");
//		chromeDriver.findElement(By.id("su")).click();

		
//		chromeDriver.findElement(By.linkText("hao123")).click();

		
//		chromeDriver.findElement(By.partialLinkText("123")).click();

		
		chromeDriver.findElement(By.cssSelector("#kw")).sendKeys("perl");
		chromeDriver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		chromeDriver.quit();
		
//		chromeDriver.findElement(By.xpath("//*[@id='kw']")).sendKeys("r");
//		chromeDriver.findElement(By.id("su")).click();
		
	}

}
