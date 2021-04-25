package com.hollysys.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.alibaba.fastjson.JSON;

public class Config 
{	
	/**
	 * 浏览器类型
	 */
	private String browserType;
	
	
	private Properties properties = new Properties();
	
	/**
	 * 项目根路径
	 */
	private static String base_path = System.getProperty("user.dir") + File.separator;
	
	/**
	 * 浏览器配置文件
	 */
	private static String browser_path = base_path + "config" + File.separator + "browser.properties";
	
	/**
	 * 驱动器地址
	 */
	private  String driver_path = base_path + "env" + File.separator;
	
	/**
	 * 获取浏览器类型
	 */
	public String getBrowserType() 
	{
		return this.properties.getProperty("browserType");
	}

	public void setBrowserType(String browserType)
	{
		this.browserType = browserType;
	}
	
	public String getDriver_path() 
	{
		return driver_path;
	}

	public void setDriver_path(String driver_path) 
	{
		this.driver_path = driver_path;
	}

	/**
	 * 加载配置文件
	 */
	public void load()
	{
		try 
		{
			this.properties.load(new FileInputStream(browser_path));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
