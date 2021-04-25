package com.hollysys.test.base;

import com.hollysys.test.base.ui.Browser;

public class TestEnv 
{ 
	private static Config config = new Config();
	/*
	 * 私有构造
	 */
	private TestEnv(){
		
	}
	
	private void init(){
		config.load();
		
		
	}
	
	//创建单例TestEnv对象
    private static TestEnv INSTANCE = new TestEnv();
    
	
	//创建浏览器对象
	private static Browser browser = new Browser();
	
	
	public static Browser getBrowser(){
		return browser;
	};
	
	
	public static Config config(){
		return config;
	}
	
	static{
		INSTANCE.init();
	}
	
	
	
}
