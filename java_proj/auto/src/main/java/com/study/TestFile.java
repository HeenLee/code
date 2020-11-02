package com.study;

import java.io.File;
import java.io.IOException;

/**
 * 
 *
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		File file = new File("d:/hello.txt");
		boolean b = file.createNewFile();
		File file1 = File.createTempFile("aaa", ".txt");
		System.out.println(b);
	}

}
