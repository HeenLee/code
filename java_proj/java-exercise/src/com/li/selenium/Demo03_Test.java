package com.li.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 控制浏览器操作
 * 1.控制浏览器窗口大小
 *	 maximize() 设置浏览器最大化
	 setSize() 设置浏览器宽高
   2.控制浏览器后退、前进
     back() 模拟浏览器后退按钮
	 forward() 模拟浏览器前进按钮
 * @author lihe
 *
 */
public class Demo03_Test {
	public static void main(String[] args) throws InterruptedException {
		//setSize();
		setBack();
	}
	
    /**
     * 设置浏览器大小
     * @throws InterruptedException
     */
	private static void setSize() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		chrome.get("http://www.baidu.com");
		chrome.manage().window().maximize();
		Thread.sleep(2000);
		
		chrome.get("https://m.baidu.cn");
		chrome.manage().window().setSize(new Dimension(480,800));
		Thread.sleep(2000);
		
		chrome.quit();
	}
	
	/**
	 * 控制浏览器前进 后退
	 * @throws InterruptedException
	 */
	public  static void setBack() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		chrome.get("https://www.baidu.com");
		//get到百度首页
		System.out.println("now access:" + chrome.getCurrentUrl());
		Thread.sleep(2000);
		
		//搜索hello
		chrome.findElement(By.id("kw")).sendKeys("hello");
		chrome.findElement(By.id("su")).click();
		System.out.println("now access:" +chrome.getCurrentUrl());
		Thread.sleep(2000);
		
		//执行浏览器后退
		chrome.navigate().back();
		System.out.println("back to:" +chrome.getCurrentUrl());
		Thread.sleep(2000);
		
		//执行浏览器向前
		chrome.navigate().forward();
		System.out.println("forward to:" +chrome.getCurrentUrl());
		Thread.sleep(2000);
		
		//刷新页面
		chrome.navigate().refresh();
		
		chrome.quit();
	}
	
	
}
