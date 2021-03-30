package com.hollysys.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSON;
/**
 * 配置类
 *
 */
public class Config 
{
	/**
	 * 服务地址
	 */
	private String address;
	
	/**
	 * 服务地址
	 */
	private String ops;
	
	/**
	 * http请求类型
	 */
	private boolean isHttps = true;
	
	/**
	 * 创建properties对象
	 */
	private Properties properties = new Properties();
	
	/**
	 * 项目根路径
	 */
	private static String base_path = System.getProperty("user.dir") + File.separator;
	
	/**
	 * 访问服务配置文件
	 */
	private static String service_path = base_path + "config" + File.separator + "service.xml";
	
	/**
	 * 获取服务地址
	 */
	public String getAddress() 
	{
		return this.properties.getProperty("address");
	}

	/**
	 * 设置服务地址
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * 获取服务地址
	 */
	public String getOps() 
	{
		return this.properties.getProperty("ops");
	}

	/**
	 * 设置服务地址
	 */
	public void setOps(String ops) 
	{
		this.ops = ops;
	}

	/**
	 * 设置http请求类型
	 */
	public boolean isHttps() 
	{
		return Boolean.parseBoolean(this.properties.getProperty("isHttps"));
	}

	/**
	 * 设置http请求类型
	 */
	public void setHttps(boolean isHttps) 
	{
		this.isHttps = isHttps;
	}
	
    /**
     * 从配置文件中读取参数并保存到properties对象中
     * @throws FileNotFoundException 
     */
    public void load() {
        SAXReader sax = new SAXReader();
        Document document;
		try 
		{
			//讀取xml文件
			document = sax.read(new FileInputStream(service_path));
	        Element rootElement = document.getRootElement();
	        Iterator<?> iterator = rootElement.elementIterator();
	        while (iterator.hasNext())
	        {
	            Element elements = (Element)iterator.next();
	            String name = elements.attribute("name").getValue();
	            String value = elements.attribute("value").getValue();
	            properties.setProperty(name, value);
	            
	        }
		} catch (DocumentException e) 
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
    }

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
