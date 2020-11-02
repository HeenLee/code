package com.li.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1_ComparePath {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file1 = new File("d:/a.txt");
		File file2 = new File("d:/work/a.txt");
		
		if(file1.compareTo(file2) == 0){
			System.out.println("路径相同");
		}
		else{
			System.out.println("not same");
		}
		
		long time = file1.lastModified();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		
		//
		File file3 = new File("d:/hello.txt");
		if(file3.createNewFile()){
			System.out.println("success");
		}else{
			System.out.println("file already exists");
		}
		
		File file4 = File.createTempFile("tmp", ".txt",new File("d:/"));
		System.out.println(file4.getPath());
		
		System.out.println(file4.exists());
		
		File file5 = new File(System.getProperty("user.dir") + "/folder/file.txt");
		if(!file5.getParentFile().exists()){
			file5.getParentFile().mkdirs();
		}
		if(!file5.exists()){
			file5.createNewFile();
		}
		File dir = new File(file5.getParentFile(),file5.getName());
		System.out.println(dir.mkdir());
		
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getAbsolutePath());
	}
	
}
