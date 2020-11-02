package com.base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static final String DEFAULT_FILE_PATH = 
			System.getProperty("user.dir") + File.separator + "conf" + File.separator;
	
	private static final String CONF_NAME = "config.properties";
	private Properties mProperties;
	
	public Properties getProperties(String path) throws IOException{
		Properties prop = new Properties();
		InputStream is = new BufferedInputStream(new FileInputStream(DEFAULT_FILE_PATH + path ));
		prop.load(is);
		is.close();
		return prop;
	}
	public String getBPAddress() throws IOException{
		mProperties = getProperties(CONF_NAME);
		return this.mProperties.getProperty("bplusAddress");
	}
	
	public String getYQTAddress() throws IOException{
		mProperties = getProperties(CONF_NAME);
		return this.mProperties.getProperty("yqtAddress");
	}
	

	 
	

	
}
