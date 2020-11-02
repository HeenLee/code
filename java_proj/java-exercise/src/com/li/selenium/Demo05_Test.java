package com.li.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 * @author lihe
 *
 */
public class Demo05_Test {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		chrome.get("http://www.baidu.com");
		
		WebElement text = chrome.findElement(By.id("kw"));
		/*	text.sendKeys("java");
		//submit()方法用于提交表单。 例如，在搜索框输入关键字之后的“回车” 操作， 就可以通过 submit()方法模拟
		text.submit();
		
		//getSize() 返回元素的尺寸
		System.out.println(text.getSize());*/
		
		//getText() 获取元素的文本
		System.out.println(chrome.findElement(By.id("cp")).getText());
		
		//getAttribute(name) 获得属性值
		System.out.println(text.getAttribute("type"));
		
		//isDisplayed() 设置该元素是否用户可见
		System.out.println(text.isDisplayed());
		
		
				

	}

}
