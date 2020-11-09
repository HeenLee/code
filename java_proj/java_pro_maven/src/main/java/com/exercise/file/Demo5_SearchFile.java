package com.exercise.file;

import java.io.File;
import java.io.FilenameFilter;

public class Demo5_SearchFile {

	public static void main(String[] args) {
		File f = new File("D:\\test\\learngit");
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("a");
			}
		};
		String[] children = f.list(filter);
		if(children == null){
			System.out.println("either dir does not exist or is not a directory");
		}
		else{
			for (int i = 0; i < children.length; i++) {
				String filename = children[i];
				System.out.println(filename);
			}
		}
		
	}

}
