package com.li.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo5_FileReaderWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(new File("d:/ch1.txt"));
		FileWriter fw = new FileWriter(new File("d:/xxx.txt"));
		char[] b = new char[1024];
		while((fr.read(b)) != -1){
			System.out.println(new String(b));
		}
		
		fw.write("hello".toCharArray());
		fw.write("\r\n");
		fw.write(97);
		fw.write("\r\n");
		fw.write("中国人");
		fr.close();
		fw.close();
		
	}

}
