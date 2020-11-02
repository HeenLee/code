package com.li.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_HandleChineseFileInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(new File("d:/ch.txt"));
		
		FileOutputStream fos = new FileOutputStream("d:/ch1.txt");
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=fis.read(arr)) != -1){
			System.out.println(len);
			String s = new String(arr,0,len);
			System.out.println(s);
		}
		
		String str = "中国人";
		fos.write(str.getBytes("utf-8"));
		fis.close();
		fos.close();
		
	}

}
