package com.base.文件;
/**
 * 打印目录层级结构  利用listFiles() 遍历 加 递归
 */
import java.io.File;

public class Demo3_PrintDirStructor {

	public static void main(String[] args) {
		File file = new File("d:/test");
		showDir(file);
	}
	
	//打印目录下所有的文件及文件夹
	public static void showDir(File file){
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()){
				showDir(files[i]);
			}
			System.out.println(files[i].getName());
		}
	}
}
