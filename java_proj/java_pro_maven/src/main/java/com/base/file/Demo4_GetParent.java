package com.base.file;

import java.io.File;
import java.io.IOException;
/**
 * getPath()
 * @author lihe
 *
 */
public class Demo4_GetParent {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\test\\learngit\\Java");
		System.out.println(file.getParent());  //D:\test\learngit
		System.out.println(file.getPath());  //D:\test\learngit\Java
		System.out.println(file.getParentFile()); //D:\test\learngit 
		System.out.println(file.getCanonicalPath());//D:\test\learngit\Java
		System.out.println(file.getAbsolutePath());//D:\test\learngit\Java
		//显示当前目录
		String path = System.getProperty("user.dir") + File.separator + "hahah.txt";
		System.out.println(path);
		
		//显示根目录
		File[] fileArr = File.listRoots();
		for (int i = 0; i < fileArr.length; i++) {
			System.out.println(fileArr[i]);
		}
	}

}
