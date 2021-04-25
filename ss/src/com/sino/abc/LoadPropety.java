package com.sino.abc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class LoadPropety {

	public static void main(String[] args) throws IOException {
		 String confDir = System.getProperty("user.dir") + File.separator + 			
 				"conf" + File.separator ;
		InputStream is = new BufferedInputStream(new FileInputStream(confDir + "user.properties"));
		Properties pro = new Properties();
		
		pro.load(is);
		
		Iterator<String> it = pro.stringPropertyNames().iterator();
		while(it.hasNext()){
		   String key=it.next();
           System.out.println(key+":"+pro.getProperty(key));
		}
		
	}

}
