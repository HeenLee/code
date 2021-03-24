package com.hollysys.test.base;

import com.hollysys.test.base.request.HttpClientWrapper;
import com.hollysys.test.base.ui.Browser;

public class TestEnv 
{
	//创建浏览器对象
	private static Browser BROWSER = new Browser();
	
	//创建配置对象
	private static Config CONFIG = new Config();
	
	public static Browser getBrowser(){
		return BROWSER;
	};
	
	public static Config getConfig(){
		return CONFIG;
	}
	
	public String getAddress(){
		return CONFIG.getAddress();
	}
	
	public static HttpClientWrapper newHttpClient(){
		return new HttpClientWrapper();
	}
	
	
	
}
