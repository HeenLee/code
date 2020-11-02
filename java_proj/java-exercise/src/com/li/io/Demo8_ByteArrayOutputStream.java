package com.li.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo8_ByteArrayOutputStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		FileInputStream fis = new FileInputStream("d:/a.txt");
		int len = 0;
		while((len = fis.read()) != -1){
			baos.write(len);
		}
		System.out.println(baos.toString());
		byte[] arr = baos.toByteArray();
		System.out.println(new String(arr));
		fis.close();
	}

}
