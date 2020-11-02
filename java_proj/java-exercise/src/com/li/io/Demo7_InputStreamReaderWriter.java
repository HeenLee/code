package com.li.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo7_InputStreamReaderWriter {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(new FileInputStream("d:/a.txt"), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}

}
