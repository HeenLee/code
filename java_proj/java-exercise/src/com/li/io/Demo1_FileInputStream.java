package com.li.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo1_FileInputStream {

	public static void main(String[] args) throws IOException {
		File file = new File("d:/hello.txt");
		
		FileInputStream fis = new FileInputStream(file);
		 
		byte[] arr = new byte[1024];
		int len = 0;
		 while((len = fis.read(arr)) != -1){
			 System.out.println(len);
		 }
		 fis.close();
	}

}
