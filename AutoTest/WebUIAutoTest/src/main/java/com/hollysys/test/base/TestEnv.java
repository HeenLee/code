package com.hollysys.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.hollysys.test.base.ui.Browser;


public class TestEnv 
{ 
	/*
	 * 私有构造
	 */
	private TestEnv()
	{
		
	}
	
	/**
	 * 创建单例TestEnv对象
	 */
    private static TestEnv instance = new TestEnv();
    
	/**
	 * 创建浏览器对象
	 */
	private static Browser browser = new Browser();
	
	/**
	 * 创建配置类对象
	 */
	private static Config config = new Config();
	
	/**
	 * webDriver对象
	 */
	private static WebDriver webDriver;
	
	/**
	 * 浏览器对象
	 */
	public static Browser getBrowser()
	{
		return browser;
	};
	
	/**
	 * 配置类对象
	 */
	public static Config getConfig()
	{
		return config;
	}
	
	/**
	 * 加载配置文件
	 */
	public void init(){
		config.load();
	}
	
	/**
	 * 获取webDriver对象
	 */
	public  static WebDriver getWebDriver()
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
		return webDriver;
	}
	
	/**
	 * 静态代码块
	 */
	static 
	{
		instance.init();
	}
}
