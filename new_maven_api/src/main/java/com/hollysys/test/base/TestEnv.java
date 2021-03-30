package com.hollysys.test.base;

import com.alibaba.fastjson.JSONObject;
import com.hollysys.test.base.http.HttpClientWrapper;

public class TestEnv 
{ 
	/**
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
     * 创建单例httpClient对象
     */
    private HttpClientWrapper httpClient = new HttpClientWrapper();
	
    /**
     * 创建单例config对象
     */
	private static Config config = new Config();
	
	/**
	 * 加载service.xml配置
	 */
	private void init()
	{
		config.load();
	}
	
	/**
	 * httpClient客户端
	 */
	public static HttpClientWrapper httpClient()
	{
		return instance.httpClient;
	}
	
	/**
	 * 配置类对象
	 */
	public static Config getConfig()
	{
		return config;
	}
	
	/**
	 * 静态代码块，优先执行加载配置
	 */
	static{
		instance.init();
	}
	
	/**
	 * 解析json,获取值
	 */
	public static String getString(JSONObject json, String key)
	{
		return json.getString(key);
	}
	
	/**
	 * 解析json数组,获取值
	 */
	public static String getString(JSONObject[] arr , String key)
	{
		String value = null;
		for (JSONObject jsonObj : arr) {
			value = jsonObj.getString(key);
		}
		return value;
	}
	
	
}
