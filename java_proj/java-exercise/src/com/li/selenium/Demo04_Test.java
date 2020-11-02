package com.li.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * WebDriver常用方法
 * clear() 清楚文本
 * sendKeys()模拟按键输入
 * click()单击元素  不仅仅用于单击一个按钮，它还可以单击任何可以单击的文字/图片链接、复选框、单选框、下拉框等
 * @author lihe
 *
 */
public class Demo04_Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		chrome.get("http://www.baidu.com");
		
		WebElement text = chrome.findElement(By.id("kw"));
		text.sendKeys("java");
		Thread.sleep(2000);
		text.clear();
		
		Thread.sleep(2000);
		text.sendKeys("selenium");
		chrome.findElement(By.id("su")).click();
		
		//chrome.quit();

	}

}
