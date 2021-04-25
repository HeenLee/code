package com.hollysys.test.base.ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.hollysys.test.base.Config;

public class Browser 
{
	/**
	 * 构造器
	 */
	public Browser()
	{
		
	}
	
	private Config config = new Config();
	//创建web驱动
	private  WebDriver webDriver;
	
	//获取浏览器驱动类型
/*	public  Browser getWebDriver()
	{
		if("chrome".equals(config.getBrowserType())){
			System.setProperty("chrome", config.getDriver_path() + "chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		else if("ie".equals(config.getBrowserType()))
		{
			System.setProperty("ie", config.getBrowserType() + "IEDriverServer.exe");
			webDriver = new InternetExplorerDriver();
		}
		else if("firefox".equals(config.getBrowserType()))
		{
			System.setProperty("chrome", config.getBrowserType() + "geckodriverdricer.exe");
			webDriver = new FirefoxDriver();
		}else{
			System.out.println("浏览器不存在");
		}
		return this;
	}*/
	
	//开启浏览器
	public void open(String url)
	{
		webDriver.get(url);
	}
	
	//关闭浏览器
	public void close()
	{
		webDriver.close();
	}
	
	//退出浏览器
	public void quit()
	{
		webDriver.quit();
	}
	
	//获取浏览器方法
	public void getCurrentUrl()
	{
		webDriver.getCurrentUrl();
	}
	
	//获取浏览器标题
	public String getTitle()
	{
		return webDriver.getTitle();
	}
	
	//下面8个方法获取单个元素
	public WebElement findElementById(String id)
	{
		return webDriver.findElement(By.id(id));
	}
	
	public WebElement findElementByName(String name )
	{
		return webDriver.findElement(By.name(name));
	}
	
	public WebElement findElementByClassName(String className)
	{
		return webDriver.findElement(By.className(className));
	}
	
	public WebElement findElementByTagName(String tagName)
	{
		return webDriver.findElement(By.tagName(tagName));
	}
	
	public WebElement findElementByXpath(String xpath)
	{
		return webDriver.findElement(By.xpath(xpath));
	}
	
	public WebElement findElementByCssSelector(String cssSelector)
	{
		return webDriver.findElement(By.cssSelector(cssSelector));
	}
	
	public WebElement findElementByLinkText(String linkText)
	{
		return webDriver.findElement(By.linkText(linkText));
	}
	
	public WebElement findElementByPartialLinkText(String partialLinkText)
	{
		return webDriver.findElement(By.partialLinkText(partialLinkText));
	}
	
	//下面8个方法获取元素列表
	public List<WebElement> findElementsById(String id)
	{
		return webDriver.findElements(By.id(id));
	}
	
	public List<WebElement> findElementsByName(String name )
	{
		return webDriver.findElements(By.name(name));
	}
	
	public List<WebElement> findElementsByClassName(String className)
	{
		return webDriver.findElements(By.className(className));
	}
	
	public List<WebElement> findElementsByTagName(String tagName)
	{
		return webDriver.findElements(By.tagName(tagName));
	}
	
	public List<WebElement> findElementsByXpath(String xpath)
	{
		return webDriver.findElements(By.xpath(xpath));
	}
	
	public List<WebElement> findElementsByCssSelector(String cssSelector)
	{
		return webDriver.findElements(By.cssSelector(cssSelector));
	}
	
	public List<WebElement> findElementsByLinkText(String linkText)
	{
		return webDriver.findElements(By.linkText(linkText));
	}
	
	public List<WebElement> findElementsByPartialLinkText(String partialLinkText)
	{
		return webDriver.findElements(By.partialLinkText(partialLinkText));
	}
	
	public Alert witchToAlert()
	{
		return webDriver.switchTo().alert();
	}
	
	public WebDriver witchToFrame(String name)
	{
		return webDriver.switchTo().frame(name);
	}
	
	public WebDriver witchToWindow(String name)
	{
		return webDriver.switchTo().window(name);
	}
	
	public Timeouts implicitlyWait(long l, TimeUnit timeunit){
		return webDriver.manage().timeouts().implicitlyWait(l, timeunit);
	}
	

	
	

	
	
	
	
	

	
	
	
	

	
	

}
