package com.base.file;

import java.io.File;

public class Demo2_FileMethod {

	public static void main(String[] args) {
		//创建文件对象的三种方式
		File file1 = new File("D:/test");
		File file2 = new File("d:/test","test.txt");//隐藏文件
		File file3 = new File(new File("d:/"),"test");
		
		System.out.println(file1);
		System.out.println(file2);
		System.out.println(file3);
		
		//1.isHidden()
		System.out.println(file2.isHidden());
	}

}
