package com.li.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2_FileOutputStream {

	public static void main(String[] args) throws IOException {
		File file = new File("d:/abcdef.txt");
		FileInputStream fis = new FileInputStream(file);
		
		FileOutputStream fos = new FileOutputStream("d:/c.txt");
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=fis.read(arr)) != -1){
			fos.write(len);
		}
		fis.close();
		fos.close();
	}

}
