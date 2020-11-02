package com.li.directory;

import java.io.File;
/**
 * file.list()返回"字符串"数组，是文件名称。
 * file.listFiles()返回是的"File"数组，是完整路径
 */

public class Demo1_DeleteDir {

	public static void main(String[] args) {

        String deldir = "D:/yk_temp";
        deleteDir(new File(deldir));
        //getName(new File(deldir));
    }

	//删除某个路径下所有的文件  思路：先删除文件下面的，再删除空文件。
	//利用list或者listFiles找出子路径，然后再遍历子路径，递归删除
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(children[i]);
                if (!success) {
                    return false;
                }
            }
        }
        System.out.println("The directory is deleted.");
        //上面删除完路径下面的，最后删除空文件夹
        return dir.delete();
    }
    public static void getName(File dir){
        if (dir.isDirectory()) {
            String[] children = dir.list();
            
            for (int i = 0; i < children.length; i++) {
            	System.out.println(children[i]);
            	
            	
            }
           }
    }
}
