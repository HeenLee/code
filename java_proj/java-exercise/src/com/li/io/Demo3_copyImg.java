package com.li.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 复制图片
 * @author lihe
 *
 */
public class Demo3_copyImg {

	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		File file = new File(path,"/mount.jpg");
		FileInputStream fis = new FileInputStream(file);
		
		FileOutputStream fos = new FileOutputStream("copy.jpg");
		byte[] arr = new byte[1024*8];
		int len= 0;
		while((len=fis.read(arr)) != -1){
			fos.write(arr,0,len);
		}
		fis.close();
		fos.close();
	}

}
