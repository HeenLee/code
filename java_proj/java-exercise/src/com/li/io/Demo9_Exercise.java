package com.li.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo9_Exercise {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //1.文件输入流
        FileInputStream fis = new FileInputStream("d:/a.txt");
        
        //2.字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        //3.字节数组【缓冲区思想，杯子思想】
        byte[] arr = new byte[5];
        int len;
        while((len = fis.read(arr)) != -1) {
            //通过字节缓冲数组写入
            baos.write(arr,0,len);
            
            //把字节转成字符串
            /**
             * 中文乱码问题
             */
            System.out.println(new String(arr,0,len));
        }
        //内部会调用toString方法,把字节数组转成字符串
        System.out.println(baos);
        
        InputStream ps = System.in;
        ps.read();
        fis.close();
	}

}
