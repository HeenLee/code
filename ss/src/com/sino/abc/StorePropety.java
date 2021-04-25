package com.sino.abc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class StorePropety {

	public static void main(String[] args) throws IOException {
		 String confDir = System.getProperty("user.dir") + File.separator + 			
 				"conf" + File.separator ;
		OutputStream os = new FileOutputStream(confDir + "user.properties");
		Properties pro = new Properties();
		for(int i = 0; i<100; i++){
			pro.setProperty("mstp_test_poc_" + i, "" + i);
		}
		
		pro.store(os, "pro");
		os.close();
		
		
	}

}
