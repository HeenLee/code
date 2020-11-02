package com.study;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMd5 {
	public static String getMd5(String plainText){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte[] b = md.digest();
//			int i;
//			StringBuffer sb = new StringBuffer("");
//			for(int offset = 0;offset<b.length;offset++){
//				i = b[offset];
//				if(i<0){
//					i+= 256;
//				}
//				if(i<16){
//					sb.append("0").append(Integer.toHexString(i));
//				}
				
//			}
	        String hexString = toHexString(b);
	        return  hexString;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
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


