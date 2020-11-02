package com.study;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInoutStream {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("d:/test/abc.txt");
		for (int i = 0; i < 10; i++) {
			fos.write(("hello" + i).getBytes());
			fos.write("\r\n".getBytes());
			fos.write(12);
		}
		fos.close();
	}

}
