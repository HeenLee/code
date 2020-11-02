package com.li.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo6_BufferReaderWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("d:/xxx.txt"));
		
		BufferedWriter	bw = new BufferedWriter(new FileWriter("d:/new.txt"));
		String line;
		while((line=br.readLine()) != null){
			System.out.println(line);
		}
		bw.write("你好");
		bw.newLine();
		bw.write("用户");
		bw.newLine();
		br.close();
		bw.close();
		
	}

}
