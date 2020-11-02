package com.sinosun.md5;

import java.security.MessageDigest;
  
public class TestMD5 {  
    public static void main(String[] args) throws Exception {      
        //测试      
        System.out.println(TestMD5.getMd5("hello"));  
    }  
  
    //静态方法，便于作为工具类  
    public static String getMd5(String plainText) throws Exception {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
  
            String hexString = toHexString(b);
            return  hexString;
        }  
  

		/**
		 * 将字节数组转换成16进制的字符串
		 * @param bytes
		 * @return
		 */
		public static String toHexString(byte[] bytes){
		    StringBuffer sb = new StringBuffer();
		    for(byte b: bytes){
		        String hex = Integer.toHexString(b & 0x0FF);
		        if(hex.length()==1) hex = "0" + hex;
		        sb.append(hex);
		    }
		    return sb.toString();
		}
		      
		
		}
