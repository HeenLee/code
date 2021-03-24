package com.hollysys.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSON;

public class Config 
{
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * http请求类型
	 */
	private boolean isHttps = true;
	
	/**
	 * 项目根路径
	 */
	private String base_path = System.getProperty("user.dir") + File.separator;
	
	/**
	 * 浏览器配置文件
	 */
	private String browser_path = base_path + "config" + File.separator + "browser.properties";
	
	/**
	 * 访问服务配置文件
	 */
	private String service_path = base_path + "config" + File.separator + "service.xml";
	
	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public boolean isHttps() {
		return isHttps;
	}

	public void setHttps(boolean isHttps) {
		this.isHttps = isHttps;
	}

	/**
	 * 加载配置文件
	 * @param filename
	 */
	public void loadProperties(String filename){
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(filename));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    /**
     * 从配置文件中读取参数并保存到Config类中
     * @throws FileNotFoundException 
     */
    public  Config loadConfig() throws DocumentException, FileNotFoundException {
        Config config = new Config();
        SAXReader sax = new SAXReader();
        Document document = sax.read(new FileInputStream(service_path));
        Element rootElement = document.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element elements = iterator.next();
            Iterator<Element> it = elements.elementIterator("attribute");
            while(it.hasNext()){
            	Element element = it.next();
                String address = element.attributeValue("value");
                config.setAddress(address);
            }
           

        }
        return config;
    }

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
